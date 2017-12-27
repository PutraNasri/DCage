package com.example.user.dcage.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.presenter.LoginPresenter;
import com.example.user.dcage.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter;
    @BindView(R.id.edt_email)EditText edtEmail;
    @BindView(R.id.edt_password)EditText edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenterImpl(this, this);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_login)
    public void login(){
        presenter.ceklogin(edtEmail.getText().toString(), edtPassword.getText().toString());
    }
}
