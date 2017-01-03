package com.smu.action;

import java.io.InputStream;    
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.smu.model.Requirement;
import com.smu.model.Score;
import com.smu.model.Station;
import com.smu.model.Student;
import com.smu.service.ICaseService;

import com.smu.service.IRequirementService;
import com.smu.service.IScoreService;
import com.smu.service.IStationService;
import com.smu.service.IStudentService;
import com.smu.util.ExcelServiceImpl;
import com.smu.util.StudentScore;
public class ExcelAction {   
	private IRequirementService requirementService;
	private IScoreService scoreService;
	private IStudentService studentService;
	private IStationService stationService ;
	private ICaseService caseService;
    InputStream excelStream;   
    private String filename;
    private String class_name;
    private int test_id;
    
    public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public IScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
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

	public ICaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(ICaseService caseService) {
		this.caseService = caseService;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public IRequirementService getRequirementService() {
		return requirementService;
	}

	public void setRequirementService(IRequirementService requirementService) {
		this.requirementService = requirementService;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String execute(){   
		Double score; 
		
		List<Student> students = studentService.getStudentsByClass(class_name);
//		String[] s_no = new String[students.size()];
//		for(int i=0;i<=students.size()-1;i++){
//			s_no[i] = students.get(i).getSNo();
//		}
		List<Station> stations = stationService.gainAllStations(test_id);
		int[] st_id = new int[stations.size()];
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
					score = score + scores.get(0).getScTotalScore()/nums;
				}
				else if(scores.size()>1){
					
					for(int l = 0;l<=scores.size()-1;l++){
						Double average_scroe = 0.00;
						average_scroe = average_scroe + scores.get(l).getScTotalScore();	
						average_scroe = average_scroe/scores.size();
						score = score + average_scroe/nums;
					}
				}
				else{
					score = score + 0.00;
				}
				
			}
			
			StudentScore studentScore = new StudentScore();
			studentScore.setS_no(students.get(m).getSNo());
			studentScore.setS_name(students.get(m).getSName());
			studentScore.setS_grade(students.get(m).getSGrade());
			studentScore.setS_class(students.get(m).getMclass().getClassName());
			studentScore.setScore(score);
			studentScores.add(studentScore);
		}
		
		ExcelServiceImpl es = new ExcelServiceImpl();   
        excelStream = es.getExcelInputStream(studentScores);   
        return "excel";   
    }   
    //get set...   

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
}  
