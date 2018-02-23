package com.example.user.dcage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.ProgressBar;
import com.example.user.dcage.R;
import com.example.user.dcage.presenter.DaftarPresenter;
import com.example.user.dcage.presenter.DaftarPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity implements RegisterView {

    private DaftarPresenter daftarPresenter;
    @BindView(R.id.edt_namadaftar)EditText edtnama;
    @BindView(R.id.edt_alamatdaftar)EditText edtalamat;
    @BindView(R.id.edt_emaildaftar)EditText edtEmail;
    @BindView(R.id.edt_passworddaftar)EditText edtPassword;
    @BindView(R.id.progressBar2)ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        daftarPresenter = new DaftarPresenterImpl(this, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_daftar)
    public void register(){
        daftarPresenter.mendaftar(edtnama.getText().toString(),edtalamat.getText().toString(),
                                edtEmail.getText().toString(), edtPassword.getText().toString());
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
