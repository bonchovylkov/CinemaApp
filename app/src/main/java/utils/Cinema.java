package utils;

import java.util.ArrayList;

/**
 * Created by Bon on 12/29/2014.
 */
public class Cinema {



    private  int id;
    private String title;
    private int pictureCode;
    private String address;
    private  String workingTime;



    private  int    pictureCodeSecond;
  //  private ArrayList<Movie> listMovies;

    public Cinema(int id,String title, int pictureCode,int pictureCodeSecond, String address,String workingTime) {
        this.id = id;
        this.title = title;
        this.pictureCode = pictureCode;
        this.pictureCodeSecond = pictureCodeSecond;
        this.address = address;
        this.workingTime = workingTime;
      //  this.listMovies = listMovies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPictureCode() {
        return pictureCode;
    }

    public void setPictureCode(int pictureCode) {
        this.pictureCode = pictureCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public int getPictureCodeSecond() {
        return pictureCodeSecond;
    }

    public void setPictureCodeSecond(int pictureCodeSecond) {
        this.pictureCodeSecond = pictureCodeSecond;
    }
}
