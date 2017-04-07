package model;


import android.os.Parcel;
import android.os.Parcelable;


public class StudentDetails implements Parcelable {

    private String name, email, gender,schoolName, rollNo;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public StudentDetails(final String name, final String email, final String schoolName, final String gender, final String rollNo) {
        this.name = name;
        this.schoolName = schoolName;
        this.email = email;
        this.gender = gender;
        this.rollNo = rollNo;
    }

    public StudentDetails(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public static Creator<StudentDetails> getCREATOR() {
        return CREATOR;
    }

    protected StudentDetails(Parcel in) {
        name = in.readString();
        email = in.readString();
        gender = in.readString();
        schoolName = in.readString();
        rollNo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(gender);
        dest.writeString(schoolName);
        dest.writeString(rollNo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StudentDetails> CREATOR = new Creator<StudentDetails>() {
        @Override
        public StudentDetails createFromParcel(Parcel in) {
            return new StudentDetails(in);
        }

        @Override
        public StudentDetails[] newArray(int size) {
            return new StudentDetails[size];
        }
    };
}
