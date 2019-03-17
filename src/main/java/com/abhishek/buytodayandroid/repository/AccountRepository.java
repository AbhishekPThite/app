package com.abhishek.buytodayandroid.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.abhishek.buytodayandroid.datastore.Account;
import com.abhishek.buytodayandroid.datastore.AccountDatabase;
import com.abhishek.buytodayandroid.datastore.AccountsDao;

import java.util.List;

/**
 * Created by m63mobilebanking on 16/3/19.
 */

public class AccountRepository {

    private AccountsDao accDao;
    private LiveData<List<Account>> accounts;

    public AccountRepository(Application application) {
        AccountDatabase db = AccountDatabase.getDatabase(application);
        accDao = db.accountsDao();
        accounts = accDao.getAllAccounts();
    }

    public void insert (Account acc) {
        new insertAsyncTask(accDao).execute(acc);
    }

    private static class insertAsyncTask extends AsyncTask<Account, Void, Void> {

        private AccountsDao mAsyncTaskDao;

        insertAsyncTask(AccountsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Account... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public LiveData<List<Account>> getAllAccounts() {
        return accounts;
    }

}
