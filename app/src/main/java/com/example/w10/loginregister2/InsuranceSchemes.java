package com.example.w10.loginregister2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class InsuranceSchemes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_schemes);


        Toolbar mToolabar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolabar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView textView=(TextView) findViewById(R.id.title);
        TextView t1=(TextView) findViewById(R.id.title1);
        TextView t2=(TextView) findViewById(R.id.title2);
        TextView t3=(TextView) findViewById(R.id.title3);
        TextView t4=(TextView) findViewById(R.id.title4);
        TextView t5=(TextView) findViewById(R.id.title5);
        TextView t6=(TextView) findViewById(R.id.title6);
        TextView d1=(TextView) findViewById(R.id.description1);
        TextView d2=(TextView) findViewById(R.id.description2);
        TextView d3=(TextView) findViewById(R.id.description3);
        TextView d4=(TextView) findViewById(R.id.description4);
        TextView d5=(TextView) findViewById(R.id.description5);
        TextView d6=(TextView) findViewById(R.id.description6);


        TextView ttextView=(TextView) findViewById(R.id.ttitle);
        TextView tt1=(TextView) findViewById(R.id.ttitle1);
        TextView tt2=(TextView) findViewById(R.id.ttitle2);
        TextView tt3=(TextView) findViewById(R.id.ttitle3);
        TextView tt4=(TextView) findViewById(R.id.ttitle4);
        TextView tt5=(TextView) findViewById(R.id.ttitle5);
        TextView tt6=(TextView) findViewById(R.id.ttitle6);
        TextView dd1=(TextView) findViewById(R.id.ddescription1);
        TextView dd2=(TextView) findViewById(R.id.ddescription2);
        TextView dd3=(TextView) findViewById(R.id.ddescription3);
        TextView dd4=(TextView) findViewById(R.id.ddescription4);
        TextView dd5=(TextView) findViewById(R.id.ddescription5);
        TextView dd6=(TextView) findViewById(R.id.ddescription6);


        Typeface tm=Typeface.createFromAsset(getAssets(),"fonts/title_main.ttf");
        textView.setTypeface(tm);

        Typeface t=Typeface.createFromAsset(getAssets(), "fonts/title.otf");
        Typeface d=Typeface.createFromAsset(getAssets(), "fonts/description.otf");


        t1.setTypeface(t);
        t2.setTypeface(t);
        t3.setTypeface(t);
        t4.setTypeface(t);
        t5.setTypeface(t);
        t6.setTypeface(t);


        tt1.setTypeface(t);
        tt2.setTypeface(t);
        tt3.setTypeface(t);
        tt4.setTypeface(t);
        tt5.setTypeface(t);
        tt6.setTypeface(t);


        d1.setTypeface(d);
        d2.setTypeface(d);
        d3.setTypeface(d);
        d4.setTypeface(d);
        d5.setTypeface(d);
        d6.setTypeface(d);


        dd1.setTypeface(d);
        dd2.setTypeface(d);
        dd3.setTypeface(d);
        dd4.setTypeface(d);
        dd5.setTypeface(d);
        dd6.setTypeface(d);

        ttextView.setTypeface(tm);

        CardView c1=(CardView) findViewById(R.id.card_view);
        CardView c2=(CardView) findViewById(R.id.card_view1);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InsuranceSchemes.this);
                builder.setIcon(R.drawable.ic_notifications_active_black_36dp);
                builder.setCancelable(false);
                builder.setTitle("Open Link in Browser..?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String url = "http://www.sbilife.co.in/sbilife/content/10_8843/";

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

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

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InsuranceSchemes.this);
                builder.setIcon(R.drawable.ic_notifications_active_black_36dp);
                builder.setCancelable(false);
                builder.setTitle("Open Link in Browser..?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String url = "https://www.pmjdy.gov.in/";

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

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

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.menu, menu);
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


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
