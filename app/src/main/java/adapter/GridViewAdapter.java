package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.himanshu.studentmanagement.R;

import java.util.ArrayList;

import model.StudentDetails;

/**
 * Created by himanshu on 5/4/17.
 */

public class GridViewAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<StudentDetails> studentdeatails;
    private TextView tvName, tvSchoolName, tvEmail, tvGender, tvRollNo;

    /**
     * @param context         context
     * @param studentdeatails arraylist object
     */
    public GridViewAdapter(final Context context, final ArrayList<StudentDetails> studentdeatails) {
        this.context = context;
        this.studentdeatails = studentdeatails;
    }

    @Override
    public int getCount() {
        return studentdeatails.size();
    }

    @Override
    public Object getItem(final int position) {
        return studentdeatails.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View view, final ViewGroup parent) {
        View convertView;

        convertView = LayoutInflater.from(context).inflate(R.layout.customelayout, parent, false);

        StudentDetails studentdetails = (StudentDetails) getItem(position);
        tvName = (TextView) convertView.findViewById(R.id.tv_Name);
        tvSchoolName = (TextView) convertView.findViewById(R.id.tv_SchoolName);
        tvEmail = (TextView) convertView.findViewById(R.id.tv_Email);
        tvGender = (TextView) convertView.findViewById(R.id.tv_Gender);
        tvRollNo = (TextView) convertView.findViewById(R.id.tv_Roll_No);

        tvName.setText(studentdetails.getName());
        tvSchoolName.setText(studentdetails.getSchoolName());
        tvEmail.setText(studentdetails.getEmail());
        tvGender.setText(studentdetails.getGender());
        tvRollNo.setText(studentdetails.getRollNo());
        return convertView;

    }
}
