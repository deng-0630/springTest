package com.bdqn.test;


import java.io.Serializable;

public class Grade {

  private int gradeId;
  private String gradeName;
  public Grade(){}
  public Grade(int gradeId) {
    this.gradeId = gradeId;
  }

  @Override
  public String toString() {
    return "Grade{" +
            "gradeId=" + gradeId +
            ", gradeName='" + gradeName + '\'' +
            '}';
  }

  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }


  public String getGradeName() {
    return gradeName;
  }

  public void setGradeName(String gradeName) {
    this.gradeName = gradeName;
  }

}
