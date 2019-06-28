package com.openhack.market30;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONObject;


public class LoginActivity extends Activity {
    private AlertDialog dialog;
    public static String login_id, login_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = null;
        login_pwd = null;

        final EditText id_txt = (EditText) findViewById(R.id.id_txt);
        final EditText pwd_txt = (EditText) findViewById(R.id.pwd_txt);
        final Button login_btn = (Button) findViewById(R.id.login_btn);
        TextView forget = (TextView) findViewById(R.id.forget_btn);
        TextView signUp = (TextView) findViewById(R.id.signup_btn);
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String userId = id_txt.getText().toString();
//                String userPwd = pwd_txt.getText().toString();
//
//                if (userId.equals("")) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    dialog = builder.setMessage("Input id, please")
//                            .setNegativeButton("Check", null)
//                            .create();
//                    dialog.show();
//                }
//
//                if (userPwd.equals("")) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    dialog = builder.setMessage("Input password, please")
//                            .setNegativeButton("Check", null)
//                            .create();
//                    dialog.show();
//                }
//
//                Response.Listener<String> response_listener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject json_response = new JSONObject(response);
//                            boolean success = json_response.getBoolean("success");
//                            if (success) {
//                                login_id = json_response.getString("id");
//                                login_pwd = json_response.getString("pwd");
//                                Intent main_intent = new Intent(LoginActivity.this, com.openhack.market30.MainActivity.class);
//                                LoginActivity.this.startActivity(main_intent);
//                                finish();
//                            }
//                            else {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                                dialog = builder.setMessage("Fail Login")
//                                        .setNegativeButton("Check", null)
//                                        .create();
//                                dialog.show();
//                            }
//                        }
//                        catch (Exception e)  {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//
//                LoginRequest login_request = new LoginRequest(userId, userPwd, response_listener);
//                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//                queue.add(login_request);
//            }
//        });
        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent register_intent = new Intent(LoginActivity.this, UserInformation.class);
                LoginActivity.this.startActivity(register_intent);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick (View view){
              Intent Main_intent = new Intent(LoginActivity.this, MainActivity.class);
              LoginActivity.this.startActivity(Main_intent);
          }
        });
    }
    }