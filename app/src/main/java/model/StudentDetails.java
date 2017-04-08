package model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * student details model class
 */
public class StudentDetails implements Parcelable {

    public static final Creator<StudentDetails> CREATOR = new Creator<StudentDetails>() {
        @Override
        public StudentDetails createFromParcel(final Parcel in) {
            return new StudentDetails(in);
        }

        @Override
        public StudentDetails[] newArray(final int size) {
            return new StudentDetails[size];
        }
    };

    private String name, email, gender, schoolName, rollNo;

    /**
     * default constructor
     */
    public StudentDetails() {

    }

    /**
     *
     * @param name name
     * @param email email
     * @param schoolName school name
     * @param gender gender
     * @param rollNo roll no
     */

    public StudentDetails(final String name, final String email, final String schoolName, final String gender, final String rollNo) {
        this.name = name;
        this.email = email;
        this.schoolName = schoolName;
        this.gender = gender;
        this.rollNo = rollNo;
    }

    /**
     *
     * @param in constructor
     */
    protected StudentDetails(final Parcel in) {
        name = in.readString();
        email = in.readString();
        schoolName = in.readString();
        gender = in.readString();
        rollNo = in.readString();
    }

    /**
     *
     * @return getting roll no
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     *
     * @param rollNo setting roll no
     */
    public void setRollNo(final String rollNo) {
        this.rollNo = rollNo;
    }
    /**
     *
     * @return getting name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name setting name
      */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return getting email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email setting email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     *
     * @return getting gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender setting gender
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return getting school name
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     *
     * @param schoolName setting school name
     */
    public void setSchoolName(final String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     *
     * @return returns creater
     */
    public static Creator<StudentDetails> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
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


}
