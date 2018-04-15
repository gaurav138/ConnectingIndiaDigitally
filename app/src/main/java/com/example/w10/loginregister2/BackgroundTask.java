package com.example.w10.loginregister2;

/**
 * Created by W10 on 13-Mar-17.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by W10 on 03-Mar-17.
 */

public class BackgroundTask extends AsyncTask<Void,Fruit,Void> {

    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog progressDialog;

    ArrayList<Fruit> arrayList=new ArrayList<>();




    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity= (Activity)ctx;

    }

    String json_string="http://10.162.11.47/get_my_exam_details1.php";
    @Override
    protected void onPreExecute() {

        recyclerView=(RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager= new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("List is loading...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();









    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL(json_string);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream= httpURLConnection.getInputStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            String line;

            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");
            }



            httpURLConnection.disconnect();
            String json_string= stringBuilder.toString().trim();

            JSONObject jsonObject=new JSONObject(json_string);
            JSONArray jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;

            while(count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                count++;
                Fruit fruit=new Fruit(JO.getInt("no"),JO.getString("exam_name"),JO.getString("date"),JO.getString("info"));
                publishProgress(fruit);
                Thread.sleep(1000);
            }

            Log.d("JSON_STRING",json_string);






        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Fruit... values) {

        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();



    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.dismiss();
    }
}
