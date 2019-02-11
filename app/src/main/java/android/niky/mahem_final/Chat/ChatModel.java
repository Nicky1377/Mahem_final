package android.niky.mahem_final.Chat;


import android.media.Image;

import java.util.Date;

public class ChatModel {

    String message;
    boolean isSend;
    Date time;
    Image ProfileImg;
    String profileUrl;


    public ChatModel(String msg, boolean is,Date d)
    {
        message=msg;
        isSend=is;
        time=d;
    }

    public ChatModel()
    {

    }

    public String getMessage() {
        return message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public Date getTime() {
        return time;
    }

    public Image getProfileImg() {
        return ProfileImg;
    }

    public void setProfileImg(Image profileImg) {
        ProfileImg = profileImg;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
