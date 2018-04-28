package com.example.user.dcage.model.Proses;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user.dcage.presenter.TambahAktuatorPresenterImpl;

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
 * Created by user on 3/15/2018.
 */

public class AktuatorbaruTask extends AsyncTask<String, Void, Integer> {
    private TambahAktuatorPresenterImpl tambahAktuatorPresenter;
    private Activity activity;

    private String id;
    private String namaaktuator;
    private String keteranganaktuator;

    private byte[] outputBytes;
    private StringBuilder response = new StringBuilder();

    public AktuatorbaruTask(TambahAktuatorPresenterImpl tambahAktuatorPresenter, Activity activity) {
        this.tambahAktuatorPresenter = tambahAktuatorPresenter;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Integer doInBackground(String... params) {

        try {
            id = URLDecoder.decode(params[0], "UTF-8");
            namaaktuator = URLDecoder.decode(params[1], "UTF-8");
            keteranganaktuator = URLDecoder.decode(params[2], "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("tes", id + " " + namaaktuator + " " + keteranganaktuator );

        Uri.Builder uri = new Uri.Builder()
                .appendQueryParameter("id", id)
                .appendQueryParameter("keterangan", keteranganaktuator)
                .appendQueryParameter("nama", namaaktuator);
        String query = uri.build().getEncodedQuery();
        URL url;
        try {


            url = new URL("https://dcage-163007.appspot.com/_ah/api/aktuator/v1/baru");
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
            tambahAktuatorPresenter.kirimhasil("ok");

        }
        else{
            tambahAktuatorPresenter.kirimhasil("error");

        }
    }
}
