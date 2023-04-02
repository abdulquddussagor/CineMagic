package CineMagic;

import java.sql.Date;
import java.sql.ResultSet;

public class moviesData {

    private Integer id;
    private String title;
    private String genre;
    private String duration;
    private String image;
    private Date date;
    private String current;

    public moviesData(Integer id, String title, String genre, String duration, String image, Date date, String current) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.image = image;
        this.date = date;
        this.current = current;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public String getCurrent() {
        return current;
    }

    Object getData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}