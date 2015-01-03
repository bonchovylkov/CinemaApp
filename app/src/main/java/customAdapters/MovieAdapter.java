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
import utils.Movie;

/**
 * Created by Bon on 12/29/2014.
 */
public class MovieAdapter extends BaseAdapter {

    public int getSelectedCinema() {
        return selectedCinema;
    }

    public void setSelectedCinema(int selectedCinema) {
        this.selectedCinema = selectedCinema;
    }

    private  int selectedCinema =0;

    private String[] listMovieNames =
            new String[] {"Hobbit", "Lord Of the rings", "It","Goal","Top Gun", "Star Wars","Troy"};

    private String[] listMovieCasts =
            new String[] {"Leonardo Dicaprio", "Asen Blatechki", "Eric Bana","Jan Clod Van Damme","Arnold",
                    "Vin Disel","Al Pachino"};
    private Boolean[] listHasTickets =
            new Boolean[] {true,false,false,true,false,true,true};
    private int[] listPics =
            new int[] {R.drawable.movie_hobbit, R.drawable.movie_lotr, R.drawable.movie_it,
                    R.drawable.movie_goal, R.drawable.movie_topgun, R.drawable.movie_starwars,R.drawable.movie_troy};

    private String[] listPlayedInCinemas=
            new String[] {"Cinema City,Imax,Arena",
                    "Imax,Arena",
                    "Cinema City,Imax",
                    "Cinema City,Imax,Arena",
                    "Cinema City,Arena",
                    "Imax,Arena",
                    "Cinema City,Imax,Arena"};



    private ArrayList<Movie> listMovies = new ArrayList<Movie>();
    private Context context;

    public MovieAdapter(Context context)
    {

    }

    public MovieAdapter(Context context,int selectedCinema) {
        this.context = context;
        this.selectedCinema = selectedCinema;
        if (selectedCinema==0) {
            populateMoviesFirstCinema();
        }else if(selectedCinema==1){
            populateMoviesSecondCinema();
        }else if(selectedCinema==2){
            populateMoviesThirdCinema();
        }
    }


    private void getMoviesForCinema(int i, int i1, int i2, int i3, int i4) {
        listMovies = new ArrayList<Movie>();
        Movie newMovie = new Movie(0,listMovieNames[i],listHasTickets[i],listPics[i],listPlayedInCinemas[i],listMovieCasts[i]);
        listMovies.add(newMovie);
        Movie newMovieSecond = new Movie(1,listMovieNames[i1],listHasTickets[i1],listPics[i1],listPlayedInCinemas[i1],listMovieCasts[i1]);
        listMovies.add(newMovieSecond);
        Movie newMovieThird = new Movie(2,listMovieNames[i2],listHasTickets[i2],listPics[i2],listPlayedInCinemas[i2],listMovieCasts[i2]);
        listMovies.add(newMovieThird);
        Movie newMovieFourth = new Movie(3,listMovieNames[i3],listHasTickets[i3],listPics[i3],listPlayedInCinemas[i3],listMovieCasts[i3]);
        listMovies.add(newMovieFourth);
        Movie newMovieFifth = new Movie(4,listMovieNames[i4],listHasTickets[i4],listPics[i4],listPlayedInCinemas[i4],listMovieCasts[i4]);
        listMovies.add(newMovieFifth);
    }

    private void populateMoviesThirdCinema() {
        getMoviesForCinema(0,2,3,5,6);
    }

    private void populateMoviesSecondCinema() {
        getMoviesForCinema(1,2,4,5,6);
    }

    private void populateMoviesFirstCinema() {
        getMoviesForCinema(0,1,3,4,6);
    }



    @Override
    public int getCount() {
        return listMovies.size();
    }

    @Override
    public Movie getItem(int position) {
        return listMovies.get(position);
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

        countryName.setText("" + getItem(position).getName());
        countryFlag.setBackgroundResource(getItem(position).getPicture());

        return convertView;
    }
}
