package thanhlong.example.helloworld.appcinea;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private ImageView iconNext;
    private Button btnLogin;
    private TextView forgotPass, register;
    private EditText txtUsername, txtPassword;
    CinemaServiceAPI api;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapping();
        api = new CinemaServiceAPI();
        //Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username;
                String passwd;
                username = "admin";
                passwd = "admin";
                String res = api.callLogin(username,passwd);
                Toast.makeText(LoginActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });
        iconNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        iconNext = findViewById(R.id.icon_next);
        btnLogin = findViewById(R.id.btn_login);
        forgotPass = findViewById(R.id.forgot_password);
        register = findViewById(R.id.signup);
        txtPassword = findViewById(R.id.txt_password);
        txtUsername = findViewById(R.id.txt_username);
    }
}
