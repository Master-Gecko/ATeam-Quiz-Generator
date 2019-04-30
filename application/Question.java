package application;

import java.util.List;

/**
 * 
 * Filename:   Question.java
 * Project:    ATeam Quiz Generator
 * Course:     cs400 Spring 2019
 * Authors:    Sammy Zopf 
 * 
 */
public class Question {
    private String metaData;
    private String topic;
    private String question;
    private String imagePath;
    private List<Answer> answerList;
    private String answer;
    
    public Question(String topic, String metaData, String question, String imagePath, List<Answer> answerList) {
        this.topic = topic;
        this.metaData = metaData;
        this.question = question;
        this.imagePath = imagePath;
        this.answerList = answerList;
    }

    public String getTopic() {
        return topic;
    }
    
    public String getMetaData() {
      return metaData;
    }

    public String getQuestion() {
        return question;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }
    
    public String getAnswer() {
        for (Answer answer : answerList) {
            if (answer.isCorrect()) {
                this.answer = answer.toString();
            }
        }
        return this.answer;
    }
    
    @Override
    public String toString() {
      String output = "\t";
      output += "meta-data:" + this.metaData + "\n\t";
      output += "topic:" + this.topic + "\n\t";
      output += "question:" + this.question + "\n\t";
      output += "imagepath:" + this.imagePath + "\n";
      for (Answer answer : answerList) {
        output += "\tisCorrect:";
        if (answer.isCorrect())
          output += "T, ";
        else
          output += "F, ";
        output += "answer:" + answer + "\n";
      }
      return output + "\n";
    }
}
