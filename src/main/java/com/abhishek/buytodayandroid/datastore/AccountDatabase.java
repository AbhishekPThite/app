package com.abhishek.buytodayandroid.datastore;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by m63mobilebanking on 16/3/19.
 */

@Database(entities = {Account.class}, version = 1, exportSchema = false)
public abstract class AccountDatabase extends RoomDatabase {
    public abstract AccountsDao accountsDao();
    private static volatile AccountDatabase INSTANCE;

    public static AccountDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AccountDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AccountDatabase.class, "accounts_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}