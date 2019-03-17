
package com.abhishek.buytodayandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("custId")
    @Expose
    private String custId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("accountNo")
    @Expose
    private String accountNo;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("desc")
    @Expose
    private String desc;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
