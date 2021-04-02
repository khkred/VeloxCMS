package com.fsemicolon.veloxcms;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * We will be using this class to establish network connection as soon as the app opens.
 */
public class Singleton {

    private static Singleton mInstance;

    private RequestQueue mRequestQueue;

    private static Context mCtx;


    /**
     * A private Constructor for the singleton class
     */
    private Singleton(Context context)
    {
        mCtx = context;

        mRequestQueue = getRequestQueue();
    }


    /**
     * Create a getter method for the request Queue
     */

    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue==null)
        {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return mRequestQueue;
    }

    /**
     * Public factory method for singleton object creation
     */




}
