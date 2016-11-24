package com.kamal.marcus.facebooklogin;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KiMoo on 25/10/2016.
 */

public class Card implements Parcelable {
    private String name;
    private String details;
    private String imageUrl;

    public Card(String name, String details, String imageUrl) {
        this.name = name;
        this.details = details;
        this.setImageUrl(imageUrl);
    }

    public Card() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    protected Card(Parcel in) {
        name = in.readString();
        details = in.readString();
        imageUrl=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(details);
        dest.writeString(imageUrl);
    }

    @SuppressWarnings("unused")
    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };


}