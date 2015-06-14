package pee.hellolistview.ui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import android.widget.SimpleAdapter;

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
    List<HashMap<String, String>> weatherDataCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //set title
        setTitle(R.string.title);

        try {


            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(getAssets().open("weatherdata.xml"));

            weatherDataCollection = new ArrayList<HashMap<String, String>>();

            // normalize text representation
            doc.getDocumentElement().normalize();

            NodeList weatherList = doc.getElementsByTagName("weatherdata");

            HashMap<String, String> map = null;


            for (int i = 0; i < 4; i++) {

                map = new HashMap<String, String>();
                map.put(KEY_ID, i+ ":1");
                map.put(KEY_CITY, "Berlin"+i);
                map.put(KEY_TEMP_C, "0°C");
                map.put(KEY_CONDN, "Snowing");
                map.put(KEY_SPEED, "5 kmph");
                map.put(KEY_ICON, "snowing");

                //Add to the Arraylist
                weatherDataCollection.add(map);

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

                    Intent i = new Intent();
                    i.setClass(WeatherActivity.this, SampleActivity.class);

                    // parameters
                    i.putExtra("position", String.valueOf(position + 1));

					/* selected item parameters
					 * 1.	City name
					 * 2.	Weather
					 * 3.	Wind speed
					 * 4.	Temperature
					 * 5.	Weather icon
					 */
                    i.putExtra("city", weatherDataCollection.get(position).get(KEY_CITY));
                    i.putExtra("weather", weatherDataCollection.get(position).get(KEY_CONDN));
                    i.putExtra("windspeed", weatherDataCollection.get(position).get(KEY_SPEED));
                    i.putExtra("temperature", weatherDataCollection.get(position).get(KEY_TEMP_C));
                    i.putExtra("icon", weatherDataCollection.get(position).get(KEY_ICON));

                    // start the sample activity
                    startActivity(i);
                }
            });

        } catch (IOException ex) {
            Log.e("Error", ex.getMessage());
        } catch (Exception ex) {
            Log.e("Error", "Loading exception");
        }

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




