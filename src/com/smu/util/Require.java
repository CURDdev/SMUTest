package com.smu.util;

import java.util.Map;

public class Require {
private String content;
private String score;
private String name;
private Map<String,String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
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
