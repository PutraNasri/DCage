package com.example.user.dcage.model.Proses;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.TambahSensorPresenterImpl;
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
 * Created by user on 2/23/2018.
 */

public class SensorbaruTask extends AsyncTask<String, Void, Integer>{
    private TambahSensorPresenterImpl tambahSensorPresenter;
    private Activity activity;

    private String id;
    private String namasensor;
    private String keterangansensor;

    private byte[] outputBytes;
    private StringBuilder response = new StringBuilder();

    public SensorbaruTask(TambahSensorPresenterImpl tambahSensorPresenter, Activity activity) {
        this.tambahSensorPresenter = tambahSensorPresenter;
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
            namasensor = URLDecoder.decode(params[1], "UTF-8");
            keterangansensor = URLDecoder.decode(params[2], "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("tes", id + " " + namasensor + " " + keterangansensor );

        Uri.Builder uri = new Uri.Builder()
                .appendQueryParameter("id", id)
                .appendQueryParameter("keterangan", keterangansensor)
                .appendQueryParameter("nama", namasensor);
        String query = uri.build().getEncodedQuery();
        URL url;
        try {

            url = new URL("https://dcage-163007.appspot.com/_ah/api/sensor/v1/sensor");
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
            tambahSensorPresenter.kirimhasil("ok");

        }
        else{
            tambahSensorPresenter.kirimhasil("error");

        }
    }
}
