package com.vinaykumar.gamechangesns2.model;


import android.arch.lifecycle.MutableLiveData;

import com.vinaykumar.gamechangesns2.network.IssueDataService;
import com.vinaykumar.gamechangesns2.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRepository {
  private static final String TAG = "IssueRepository";
  private ArrayList<Comments> issuesArrayList = new ArrayList<>();
  private MutableLiveData<List<Comments>> mutableLiveData = new MutableLiveData<>();

  public CommentRepository() {
  }

  public MutableLiveData<List<Comments>> getMutableLiveData(String id ) {

    final IssueDataService userDataService = RetrofitClient.getService();

    Call<List<Comments>> call = userDataService.getCommentDetails(id);
    call.enqueue(new Callback<List<Comments>>() {
      @Override
      public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
        List<Comments> employeeDBResponse = response.body();

          mutableLiveData.setValue(employeeDBResponse);
//        }
      }

      @Override
      public void onFailure(Call<List<Comments>> call, Throwable t) {

      }
    });

    return mutableLiveData;
  }
}
