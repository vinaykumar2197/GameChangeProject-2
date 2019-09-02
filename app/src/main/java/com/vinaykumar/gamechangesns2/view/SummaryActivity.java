package com.vinaykumar.gamechangesns2.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vinaykumar.gamechangesns2.viewmodel.CommentViewModel;
import com.vinaykumar.gamechangesns2.MyViewModelFactory;
import com.vinaykumar.gamechangesns2.R;
import com.vinaykumar.gamechangesns2.adapter.CommentsDataAdapter;
import com.vinaykumar.gamechangesns2.model.Comments;

import java.util.ArrayList;
import java.util.List;

public class SummaryActivity extends AppCompatActivity {
  private CommentViewModel commentViewModel;
  private CommentsDataAdapter commentsDataAdapter;
  RecyclerView recyclerView;
  AlertDialog.Builder builder;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_summary);
    builder = new AlertDialog.Builder(this);

    progressDialog = new ProgressDialog(SummaryActivity.this);
    progressDialog.setMessage("Fetching Commensts ...");

    // bind RecyclerView
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);

    Intent intent = getIntent();
    String commentId = intent.getStringExtra("comment_id");

    //mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    commentViewModel = ViewModelProviders.of(this,  new MyViewModelFactory(getApplication(),commentId)).get(CommentViewModel.class);

    progressDialog.show();
    getAllEmployee();
  }

  private void getAllEmployee() {
    commentViewModel.getIssueData().observe(this, new Observer<List<Comments>>() {
      @Override
      public void onChanged(@Nullable List<Comments> employees) {
        progressDialog.dismiss();
        commentsDataAdapter= new CommentsDataAdapter(SummaryActivity.this , (ArrayList<Comments>) employees);
        recyclerView.setAdapter(commentsDataAdapter);

        if(employees.size()<=0){
          callDialog();
        }
      }
    });
  }


  public void callDialog(){
    builder.setMessage("No comments Available")
            .setCancelable(false)
            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                finish();
              }
            });
    //Creating dialog box
    AlertDialog alert = builder.create();
    //Setting the title manually
    alert.setTitle("Dialog Info");
    alert.show();
  }
}
