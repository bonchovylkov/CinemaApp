package utils;

/**
 * Created by Bon on 12/29/2014.
 */
public class Movie {


    private  int id;
    private  String name;
    private  Boolean hasTickets;

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    private  String cast;
    private  int picture;
    private  String playedInCinemas;

    public Movie(int id, String name, Boolean hasTickets) {
        this.id = id;
        this.name = name;
        this.hasTickets = hasTickets;
    }

    public Movie(int id, String name, Boolean hasTickets, int picture, String playedInCinemas,String cast) {
        this.id = id;
        this.name = name;
        this.hasTickets = hasTickets;
        this.picture = picture;
        this.playedInCinemas = playedInCinemas;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasTickets() {
        return hasTickets;
    }

    public void setHasTickets(Boolean hasTickets) {
        this.hasTickets = hasTickets;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getPlayedInCinemas() {
        return playedInCinemas;
    }

    public void setPlayedInCinemas(String playedInCinemas) {
        this.playedInCinemas = playedInCinemas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
