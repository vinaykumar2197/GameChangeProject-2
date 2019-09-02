package com.vinaykumar.gamechangesns2.network;


import com.vinaykumar.gamechangesns2.model.Comments;
import com.vinaykumar.gamechangesns2.model.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IssueDataService {

  @GET("repos/firebase/firebase-ios-sdk/issues")
  Call<List<Issues>> getIssues();


  @GET("repos/firebase/firebase-ios-sdk/issues/{comment_id}/comments")
  Call<List<Comments>> getCommentDetails(@Path(value = "comment_id", encoded = true) String userId);




}
