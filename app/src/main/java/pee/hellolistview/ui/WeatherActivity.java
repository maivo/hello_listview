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

public class WeatherActivity extends Activity {

    private static final String TAG = "WeatherActivity";

    // XML node keys
    static final String KEY_TAG = "weatherdata"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_CITY = "city";
    static final String KEY_TEMP_C = "tempc";
    static final String KEY_TEMP_F = "tempf";
    static final String KEY_CONDN = "condition";
    static final String KEY_SPEED = "windspeed";
    static final String KEY_ICON = "icon";

    // List items
    ListView list;
    BinderData adapter = null;
    List<WeatherData> weatherDataCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //set title
        setTitle(R.string.title);


        weatherDataCollection = new ArrayList<WeatherData>();



            WeatherData weatherData = null;
            for (int i = 0; i < 4; i++) {



                weatherData = new WeatherData();
                weatherData.setId("" +i);
                weatherData.setCity("Calgary1:" + i);
                weatherData.setTempc(i + " C");
                weatherData.setCondition("Snowing");
                weatherData.setWindSpeed(i + " kmph");
                weatherData.setIcon("snowing");


                //Add to the Arraylist
                weatherDataCollection.add(weatherData);

            }


            BinderData bindingData = new BinderData(this, weatherDataCollection);


            list = (ListView) findViewById(R.id.list);

            Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

        list.setAdapter(bindingData);

        Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

            // Click event for single list row
            list.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    final AppSession appSession = (AppSession) getApplicationContext();
                    WeatherData weatherData = weatherDataCollection.get(position);
                    appSession.setWeatherData(weatherData);

                    Intent i = new Intent(WeatherActivity.this, WeatherDetailActivity.class);
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




