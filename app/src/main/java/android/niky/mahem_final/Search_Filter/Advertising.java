package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


public class Advertising {
    private String title,details,time,family_name,chat_time,noe,id;
    private int userImage;
    private String ThumbnailUrl;
    String ThumbnailUrl2, ThumbnailUrl3, ThumbnailUrl4, ThumbnailUrl5;

    public Advertising(String title, String details, String time, String thumbnailUrl) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.ThumbnailUrl = thumbnailUrl;
    }
    public Advertising(String title, String details, String time, String thumbnailUrl,String family_name,String chat_time,int userImage) {
        this.title = title;
        this.details = details;
        this.time = time;


        this.ThumbnailUrl = thumbnailUrl;
        this.family_name=family_name;
        this.chat_time=chat_time;
        this.userImage=userImage;
    }

    public Advertising()
    {

    }


    public String getId() {
        return id;
    }

    public String getNoe() {
        return noe;
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

    public String getThumbnailUrl() {
        return ThumbnailUrl;
    }
    public String getThumbnailUrl2() {
        return ThumbnailUrl2;
    }
    public String getThumbnailUrl3() {
        return ThumbnailUrl3;
    }
    public String getThumbnailUrl4() {
        return ThumbnailUrl4;
    }
    public String getThumbnailUrl5() {
        return ThumbnailUrl5;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNoe(String noe) {
        this.noe = noe;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setChat_time(String chat_time) {
        this.chat_time = chat_time;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        ThumbnailUrl = thumbnailUrl;
    }

    public void setThumbnailUrl2(String thumbnailUrl2) {
        ThumbnailUrl2 = thumbnailUrl2;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnailUrl3(String thumbnailUrl3) {
        ThumbnailUrl3 = thumbnailUrl3;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public void setThumbnailUrl4(String thumbnailUrl4) {
        ThumbnailUrl4 = thumbnailUrl4;
    }

    public void setThumbnailUrl5(String thumbnailUrl5) {
        ThumbnailUrl5 = thumbnailUrl5;
    }


}
