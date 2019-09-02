
package com.vinaykumar.gamechangesns2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comments {


  @SerializedName("author_association")
  @Expose
  private String autherName;


  @SerializedName("body")
  @Expose
  private String body;


  public String getAutherName() {
    return autherName;
  }

  public void setAutherName(String autherName) {
    this.autherName = autherName;
  }



  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


}
