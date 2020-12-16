package com.bdqn.test;


public class Subject {

  private int subjectId;
  private String subjectName;
  private int classHour;
  private int gradeId;
  public Subject(){

  }
  public Subject(int subjectId) {
    this.subjectId = subjectId;
  }

  @Override
  public String toString() {
    return "Subject{" +
            "subjectId=" + subjectId +
            ", subjectName='" + subjectName + '\'' +
            ", classHour=" + classHour +
            ", gradeId=" + gradeId +
            '}';
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }


  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }


  public int getClassHour() {
    return classHour;
  }

  public void setClassHour(int classHour) {
    this.classHour = classHour;
  }


  public int getGradeId() {
    return gradeId;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }

}
