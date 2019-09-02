package com.vinaykumar.gamechangesns2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vinaykumar.gamechangesns2.R;
import com.vinaykumar.gamechangesns2.view.SummaryActivity;
import com.vinaykumar.gamechangesns2.model.Issues;

import java.util.ArrayList;

public class IssuesDataAdapter
    extends RecyclerView.Adapter<IssuesDataAdapter.EmployeeViewHolder> {

  private Context context;

  private ArrayList<Issues> issuesArrayList;

  @NonNull
  @Override
  public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.issue_list_item, parent, false);
    return new EmployeeViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull EmployeeViewHolder issueViewHolder, int i) {
    final Issues currentIssue = issuesArrayList.get(i);
    issueViewHolder.tvTitle.setText(currentIssue.getTitle());
    issueViewHolder.tvBody.setText(currentIssue.getBody());

    issueViewHolder.llRoot.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, SummaryActivity.class);
        intent.putExtra("comment_id",String.valueOf(currentIssue.getNumber()));
        context.startActivity(intent);
      }
    });

//    issueViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
////        Intent intent = new Intent(context, MainActivity.class);
////        intent.putExtra("comment_id",currentIssue.getNumber());
////        context.startActivity(intent);
//
//        Toast.makeText(context,""+currentIssue.getNumber(),Toast.LENGTH_LONG).show();
//      }
//    });


  }


  public IssuesDataAdapter(Context context , ArrayList<Issues> issuesArrayList){
    this.context = context;
    this.issuesArrayList = issuesArrayList;
   notifyDataSetChanged();
  }




  @Override
  public int getItemCount() {
    if (issuesArrayList != null) {
      return issuesArrayList.size();
    } else {
      return 0;
    }
  }

//  public void setEmployeeList(ArrayList<Issues> employees) {
//    this.issuesArrayList = employees;
//    notifyDataSetChanged();
//  }

  class EmployeeViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle , tvBody ;
    LinearLayout llRoot;

    public EmployeeViewHolder(View itemView) {
      super(itemView);

      tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
      tvBody = (TextView) itemView.findViewById(R.id.tv_body);

      llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root);

    }




  }
}
