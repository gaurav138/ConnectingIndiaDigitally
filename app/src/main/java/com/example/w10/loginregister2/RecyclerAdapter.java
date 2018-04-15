package com.example.w10.loginregister2;

/**
 * Created by W10 on 13-Mar-17.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by W10 on 04-Mar-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder> {



    private static final int TYPE_HEAD=0;
    private static final int TYPE_LIST=1;


    ArrayList<Fruit> arrayList= new ArrayList<>();
    public RecyclerAdapter(ArrayList<Fruit> arrayList)
    {
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEAD)
        {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false);
            RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,viewType);



            return recyclerViewHolder;
        }
        else if(viewType==TYPE_LIST)
        {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
            RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,viewType);



            return recyclerViewHolder;


        }
        return null;



    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {


        if(holder.viewType==TYPE_LIST)
        {
            Fruit fruit=arrayList.get(position-1);
            holder.No.setText(Integer.toString(fruit.getNo()));
            holder.Exam_name.setText(fruit.getExam_name());
            holder.Date.setText(fruit.getDate());
            holder.Info.setText(fruit.getInfo());
        }




    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1 ;
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Exam_name,Date,Info,No;
        int viewType;


        public RecyclerViewHolder(View view,int viewType)
        {
            super(view);
            if(viewType==TYPE_LIST)
            {
                No= (TextView) view.findViewById(R.id.no);
                Exam_name= (TextView) view.findViewById(R.id.exam_name);

                Date= (TextView) view.findViewById(R.id.date);
                Info= (TextView) view.findViewById(R.id.info);
                this.viewType=TYPE_LIST;

                view.setOnClickListener(this);



            }
            else if(viewType==TYPE_HEAD)
            {
                this.viewType=TYPE_HEAD;
            }


        }

        @Override
        public void onClick(View v) {
            /*AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setMessage("Please enter a valid email")
                    .setNegativeButton("Retry", null)
                    .create()
                    .show();*/
            /*



            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setIcon(android.R.drawable.sym_def_app_icon);
            builder.setCancelable(false);
            builder.setTitle("Do you want to get notification ?");
            builder.setMessage("you will receive a notification about an event on that day for every event... ");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {











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
            */


        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return TYPE_HEAD;
        return TYPE_LIST;

    }
}

