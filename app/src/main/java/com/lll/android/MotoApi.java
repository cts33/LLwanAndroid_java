package com.lll.android;

import com.lll.android.bean.MotoBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface MotoApi {

    String baseUrl =" https://api.jddmoto.com/";

    @GET("carport/goods/rank/hot/list?goodType=&rows=-1")
    Single<MotoBean> getMotoList();

}
