package customAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.homeassignment.cinemaapp.R;

import java.util.ArrayList;

import utils.Cinema;

/**
 * Created by Bon on 12/29/2014.
 */
public class CinemaAdapter extends BaseAdapter {

    private String[] listCinemaNames = new String[] {"Cinema City", "IMAX", "Arena"};
    private String[] listAddresses = new String[] {"Kv.Mladost,ul. Dunav 14",
            "ul. Stafan Stambolov 16", "Kv. Boqna, ul. Bqla Cherkva 213"};
    private String[] listWorkingTimes = new String[] {"13:00 - 24:0", "Non Stop", "09:00 - 23:00"};

    private int[] listPics = new int[] {R.drawable.cinema_city_1, R.drawable.imax_1, R.drawable.arena_1};
    private int[] listPicsSecond = new int[] {R.drawable.cinema_city_2, R.drawable.imax_2, R.drawable.arena_2};

    private ArrayList<Cinema> listCinemas = new ArrayList<Cinema>();
    private Context context;


    public CinemaAdapter(Context context) {
        this.context = context;
        populateCountries();
    }

    private void populateCountries() {
        for(int i=0;i< listCinemaNames.length;i++){
         Cinema cinema  =new Cinema(i+1,listCinemaNames[i], listPics[i],listPicsSecond[i],listAddresses[i],listWorkingTimes[i]);
            listCinemas.add(cinema);
        }
    }

    @Override
    public int getCount() {
        return listCinemas.size();
    }

    @Override
    public Cinema getItem(int position) {
        return listCinemas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView countryFlag;
        TextView countryName;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cinema_row, parent, false);
            countryName = (TextView) convertView.findViewById(R.id.cinemaTitle);
            countryFlag = (ImageView) convertView.findViewById(R.id.cinemaPicture);

            //it works faster with set tag
            convertView.setTag(R.id.cinemaTitle, countryName);
            convertView.setTag(R.id.cinemaPicture, countryFlag);


        } else {
            countryName = (TextView) convertView.getTag(R.id.cinemaTitle);
            countryFlag = (ImageView) convertView.getTag(R.id.cinemaPicture);

        }

        countryName.setText("" + getItem(position).getTitle());
        countryFlag.setBackgroundResource(getItem(position).getPictureCode());

        return convertView;
    }
}