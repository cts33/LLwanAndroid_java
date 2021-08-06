package com.lll.android.pager3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.lll.android.bean.MotoBean;

public class MotoViewModel extends ViewModel {


//    }

    public LiveData<PagingData<MotoBean.Datam>> getMotoBeanMutableLiveData() {
        Pager<Integer, MotoBean.Datam> integerDatamPager = new Pager<>(new PagingConfig(20),

                () -> new MotoSource());

        return PagingLiveData.cachedIn(PagingLiveData.getLiveData(integerDatamPager),this);
    }
}
