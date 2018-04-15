package com.example.w10.loginregister2;

/**
 * Created by W10 on 19-Mar-17.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by W10 on 18-Mar-17.
 */

public class MySingleton {

    private static MySingleton mInstance;
    private static Context mCtx;
    private RequestQueue requestQueue;

    private MySingleton(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }


    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        }
        return requestQueue;
    }

    public static synchronized MySingleton getmInstance(Context context)
    {
        if (mInstance==null)
        {
            mInstance=new MySingleton(context);

        }
        return mInstance;
    }


    public<T> void addToRequestque(Request<T> request)
    {
        getRequestQueue().add(request);
    }









}
