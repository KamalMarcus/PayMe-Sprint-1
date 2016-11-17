package com.kamal.marcus.facebooklogin;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KiMoo on 25/10/2016.
 */

public class Card implements Parcelable {
    private String name;
    private String details;
    private int icon;

    public Card(String name, String details, int icon){
        this.name=name;
        this.details=details;
        this.icon=icon;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    protected Card(Parcel in) {
        name = in.readString();
        details = in.readString();
        icon = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(details);
        dest.writeInt(icon);
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