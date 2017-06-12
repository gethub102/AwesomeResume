package top.zhangjiashen.awesomeresome.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zjs on 2017/6/13.
 */

public class Education implements Parcelable{
    public String id;
    public String school;
    public String major;
    public Date startDate;
    public Date endDate;
    public List<String> courses;

    public Education() {
        id = UUID.randomUUID().toString();
    }
    protected Education(Parcel in) {
        id = in.readString();
        school = in.readString();
        major = in.readString();
        startDate = new Date(in.readLong());
        endDate = new Date(in.readLong());
        courses = in.createStringArrayList();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(school);
        dest.writeString(major);
        dest.writeLong(startDate.getTime());
        dest.writeLong(endDate.getTime());
        dest.writeStringList(courses);
    }
    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel source) {
            return new Education(source);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };






}
