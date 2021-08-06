package com.lll.android.pager3;

import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;

import com.lll.android.bean.MotoBean;
import com.lll.android.net.NetManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class MotoSource extends RxPagingSource<Integer, MotoBean.Datam> {
    @NotNull
    @Override
    public Single<LoadResult<Integer, MotoBean.Datam>> loadSingle(@NotNull LoadParams<Integer> loadParams) {

        Single<MotoBean> motoList = NetManager.getInstance().getRetrofit(MotoApi.class).getMotoList(MotoApi.baseUrl,"","-1");
        return motoList.subscribeOn(Schedulers.io()).map( motoBean -> {
                    Integer nextPage=null;
                    if (motoBean.getCode()==0){
                        return new LoadResult.Page<>(motoBean.getData(),null,nextPage);
                    }else{
                        return new LoadResult.Error<Integer,MotoBean.Datam>(new Throwable());
                    }
         } ).onErrorReturn( o -> new LoadResult.Error<>(new Throwable()) );


    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, MotoBean.Datam> pagingState) {
        return 0;
    }
}
