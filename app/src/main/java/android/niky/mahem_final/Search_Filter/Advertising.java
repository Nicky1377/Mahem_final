package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


public class Advertising {
    private String title,details,time,family_name,chat_time;
    private int image,userImage;

    public Advertising(String title, String details, String time, int image) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.image = image;
    }
    public Advertising(String title, String details, String time,int image,String family_name,String chat_time,int userImage) {
        this.title = title;
        this.details = details;
        this.time = time;


        this.image = image;
        this.family_name=family_name;
        this.chat_time=chat_time;
        this.userImage=userImage;
    }

    public String getFamily_name() {
        return family_name;
    }

    public String getChat_time() {
        return chat_time;
    }

    public int getUserImage() {
        return userImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getTime() {
        return time;
    }

    public int getImage() {
        return image;
    }
}
