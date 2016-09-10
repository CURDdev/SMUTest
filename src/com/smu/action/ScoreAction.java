package com.smu.action;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.smu.dao.IStudentDAO;
import com.smu.model.Case;
import com.smu.model.Requirement;
import com.smu.model.Score;
import com.smu.model.Station;
import com.smu.model.Student;
import com.smu.service.ICaseService;
import com.smu.service.IRequirementService;
import com.smu.service.IScoreService;
import com.smu.service.IStationService;
import com.smu.service.IStudentService;
import com.smu.util.Require;
import com.smu.util.StudentScore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ScoreAction extends ActionSupport {
	private IScoreService scoreService;
	private IStudentService studentService;
	private IStationService stationService ;
	private ICaseService caseService;
	private IRequirementService requirementService;
	private Score score;
	private String stc_id;
	private String c_id;
	private String class_name;
	
	public ICaseService getCaseService() {
		return caseService;
	}
	public void setCaseService(ICaseService caseService) {
		this.caseService = caseService;
	}
	public IRequirementService getRequirementService() {
		return requirementService;
	}
	public void setRequirementService(IRequirementService requirementService) {
		this.requirementService = requirementService;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public IStudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	public IStationService getStationService() {
		return stationService;
	}
	public void setStationService(IStationService stationService) {
		this.stationService = stationService;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getStc_id() {
		return stc_id;
	}
	public void setStc_id(String stc_id) {
		this.stc_id = stc_id;
	}
	public IScoreService getScoreService() {
		return scoreService;
	}
	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	public String addScore() throws Exception
	{
		scoreService.addScore(score);
		Case cas = new Case();
		cas = caseService.getOneCase(c_id);
		Requirement r = requirementService.getAllRequirements(cas.getCName());
		String stId = cas.getStation().getStId();

		String rcontent = r.getRContent();
		String rscore = r.getRScore();
		String name = r.getRName();
		String[] contents = rcontent.split(",");
		String[] scores = rscore.split(",");
		String[] names = name.split(","); 
		List<Require> r_list = new ArrayList<Require>();
		
		for(int i = 1;i<= scores.length-1;i++){
			Require require = new Require();
			require.setContent(contents[i]);
			require.setScore(scores[i]);
			require.setName(names[i]);
			r_list.add(require);
		}
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("stId",stId);
		requestMap.put("CId", c_id);
		requestMap.put("require", r_list);
		requestMap.put("RName",names[0]);
		requestMap.put("RContent",contents[0]);
		requestMap.put("RScore",scores[0]);
		requestMap.put("case", cas);
		return SUCCESS;
	}
	public String browseScores() throws Exception{
		Double score; 
		int[] score_nums = {30,40,20,50,80,70,40,30,10,5};
		List<Student> students = studentService.getStudentsByClass(class_name);
//		String[] s_no = new String[students.size()];
//		for(int i=0;i<=students.size()-1;i++){
//			s_no[i] = students.get(i).getSNo();
//		}
		List<Station> stations = stationService.gainAllStations();
		String[] st_id = new String[stations.size()];
		for(int j = 0;j<=stations.size()-1;j++){
			st_id[j] = stations.get(j).getStId();
		}
		int nums = stations.size();
		List<StudentScore> studentScores = new ArrayList<StudentScore>();
		for(int m = 0;m<=students.size()-1;m++){
			score = 0.00;
			for(int n = 0;n<=st_id.length-1;n++){
				
				List<Score> scores = scoreService.gainScore(students.get(m).getSNo(),st_id[n]);
				
				if(scores.size()==1){
					score = score + scores.get(0).getScTotalScore();
				}
				else if(scores.size()>1){
					Double average_score = 0.00;
					for(int l = 0;l<=scores.size()-1;l++){
						
						average_score = average_score + scores.get(l).getScTotalScore();	
						
					}
					average_score = average_score/scores.size();
					score = score + average_score;
					System.out.println(score);
				}
				else{
					score = score + 0.00;
				}
				
			}
			score = score/nums;
			System.out.println(score);
			if(90<=score&&score<=100)
				score_nums[0]++;
			else if(80<=score&&score<=90)
				score_nums[1]++;
			else if(70<=score&&score<=80)
				score_nums[2]++;
			else if(60<=score&&score<=70)
				score_nums[3]++;
			else if(50<=score&&score<=60)
				score_nums[4]++;
			else if(40<=score&&score<=50)
				score_nums[5]++;
			else if(30<=score&&score<=40)
				score_nums[6]++;
			else if(20<=score&&score<=30)
				score_nums[7]++;
			else if(10<=score&&score<=20)
				score_nums[8]++;
			else if(0<=score&&score<=10)
				score_nums[9]++;
			StudentScore studentScore = new StudentScore();
			studentScore.setS_no(students.get(m).getSNo());
			studentScore.setS_name(students.get(m).getSName());
			studentScore.setS_grade(students.get(m).getSGrade());
			studentScore.setS_class(students.get(m).getClassName().getClassName());
			studentScore.setScore(score);
			studentScores.add(studentScore);
		}
		
		
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("score_nums", score_nums);
		requestMap.put("studentScore", studentScores);
		requestMap.put("class_name", class_name);
		return SUCCESS;
	}
		
	
	
	public String browseStationScores() throws Exception{
		Double score; 
		Double max = 0.00;
		Double min = 100.00;
		Double ave = 0.00;
		int stu_num = 0;
		int[] score_nums = {30,40,20,50,80,70,40,30,10,5};
		List<Student> students = studentService.getAllStudents();
		System.out.print(students.get(0).getSNo());
		System.out.print(stc_id);
		List<StudentScore> studentScores = new ArrayList<StudentScore>();
		for(int m = 0;m<=students.size()-1;m++){
			score = 0.00;	
				List<Score> scores = new ArrayList<Score>();
			    scores = scoreService.gainScore(students.get(m).getSNo(), stc_id);
			
				System.out.print("is running");
				if(scores.size()==1){
					score = scores.get(0).getScTotalScore();
				}
				else if(scores.size()>1){
					Double average_score = 0.00;
					for(int l = 0;l<=scores.size()-1;l++){
						
						average_score = average_score + scores.get(l).getScTotalScore();	
						
					}
					average_score = average_score/scores.size();
					score = average_score;
				}
				else{
					score = 0.00;
				}
				
			
			if(90<=score&&score<=100)
				score_nums[0]++;
			else if(80<=score&&score<=90)
				score_nums[1]++;
			else if(70<=score&&score<=80)
				score_nums[2]++;
			else if(60<=score&&score<=70)
				score_nums[3]++;
			else if(50<=score&&score<=60)
				score_nums[4]++;
			else if(40<=score&&score<=50)
				score_nums[5]++;
			else if(30<=score&&score<=40)
				score_nums[6]++;
			else if(20<=score&&score<=30)
				score_nums[7]++;
			else if(10<=score&&score<=20)
				score_nums[8]++;
			else if(0<=score&&score<=10)
				score_nums[9]++;
			if(score>max){
				max = score;
			}
			if(score<min){
				min = score;
			}
			ave = ave + score;
			stu_num++;
			StudentScore studentScore = new StudentScore();
			studentScore.setS_no(students.get(m).getSNo());
			studentScore.setS_name(students.get(m).getSName());
			studentScore.setS_grade(students.get(m).getSGrade());
			studentScore.setS_class(students.get(m).getClassName().getClassName());
			studentScore.setScore(score);
			studentScores.add(studentScore);
		}
		ave = ave/stu_num;
		
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("score_nums", score_nums);
		requestMap.put("studentScore", studentScores);
		requestMap.put("max", max);
		requestMap.put("min", min);
		requestMap.put("ave", ave);
		return SUCCESS;
	}
}

