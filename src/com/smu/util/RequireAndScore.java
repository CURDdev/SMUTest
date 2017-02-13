package com.smu.util;

import java.util.Map;

public class RequireAndScore {
    private String content;
    private String score;
    private String name;
    private String uncommitedScore;
    public String getUncommitedScore() {
        return uncommitedScore;
    }
    public void setUncommitedScore(String uncommitedScore) {
        this.uncommitedScore = uncommitedScore;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }

}
