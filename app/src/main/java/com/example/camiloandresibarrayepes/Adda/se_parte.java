package com.example.camiloandresibarrayepes.Adda;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.example.camiloandresibarrayepes.pruebafoto3.R;

        import java.util.HashMap;
        import java.util.Map;


public class se_parte extends AppCompatActivity {

    EditText firstname, lastname, email;
    Button insert, show;
    RequestQueue requestQueue;
    String insertUrl = "http://yamgo.com.co/adda/registro.php";
    ProgressDialog progressDialog;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_parte);

        progressDialog = new ProgressDialog(this);

        firstname = (EditText) findViewById(R.id.nombre);
        lastname = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        insert = (Button) findViewById(R.id.insert);


        requestQueue = Volley.newRequestQueue(getApplicationContext());


        insert.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                if(lastname.getText().toString().isEmpty())
                {
                    Toast.makeText(se_parte.this, "Escribe un telefono", Toast.LENGTH_SHORT).show();
                }else if(firstname.getText().toString().isEmpty()) {
                    Toast.makeText(se_parte.this, "Escribe tu nombre", Toast.LENGTH_SHORT).show();
                }else if(email.getText().toString().isEmpty()) {
                    Toast.makeText(se_parte.this, "Escribe un Email", Toast.LENGTH_SHORT).show();
                }else{

                    progressDialog.setMessage("Registrando...");
                    progressDialog.show();
                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                            Toast.makeText(se_parte.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            firstname.setText("");
                            lastname.setText("");
                            email.setText("");
                            Intent intent = new Intent(getApplicationContext(), registro_gracias.class)/*.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)*/;
                            startActivity(intent);

                        }


                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();
                            parameters.put("nombre",firstname.getText().toString());
                            parameters.put("telefono",lastname.getText().toString());
                            parameters.put("email",email.getText().toString());



                            return parameters;
                        }
                    };
                    requestQueue.add(request);

                }




            }

        });


    }

}