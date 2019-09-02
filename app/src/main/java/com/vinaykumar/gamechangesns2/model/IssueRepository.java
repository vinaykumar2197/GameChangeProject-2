package com.vinaykumar.gamechangesns2.model;


import android.arch.lifecycle.MutableLiveData;

import com.vinaykumar.gamechangesns2.network.IssueDataService;
import com.vinaykumar.gamechangesns2.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueRepository {
  private static final String TAG = "IssueRepository";
  private ArrayList<Issues> issuesArrayList = new ArrayList<>();
  private MutableLiveData<List<Issues>> mutableLiveData = new MutableLiveData<>();

  public IssueRepository() {
  }

  public MutableLiveData<List<Issues>> getMutableLiveData() {

    final IssueDataService userDataService = RetrofitClient.getService();

    Call<List<Issues>> call = userDataService.getIssues();
    call.enqueue(new Callback<List<Issues>>() {
      @Override
      public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {
        List<Issues> employeeDBResponse = response.body();

          mutableLiveData.setValue(employeeDBResponse);
//        }
      }

      @Override
      public void onFailure(Call<List<Issues>> call, Throwable t) {

      }
    });

    return mutableLiveData;
  }
}
