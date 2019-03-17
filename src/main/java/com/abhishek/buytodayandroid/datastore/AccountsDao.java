package com.abhishek.buytodayandroid.datastore;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by m63mobilebanking on 16/3/19.
 */

@Dao
public interface AccountsDao {

    @Insert
    void insert(Account acc);

    @Query("DELETE FROM Account")
    void deleteAll();

    @Query("SELECT * from Account")
    LiveData<List<Account>> getAllAccounts();
}