package com.vinaykumar.gamechangesns2.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.vinaykumar.gamechangesns2.model.CommentRepository;
import com.vinaykumar.gamechangesns2.model.Comments;
import com.vinaykumar.gamechangesns2.model.IssueRepository;
import com.vinaykumar.gamechangesns2.model.Issues;

import java.util.List;

public class CommentViewModel extends AndroidViewModel {
  private CommentRepository commentRepository;
  String commentId;

  public CommentViewModel(@NonNull Application application,String commentId) {
    super(application);
    commentRepository = new CommentRepository();
    this.commentId = commentId;
  }

  public LiveData<List<Comments>> getIssueData() {
    return commentRepository.getMutableLiveData(commentId);
  }
}
