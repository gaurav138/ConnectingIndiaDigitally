package com.example.w10.loginregister2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DisplayList extends AppCompatActivity {


    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        Toolbar mToolabar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolabar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        BackgroundTask backgroundTask=new BackgroundTask(DisplayList.this);
        backgroundTask.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.menu1, menu);
        MenuItem about_us=menu.findItem(R.id.action_about_us);



        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {




        switch (item.getItemId()) {
            case R.id.action_share:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "http://play.google.com/connectingindiadigitally";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                return true;


            case R.id.action_about_us:
                Intent aboutusintent= new Intent(this,AboutUsActivity.class) ;
                startActivity(aboutusintent);
                return true;

            case R.id.action_notification:



                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayList.this);
                builder.setIcon(R.drawable.ic_notifications_active_black_36dp);
                builder.setCancelable(false);
                builder.setTitle("Do you want to get notification ?");
                builder.setMessage("you will receive a notification about an event on that day for every event... ");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        count++;

                        if(count==1) {




                            Intent intent = getIntent();
                            final String email = intent.getStringExtra("email");
                            final String username = intent.getStringExtra("username");


                            String app_server_url = "http://10.162.11.47/fcmtest/fcm_insert.php";



                            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);

                            final String abc="abc";
                            final String em="abc123@gmail.com";
                            final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
                            //Toast.makeText(getApplicationContext(),token+"svbxz",Toast.LENGTH_LONG).show();

                            StringRequest stringRequest = new StringRequest(Request.Method.POST, app_server_url, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {

                                /*
                                Intent intent = getIntent();
                                String email = intent.getStringExtra("email");
                                String username = intent.getStringExtra("username");*/



                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("fcm_token", token);
                                    params.put("user_name",abc );
                                    //params.put("email",em);


                                    return params;
                                }
                            };
                            MySingleton.getmInstance(DisplayList.this).addToRequestque(stringRequest);
                            Toast.makeText(DisplayList.this,"You have Registered Successfully...",Toast.LENGTH_LONG).show();


                        }

                        else
                        {
                            Toast.makeText(DisplayList.this,"You have Already Registered...",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();



            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
