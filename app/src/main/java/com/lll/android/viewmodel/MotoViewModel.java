package com.lll.android.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lll.android.MotoApi;
import com.lll.android.bean.MotoBean;
import com.lll.android.net.NetManager;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MotoViewModel extends ViewModel {

    MutableLiveData<MotoBean> motoBeanMutableLiveData;

    public void getMotoList(){
        MotoApi retrofit = NetManager.getInstance().getRetrofit(MotoApi.class);
        Single motoList = retrofit.getMotoList();
        motoList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MotoBean>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull MotoBean o) {

                        if (o!=null){
                            motoBeanMutableLiveData = new MutableLiveData<>();
                            motoBeanMutableLiveData.setValue(o);
                        }
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MutableLiveData<MotoBean> getMotoBeanMutableLiveData() {
        return motoBeanMutableLiveData;
    }
}
