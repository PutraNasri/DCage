package com.example.user.dcage.Proses;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.UnitbaruPresenter;
import com.example.user.dcage.presenter.UnitbaruPresenterImpl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by user on 1/24/2018.
 */

public class UnitbaruTask extends AsyncTask<String, Void, Integer>{

    private UnitbaruPresenterImpl unitbaruPresenter;
    private String id;
    private String namakandang;
    private String keterangankandang;

    private byte[] outputBytes;
    private StringBuilder response = new StringBuilder();
    private Unit unit;
    private UnitbaruTask unitbaruTask;
    private UnitbaruPresenterImpl presenter;
    private Activity activity;


    public UnitbaruTask(UnitbaruPresenterImpl unitbaruPresenter, Activity activity) {
        this.activity = activity;
        this.unitbaruPresenter = unitbaruPresenter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //POST     https://dcage-163007.appspot.com/_ah/api/unit/v1/baru
    @Override
    protected Integer doInBackground(String... params) {

        try {
            id = URLDecoder.decode(params[0], "UTF-8");
            namakandang = URLDecoder.decode(params[1], "UTF-8");
            keterangankandang = URLDecoder.decode(params[2], "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("tes", id + " " + namakandang + " " + keterangankandang );

        Uri.Builder uri = new Uri.Builder()
                .appendQueryParameter("id", id)
                .appendQueryParameter("keterangan", keterangankandang)
                .appendQueryParameter("nama", namakandang);
        String query = uri.build().getEncodedQuery();
        URL url;
        try {

            url = new URL("https://dcage-163007.appspot.com/_ah/api/unit/v1/baru");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            /* pass post data */
            outputBytes = query.getBytes("UTF-8");
            con.setConnectTimeout(10000);
            con.setReadTimeout(15000);
            con.setRequestMethod("POST");
            con.setDoInput(true);
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            os.write(outputBytes);
            os.close();
//
            /* Get Response and execute WebService request*/
            int statusCode = con.getResponseCode();

            /* 200 represents HTTP OK */
            String respon;
            if (statusCode == HttpsURLConnection.HTTP_OK) {

                BufferedInputStream inputStream = new BufferedInputStream(con.getInputStream());
                respon = convertStreamToString(inputStream);
                return statusCode;

            } else {

                respon = statusCode + "";
                return statusCode;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(Integer status) {

        if (status == HttpsURLConnection.HTTP_OK) {
            unitbaruPresenter.kirimhasil("ok");

        }
        else{
            unitbaruPresenter.kirimhasil("error");

        }
    }
}
