package pee.hellolistview.ui;

import pee.hellolistview.R;
import pee.hellolistview.mb.MbAccount;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TextView;


public class AccountHistoryActivity extends Activity {

    private static final String TAG = "WeatherDetailActivity";

    ImageButton imgWeatherIcon;
    TextView tvTitle;
    TextView tvBalance;
    TextView tvAvailableBalance;
    TextView tvStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);

        //set title
        setTitle("WeatherDetailActivity");

        //retrieveWeatherData
        final AppSession appSession = (AppSession) getApplicationContext();
        MbAccount account = appSession.getAccount();

        Log.d(TAG, "account: "+account);




        try {

            //handle for the UI elements
            imgWeatherIcon = (ImageButton) findViewById(R.id.imageButtonAlpha);
            //Text fields
            tvTitle = (TextView) findViewById(R.id.tvTitle);
            tvBalance = (TextView) findViewById(R.id.tvBalance);
            tvAvailableBalance = (TextView) findViewById(R.id.tvAvailableBalance);
            tvStatus = (TextView) findViewById(R.id.tvStatus);

            // Get position to display
            Intent i = getIntent();




            String uri = "drawable/"+ "d" + "snowing";
            int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable dimgbutton = getResources().getDrawable(imageBtnResource);


            //text elements
            tvTitle.setText(account.getDesc());
            tvBalance.setText(account.getBalanceFormatted());
            tvAvailableBalance.setText(account.getAvailBalFormatted());
            tvStatus.setText(account.getStatus());

            //thumb_image.setImageDrawable(image);
            imgWeatherIcon.setImageDrawable(dimgbutton);


        }

        catch (Exception ex) {
            Log.e("Error", "Loading exception");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
