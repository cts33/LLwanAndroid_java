package com.lll.android.pager3;

import com.lll.android.bean.MotoBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MotoApi {

    String baseUrl =" https://api.jddmoto.com/carport/goods/rank/hot/list";

    @GET
    Single<MotoBean> getMotoList(@Url String url, @Query("goodType") String type,@Query("rows") String row);

}
