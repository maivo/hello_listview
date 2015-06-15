package pee.hellolistview.ui;

import android.app.Application;

import pee.hellolistview.mb.MbAccount;

/**
 * Created by pvu_asus on 25/05/2015.
 */
public class AppSession extends Application {
    protected MbAccount account;

    public MbAccount getAccount() {
        return account;
    }

    public void setAccount(MbAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AppSession{" +
                "account=" + account +
                '}';
    }
}
