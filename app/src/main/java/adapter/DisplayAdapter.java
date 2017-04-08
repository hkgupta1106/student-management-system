package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.studentmanagement.CreateStudentActivity;
import com.example.himanshu.studentmanagement.R;

import java.util.ArrayList;

import model.StudentDetails;

/**
 * Created by himanshu on 5/4/17.
 */

public class DisplayAdapter extends android.support.v7.widget.RecyclerView.Adapter<DisplayAdapter.ViewHolder> {


    private Context context;
    private ArrayList<StudentDetails> studentDetaillist;
    private StudentDetails studentdetails;

    /**
     * @param context context
     * @param studentDetaillist student arraylist
     */
    public DisplayAdapter(final Context context, final ArrayList<StudentDetails> studentDetaillist) {
        this.context = context;
        this.studentDetaillist = studentDetaillist;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        studentdetails = studentDetaillist.get(position);

        holder.tvName.setText(studentdetails.getName());
        holder.tvSchoolName.setText(studentdetails.getSchoolName());
        holder.tvEmail.setText(studentdetails.getEmail());
        holder.tvGender.setText(studentdetails.getGender());
        holder.tvRollNo.setText(studentdetails.getRollNo());

    }

    @Override
    public int getItemCount() {
        return studentDetaillist.size();
    }


    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {


        View convertView = LayoutInflater.from(context).inflate(R.layout.customelayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        /**
         * return view holder
         */
        return viewHolder;
    }


    /**
     * view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvSchoolName, tvEmail, tvGender, tvRollNo;

        /**
         *
         * @param itemView itemm view
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_Email);
            tvName = (TextView) itemView.findViewById(R.id.tv_Name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_Gender);
            tvSchoolName = (TextView) itemView.findViewById(R.id.tv_SchoolName);
            tvRollNo = (TextView) itemView.findViewById(R.id.tv_Roll_No);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        final AlertDialog.Builder dialogbox = new AlertDialog.Builder(itemView.getContext());
                        dialogbox.setTitle("Select option :");
                        dialogbox.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {

                            }

                        });

                        dialogbox.setNegativeButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {
                                Intent intent = new Intent(context, CreateStudentActivity.class);
                                intent.putExtra("key", "view");
                                intent.putExtra("object", studentDetaillist.get(pos));
                                context.startActivity(intent);
                            }

                        });

                        dialogbox.setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {
                                Intent intent = new Intent(context, CreateStudentActivity.class);
                                intent.putExtra("object", studentDetaillist.get(pos));
                                intent.putExtra("key", "edit");
                                intent.putExtra("pos", pos);
                                ((Activity) context).startActivityForResult(intent, 2);

                            }

                        });
                        dialogbox.create();
                        dialogbox.show();
                    }
                }
            });
        }
    }
}