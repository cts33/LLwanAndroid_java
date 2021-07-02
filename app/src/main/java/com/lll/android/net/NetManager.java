package com.lll.android.net;

import com.lll.android.net.interceptor.LogInterceptor;
import com.lll.android.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {
    private NetManager() {
    }

    private static volatile NetManager netManager;

    public static NetManager getInstance() {
        if (netManager == null) {
            synchronized (NetManager.class) {
                if (netManager == null) {
                    netManager = new NetManager();
                }
            }
        }
        return netManager;
    }

    public static <T> T getRetrofit(Class<T> t) {
        return new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(t);
    }

    private static OkHttpClient getOkHttpClient(Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new LogInterceptor());
        for (int i = 0; i < interceptors.length; i++) {
            builder.addInterceptor(interceptors[i]);
        }
        return builder.build();
    }


}
