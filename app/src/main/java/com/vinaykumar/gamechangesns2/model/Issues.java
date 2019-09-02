
package com.vinaykumar.gamechangesns2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vinaykumar.gamechangesns2.R;

public class Issues {
  @SerializedName("title")
  @Expose
  private String title;


  @SerializedName("body")
  @Expose
  private String body;

  @SerializedName("number")
  @Expose
  private int number;


  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }






  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


}
