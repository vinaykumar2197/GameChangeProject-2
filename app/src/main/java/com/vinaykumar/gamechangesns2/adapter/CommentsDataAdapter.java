package com.vinaykumar.gamechangesns2.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vinaykumar.gamechangesns2.R;
import com.vinaykumar.gamechangesns2.model.Comments;
import com.vinaykumar.gamechangesns2.model.Issues;

import java.util.ArrayList;

public class CommentsDataAdapter
    extends RecyclerView.Adapter<CommentsDataAdapter.EmployeeViewHolder> {

  private Context context;

  private ArrayList<Comments> commentsList;

  @NonNull
  @Override
  public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item, parent, false);
    return new EmployeeViewHolder(view);
  }


  public CommentsDataAdapter(Context context , ArrayList<Comments> countryModelArrayList){
    this.context = context;
    this.commentsList = countryModelArrayList;
    notifyDataSetChanged();
  }

  @Override
  public void onBindViewHolder(@NonNull EmployeeViewHolder issueViewHolder, int i) {
    final Comments currentIssue = commentsList.get(i);
    issueViewHolder.tvAutherName.setText(currentIssue.getAutherName());
    issueViewHolder.tvBody.setText(currentIssue.getBody());

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



  @Override
  public int getItemCount() {
    if (commentsList != null) {
      return commentsList.size();
    } else {
      return 0;
    }
  }

  public void setCommentList(ArrayList<Comments> commentsList) {
    this.commentsList = commentsList;
    notifyDataSetChanged();
  }

  class EmployeeViewHolder extends RecyclerView.ViewHolder {

//    private EmployeeListItemBinding employeeListItemBinding;
//
////    private LinearLayout linearLayout ;
//
//    public EmployeeViewHolder(@NonNull EmployeeListItemBinding employeetListItemBinding) {
//      super(employeetListItemBinding.getRoot());
//
////      linearLayout = (LinearLayout) employeetListItemBinding.getRoot().findViewById(R.id.ll_root);
//
//      this.employeeListItemBinding = employeetListItemBinding;
//
//    }


    TextView tvAutherName , tvBody ;

    public EmployeeViewHolder(View itemView) {
      super(itemView);

      tvAutherName = (TextView) itemView.findViewById(R.id.tv_auther_name);
      tvBody = (TextView) itemView.findViewById(R.id.tv_body);


    }




  }
}
