package com.example.w10.loginregister2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
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

import java.util.ArrayList;
import java.util.List;

public class DisplaySchemes extends AppCompatActivity implements AdapterView.OnItemClickListener{
    GridView gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schemes);



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

        if(position==0)
        {

            Intent intent1=new Intent(DisplaySchemes.this,InsuranceSchemes.class);
            startActivity(intent1);

            /*Intent intent = getIntent();
            String email = intent.getStringExtra("email");
            String username = intent.getStringExtra("username");
            Intent intent1=new Intent(MainActivity.this,DisplayList.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent1);*/
        }
        else if(position==1)
        {
            Intent intent1=new Intent(DisplaySchemes.this,PensionSchemes.class);
            startActivity(intent1);
        }
        else if(position==2)
        {
            Intent intent1=new Intent(DisplaySchemes.this,MinoritiesSchemes.class);
            startActivity(intent1);
        }

        else if(position==3)
        {
            Intent intent1=new Intent(DisplaySchemes.this,AgriculturalSchemes.class);
            startActivity(intent1);
        }

        else if(position==4)
        {
            Intent intent1=new Intent(DisplaySchemes.this,HealthSchemes.class);
            startActivity(intent1);
        }

        else if(position==5)
        {
            Intent intent1=new Intent(DisplaySchemes.this,EducationSchemes.class);
            startActivity(intent1);

        }

        else if(position==6)
        {
            Intent intent1=new Intent(DisplaySchemes.this,FinantialSchemes.class);
            startActivity(intent1);
        }

        else if(position==7)
        {
            Intent intent1=new Intent(DisplaySchemes.this,EnvironmentalSchemes.class);
            startActivity(intent1);
        }

    }


    public class MyAdapter extends BaseAdapter
    {

        private List<Item> items=new ArrayList<Item>();
        private LayoutInflater inflator;

        public MyAdapter(Context context) {
            // TODO Auto-generated constructor stub
            inflator=LayoutInflater.from(context);


            items.add(new Item("Important Dates",R.drawable.ins));
            items.add(new Item("A",R.drawable.pen));
            items.add(new Item("B",R.drawable.miu));
            items.add(new Item("C",R.drawable.ag));
            items.add(new Item("Important Links",R.drawable.he));
            items.add(new Item("Logout", R.drawable.ed));
            items.add(new Item("Logout2", R.drawable.fc));
            items.add(new Item("Logout2", R.drawable.en));







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
            //TextView txt1;
            if(v==null)
            {
                v=inflator.inflate(R.layout.grid_item1,parent,false);
                v.setTag(R.id.picture,v.findViewById(R.id.picture));
                //v.setTag(R.id.text,findViewById(R.id.text));





            }

            img1=(ImageView)v.findViewById(R.id.picture);
            //txt1=(TextView)v.findViewById(R.id.text);

            Item item=(Item)getItem(position);

            img1.setImageResource(item.drawableId);
            img1.setImageBitmap(roundCornerImage(BitmapFactory.decodeResource(getResources(), item.drawableId),50));
            //txt1.setText(item.name);


            return v;






        }

        public Bitmap roundCornerImage(Bitmap raw, float round) {
            int width = raw.getWidth();
            int height = raw.getHeight();
            Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            canvas.drawARGB(0, 0, 0, 0);

            final Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.parseColor("#000000"));

            final Rect rect = new Rect(0, 0, width, height);
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, round, round, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(raw, rect, rect, paint);

            return result;
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
