package pee.hellolistview.ui;

import pee.hellolistview.R;
import pee.hellolistview.mb.MbAccount;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AccountHistoryActivity extends Activity {

    private static final String TAG = "WeatherDetailActivity";

    ImageButton imgWeatherIcon;
    TextView tvcity;
    TextView tvtemp;
    TextView tvwindspeed;
    TextView tvCondition;

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
            tvcity = (TextView) findViewById(R.id.textViewCity);
            tvtemp = (TextView) findViewById(R.id.textViewTemperature);
            tvwindspeed = (TextView) findViewById(R.id.textViewWindSpeed);
            tvCondition = (TextView) findViewById(R.id.textViewCondition);

            // Get position to display
            Intent i = getIntent();




            String uri = "drawable/"+ "d" + "snowing";
            int imageBtnResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable dimgbutton = getResources().getDrawable(imageBtnResource);


            //text elements
            tvcity.setText(account.getDesc());
            tvtemp.setText(account.getBalanceFormatted());
            tvwindspeed.setText(account.getAvailBalFormatted());
            tvCondition.setText(account.getStatus());

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
