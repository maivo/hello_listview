package pee.hellolistview.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pee.hellolistview.R;
import pee.hellolistview.mb.MbAccount;

public class AccountSummaryBinderData extends BaseAdapter {



    LayoutInflater inflater;
    ImageView thumb_image;
    List<MbAccount> accountCollection;
    ViewHolder holder;
    public AccountSummaryBinderData() {
        // TODO Auto-generated constructor stub
    }

    public AccountSummaryBinderData(Activity act, List<MbAccount> accountCollection) {

        this.accountCollection = accountCollection;

        inflater = (LayoutInflater) act
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        // TODO Auto-generated method stub
//		return idlist.size();
        return accountCollection.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;
        if(convertView==null){

            vi = inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();

            holder.tvCity = (TextView)vi.findViewById(R.id.tvCity); // city name
            holder.tvWeather = (TextView)vi.findViewById(R.id.tvCondition); // city weather overview
            holder.tvTemperature =  (TextView)vi.findViewById(R.id.tvTemp); // city temperature
            holder.tvWeatherImage =(ImageView)vi.findViewById(R.id.list_image); // thumb image

            vi.setTag(holder);
        }
        else{

            holder = (ViewHolder)vi.getTag();
        }

        // Setting all values in listview
        MbAccount account = accountCollection.get(position);
        holder.tvCity.setText(account.getDesc());
        holder.tvWeather.setText(account.getBalanceFormatted());
        holder.tvTemperature.setText(account.getAvailBalFormatted());

        //Setting an image
        String uri = "drawable/"+ "snowing";
        int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
        Drawable image = vi.getContext().getResources().getDrawable(imageResource);
        holder.tvWeatherImage.setImageDrawable(image);

        return vi;
    }

    /*
     *
     * */
    static class ViewHolder{

        TextView tvCity;
        TextView tvTemperature;
        TextView tvWeather;
        ImageView tvWeatherImage;
    }

}
