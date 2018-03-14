package com.example.user.dcage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    @BindView(R.id.progressBar)ProgressBar loading;
    @BindView(R.id.textView)TextView id_tes;



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
        loading.setVisibility(View.VISIBLE);

    }

    @Override
    public void tampilkanHasil(String hasil) {

        loading.setVisibility(View.INVISIBLE);
        if(hasil=="Error"){
            Toast.makeText(this, "belum terdaftar", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
           // id_tes.setText(""+hasil);  //testing id

            Intent intent = new Intent(this, Unitbaru.class);
            startActivity(intent);
        }

    }

    @OnClick(R.id.btn_register)
    public void register(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


    ////////////////////////bagian testing///////////////////////////////////////

    @OnClick(R.id.testing)
    public void tes() {
        Intent intent = new Intent(this, Listunit.class);
        startActivity(intent);
    }

    @OnClick(R.id.testing2)
    public void tes2() {
        Intent intent = new Intent(this, TambahSensor.class);
        startActivity(intent);
    }
    @OnClick(R.id.testing3)
    public void tes3() {
        Intent intent = new Intent(this, Listsensor.class);
        startActivity(intent);
    }




}
