package com.abhishek.buytodayandroid.viewModel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.abhishek.buytodayandroid.datastore.Account;
import com.abhishek.buytodayandroid.repository.AccountRepository;

import java.util.List;

/**
 * Created by m63mobilebanking on 16/3/19.
 */

public class AccViewModel extends AndroidViewModel {

    private AccountRepository accRepository;
    private LiveData<List<Account>> accounts;

    public AccViewModel(Application application) {
        super(application);
        accRepository = new AccountRepository(application);
        accounts = accRepository.getAllAccounts();
    }

    public void insert(Account acc) { accRepository.insert(acc); }

    public LiveData<List<Account>> getAllAccounts() { return accounts; }


}
