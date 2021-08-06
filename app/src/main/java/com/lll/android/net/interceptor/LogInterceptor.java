package com.lll.android.net.interceptor;

import android.util.Log;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        HttpUrl url = request.url();
        URL url1 = url.url();
        Log.d(TAG, "LOG---intercept:url1= "+url1+"  msg=");
        Response response = chain.proceed(request);

        int code = response.code();
        String message = response.message();

        Log.d(TAG, "LOG---intercept:code= "+code+"  msg="+message);

        return  response;
    }

    private static final String TAG = "LogInterceptor";
}
