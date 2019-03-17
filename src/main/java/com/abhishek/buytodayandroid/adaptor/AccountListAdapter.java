package com.abhishek.buytodayandroid.adaptor;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhishek.buytodayandroid.R;
import com.abhishek.buytodayandroid.datastore.Account;

import java.util.List;

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountViewHolder> {

    class AccountViewHolder extends RecyclerView.ViewHolder {
        private final TextView descItemView;
        private final TextView typeItemView;
        private final TextView balanceItemView;

        private AccountViewHolder(View itemView) {
            super(itemView);
            descItemView = itemView.findViewById(R.id.desc);
            typeItemView = itemView.findViewById(R.id.type);
            balanceItemView = itemView.findViewById(R.id.balance);
        }
    }

    private final LayoutInflater mInflater;
    private List<Account> mWords; // Cached copy of words

    public AccountListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AccountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountViewHolder holder, int position) {
        if (mWords != null) {
            Account current = mWords.get(position);
            if(position == 0){
                holder.descItemView.setTextColor(Color.parseColor("#000000"));
                holder.typeItemView.setTextColor(Color.parseColor("#000000"));
                holder.balanceItemView.setTextColor(Color.parseColor("#000000"));
            }

            holder.descItemView.setText(current.desc + ' '+ current.accountNo );
            holder.typeItemView.setText(current.type);
            holder.balanceItemView.setText(current.balance);

        } else {
            // Covers the case of data not being ready yet.
            holder.descItemView.setText("Not available");
            holder.typeItemView.setText("Not available");
            holder.balanceItemView.setText("Not available");
        }
    }

    public void setAccounts(List<Account> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }
}