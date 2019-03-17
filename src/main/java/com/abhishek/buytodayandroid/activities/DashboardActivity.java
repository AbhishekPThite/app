package com.abhishek.buytodayandroid.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.abhishek.buytodayandroid.R;
import com.abhishek.buytodayandroid.adaptor.AccountListAdapter;
import com.abhishek.buytodayandroid.datastore.Account;
import com.abhishek.buytodayandroid.viewModel.AccViewModel;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private AccViewModel accvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        accvm = ViewModelProviders.of(this).get(AccViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AccountListAdapter adapter = new AccountListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        accvm.getAllAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable final List<Account> words) {
                // Update the cached copy of the words in the adapter
                Account header = new Account();
                header.desc = "My Accounts";
                header.accountNo = "";
                header.type = "Type";
                header.balance = "Balance";
                words.add(0,header);

                adapter.setAccounts(words);
            }
        });
    }


}
