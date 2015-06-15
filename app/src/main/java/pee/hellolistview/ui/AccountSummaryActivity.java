package pee.hellolistview.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import pee.hellolistview.R;
import pee.hellolistview.mb.MbAccount;

public class AccountSummaryActivity extends Activity {

    private static final String TAG = "WeatherActivity";

    // List items
    ListView lvWeatherDataCollection;
    AccountSummaryBinderData adapter = null;
    List<MbAccount> accountCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //set title
        setTitle(R.string.title);


        accountCollection = new ArrayList<MbAccount>();


        MbAccount account = null;
        for (int i = 0; i < 4; i++) {


            account = new MbAccount();
            account.setDesc("Associate Chequing Account 780-***6290-"+i);
            account.setAvailBalFormatted("$18.0" + i + " CAD");
            account.setBalanceFormatted("$.19.0"+i + " CAD");
            account.setStatus("good");
            //Add to the Arraylist
            accountCollection.add(account);

        }


        AccountSummaryBinderData bindingData = new AccountSummaryBinderData(this, accountCollection);


        lvWeatherDataCollection = (ListView) findViewById(R.id.list);

        Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

        lvWeatherDataCollection.setAdapter(bindingData);

        Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

        // Click event for single list row
        lvWeatherDataCollection.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                final AppSession appSession = (AppSession) getApplicationContext();
                MbAccount account = accountCollection.get(position);
                appSession.setAccount(account);

                Intent i = new Intent(AccountSummaryActivity.this, AccountHistoryActivity.class);
                //i.setClass(WeatherActivity.this, WeatherDetailActivity.class);

                // start the 2nd activity
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_go) {
            //handleGoSecondActivity();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}




