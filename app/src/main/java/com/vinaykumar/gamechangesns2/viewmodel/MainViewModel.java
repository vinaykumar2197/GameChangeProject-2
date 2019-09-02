package com.vinaykumar.gamechangesns2.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.vinaykumar.gamechangesns2.model.Issues;
import com.vinaykumar.gamechangesns2.model.IssueRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
  private IssueRepository issueRepository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    issueRepository = new IssueRepository();
  }

  public LiveData<List<Issues>> getIssueData() {
    return issueRepository.getMutableLiveData();
  }
}
