package com.vsahin.moneycim.View.AddAndEditSpending;

import com.vsahin.moneycim.Model.Entity.RawSpending;
import com.vsahin.moneycim.Model.Entity.SpendingGroup;
import com.vsahin.moneycim.Model.Repository.SpendingRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Volkan Şahin on 27.08.2017.
 */

public class AddAndEditSpendingViewModel extends ViewModel {

    private SpendingRepository spendingRepository;

    final LiveData<List<SpendingGroup>> spendingGroups;

    @Inject
    public AddAndEditSpendingViewModel(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
        spendingGroups = getSpendingGroups();
    }

    private LiveData<List<SpendingGroup>> getSpendingGroups() {
        return spendingRepository.getSpendingGroups();
    }

    void addSpending(RawSpending s){
        spendingRepository.addSpending(s);
    }

    void deleteSpending(int id){
        spendingRepository.deleteSpending(id);
    }
}
