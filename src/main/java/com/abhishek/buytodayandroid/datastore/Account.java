package com.abhishek.buytodayandroid.datastore;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by m63mobilebanking on 16/3/19.
 */

@Entity
public class Account {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "custId")
    public String custId;

    @ColumnInfo(name = "accountNo")
    public String accountNo;

    @ColumnInfo(name = "balance")
    public String balance;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "desc")
    public String desc;
}