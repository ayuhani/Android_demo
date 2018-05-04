package com.ayuhani.demo.broadcast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ayuhani.demo.R;
import com.ayuhani.demo.chatview.MainActivity;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;
    private CheckBox cbRemember;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        cbRemember = findViewById(R.id.cb_remember);
        btnLogin = findViewById(R.id.btn_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember) {
            etAccount.setText(preferences.getString("account", ""));
            etPwd.setText(preferences.getString("password", ""));
            cbRemember.setChecked(true);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString();
                String pwd = etPwd.getText().toString();
                if (account.equals("admin") && pwd.equals("12345")) {
                    editor = preferences.edit();
                    if (cbRemember.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", pwd);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(it);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
