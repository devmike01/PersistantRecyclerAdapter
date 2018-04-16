package com.jadebyte.devmike.persistantrecycleradapter.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DevMike on 4/13/2018.
 */

public class SampleItems implements Parcelable{

    private String str;

    public SampleItems() {
    }

    public static final Creator<SampleItems> CREATOR = new Creator<SampleItems>() {
        @Override
        public SampleItems createFromParcel(Parcel in) {
            SampleItems items = new SampleItems();
            items.str = in.readString();
            return items;
        }

        @Override
        public SampleItems[] newArray(int size) {
            return new SampleItems[size];
        }
    };

    public void setStr(String s){
        str =s;
    }

    public String getStr(){
        return str;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(str);
    }
}
