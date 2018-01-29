package com.example.user.dcage.Proses;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.user.dcage.presenter.LoginPresenter;
import com.example.user.dcage.presenter.LoginPresenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;


/**
 * Created by user on 12/27/2017.
 */

public class LoginTask extends AsyncTask<String, Void, String> {

    private String email;
    private String password;
    private StringBuilder response = new StringBuilder();
    private Activity activity;
    private LoginPresenter loginPresenter;

    public LoginTask(LoginPresenterImpl loginPresenter, Activity activity) {
        this.activity = activity;
        this.loginPresenter = loginPresenter;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            email = URLDecoder.decode(params[0], "UTF-8");
            password = URLDecoder.decode(params[1], "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        try {
            URL url = new URL("https://dcage-163007.appspot.com/_ah/api/area/v1/login/"+email+"/"+password);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");

            BufferedInputStream inputStream = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line2;
            while ((line2 = reader.readLine()) != null) {
                response.append(line2);
            }
            conn.disconnect();

            return response.toString();

        } catch (ProtocolException e) {
            return e.getMessage();
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String success) {


        try {
            JSONObject object = new JSONObject(success);
            String id = object.getString("id").toString();

            if(id != null){

                loginPresenter.kirimHasil(id);
            }
            else{
                loginPresenter.kirimHasil("Gagagl");
            }
        } catch (JSONException e) {
            loginPresenter.kirimHasil("Error");
        }
    }
}