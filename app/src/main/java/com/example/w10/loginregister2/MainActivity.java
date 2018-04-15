package com.example.w10.loginregister2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    GridView gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Toolbar mToolabar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolabar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        gd=(GridView)findViewById(R.id.gridView1);
        gd.setAdapter(new MyAdapter(this));
        gd.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position==3)
        {


            Intent intent = getIntent();
            final String email = intent.getStringExtra("email");
            final String username = intent.getStringExtra("username");


            Intent intent1=new Intent(MainActivity.this,DisplayList.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent1);
        }
        else if(position==5)
        {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("finish", true); // if you are checking for this in your other Activities
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();


        }
        else if(position==4)
        {
            Intent intent=new Intent(MainActivity.this,ImportantLinks.class);
            startActivity(intent);
        }
        else if(position==0)
        {
            Intent intent=new Intent(MainActivity.this,DisplaySchemes.class);
            startActivity(intent);
        }
        else if(position==1)
        {
            Intent intent=new Intent(MainActivity.this,Project.class);
            startActivity(intent);
        }
        else if(position==2)
        {
            Intent intent=new Intent(MainActivity.this,Jobs.class);
            startActivity(intent);
        }


    }


    public class MyAdapter extends BaseAdapter
    {

        private List<Item> items=new ArrayList<Item>();
        private LayoutInflater inflator;

        public MyAdapter(Context context) {
            // TODO Auto-generated constructor stub
            inflator=LayoutInflater.from(context);
            items.add(new Item("Government Schemes",R.drawable.schemes));
            items.add(new Item("Government Projects",R.drawable.a));
            items.add(new Item("Government Jobs",R.drawable.b));
            items.add(new Item("Important Dates",R.drawable.dates));
            items.add(new Item("Important Links",R.drawable.link));
            items.add(new Item("Logout", R.drawable.logout));




        }



        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return items.get(position).drawableId;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // TODO Auto-generated method stub
            View v=convertView;
            ImageView img1;
            TextView txt1;
            if(v==null)
            {
                v=inflator.inflate(R.layout.grid_item,parent,false);
                v.setTag(R.id.picture,v.findViewById(R.id.picture));
                v.setTag(R.id.text,findViewById(R.id.text));

            }

            img1=(ImageView)v.findViewById(R.id.picture);
            txt1=(TextView)v.findViewById(R.id.text);

            Item item=(Item)getItem(position);

            img1.setImageResource(item.drawableId);
            txt1.setText(item.name);


            return v;


        }

    }

    private class Item
    {
        final String name;
        final int drawableId;

        Item(String name,int drawableId)
        {
            this.name=name;
            this.drawableId=drawableId;

        }
    }
}
