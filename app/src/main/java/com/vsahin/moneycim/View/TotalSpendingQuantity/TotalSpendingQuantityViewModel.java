package com.vsahin.moneycim.View.TotalSpendingQuantity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.vsahin.moneycim.Model.Repository.SpendingRepository;
import com.vsahin.moneycim.MoneycimApp;

import javax.inject.Inject;

/**
 * Created by Volkan Şahin on 21.08.2017.
 */

public class TotalSpendingQuantityViewModel extends AndroidViewModel{
    @Inject public SpendingRepository spendingRepository;
    final public LiveData<Double> totalSpendingQuantity;

    public TotalSpendingQuantityViewModel(Application application) {
        super(application);
        ((MoneycimApp)getApplication()).getAppComponent().inject(this);

        totalSpendingQuantity = getTotalSpendingQuantity();
    }

    public LiveData<Double> getTotalSpendingQuantity(){
        return  spendingRepository.getTotalSpendingQuantity();
    }
}
