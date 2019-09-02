package com.vinaykumar.gamechangesns2.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vinaykumar.gamechangesns2.viewmodel.MainViewModel;
import com.vinaykumar.gamechangesns2.R;
import com.vinaykumar.gamechangesns2.adapter.IssuesDataAdapter;
import com.vinaykumar.gamechangesns2.model.Issues;

import com.vinaykumar.gamechangesns2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private MainViewModel mainViewModel;
  private IssuesDataAdapter issuesDataAdapter;
  RecyclerView recyclerView;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    progressDialog = new ProgressDialog(MainActivity.this);
    progressDialog.setMessage("Fetching issues ...");
    // bind RecyclerView
    recyclerView = activityMainBinding.viewEmployees;
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);

    //mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//    issuesDataAdapter = new IssuesDataAdapter(this,);

    progressDialog.show();
    getAllEmployee();
  }

  private void getAllEmployee() {
    mainViewModel.getIssueData().observe(this, new Observer<List<Issues>>() {
      @Override
      public void onChanged(@Nullable List<Issues> employees) {
        progressDialog.dismiss();
        issuesDataAdapter= new IssuesDataAdapter(MainActivity.this , (ArrayList<Issues>) employees);
        recyclerView.setAdapter(issuesDataAdapter);
      }
    });
  }
}
