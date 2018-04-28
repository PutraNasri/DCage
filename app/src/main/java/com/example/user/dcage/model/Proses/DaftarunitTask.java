package com.example.user.dcage.model.Proses;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.DaftarunitPresenterImpl;

import org.json.JSONArray;
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
import java.util.ArrayList;

/**
 * Created by user on 1/29/2018.
 */

public class DaftarunitTask extends AsyncTask<String, Void, String> {
    private DaftarunitPresenterImpl daftarunitPresenter;
    private String id;

    private byte[] outputBytes;
    private StringBuilder response = new StringBuilder();
    private Activity activity;

    public DaftarunitTask(DaftarunitPresenterImpl daftarunitPresenter, Activity activity) {
        this.daftarunitPresenter = daftarunitPresenter;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            id = URLDecoder.decode(params[0], "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL("https://dcage-163007.appspot.com/_ah/api/unit/v1/daftar/"+id);
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
            JSONArray array = object.getJSONArray("items");
            ArrayList<Unit> daftarUnit = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonUnit = array.getJSONObject(i);
                Unit unit = new Unit(jsonUnit.getString("id").toString(),
                        jsonUnit.get("keterangan").toString(),
                        jsonUnit.get("nama").toString());
                daftarUnit.add(unit);
            }

            if (id != null) {
                daftarunitPresenter.kirimHasil(daftarUnit);
                Toast.makeText(activity, "respon " +response, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "tidak ada", Toast.LENGTH_SHORT).show();
                daftarunitPresenter.kirimHasil(null);
            }
        } catch (JSONException e) {
  //          daftarunitPresenter.kirimHasil(null);
            Toast.makeText(activity, "UNIT KOSONG", Toast.LENGTH_SHORT).show();
        }
    }
}
