package com.linuxgroup.homeschool.client.data;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.linuxgroup.homeschool.client.App;

/**
 * Created by tan on 14-8-5.
 */
public class RequestManager {
    public static RequestQueue mRequestQueue = Volley.newRequestQueue(App.getContext());

    private RequestManager() {
        // no instances
    }

    public static void addRequest(Request<?> request, Object tag) {
        if (tag != null) {
            request.setTag(tag);
        }
        mRequestQueue.add(request);
    }

    public static void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }
}
