package com.smu.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smu.model.*;
import com.smu.service.*;

import com.smu.util.ExcelServiceImpl;
import com.smu.util.StudentAllCaseScore;
import com.smu.util.StudentScore;
import com.smu.util.totalScore;

public class ExcelAction extends ActionSupport{
	private IRequirementService requirementService;
	private IScoreService scoreService;
	private IStudentService studentService;
	private IStationService stationService ;
	private ICaseService caseService;
    InputStream excelStream;   
    private String filename;
    private String class_name;
    private int test_id;
    private IClassService classService;
    private IUserService userService;
    private ITestService iTestService;

	public ITestService getiTestService() {
		return iTestService;
	}

	public void setiTestService(ITestService iTestService) {
		this.iTestService = iTestService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IClassService getClassService() {
		return classService;
	}

	public void setClassService(IClassService classService) {
		this.classService = classService;
	}

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

	public String getSumScoreExcel() throws Exception{
		Double score;
		if(class_name.equals("全部全部")){
			String classesString = iTestService.getOneTest(test_id).getClassName();
			String[] classes = classesString.split(",");
			List<StudentScore> studentScores = new ArrayList<StudentScore>();
			for(int t = 0;t<=classes.length-1;t++) {
				List<Student> students = studentService.getStudentsByClass(classes[t]);
				List<Station> stations = stationService.gainAllStations(test_id);
				int[] st_id = new int[stations.size()];
				for (int j = 0; j <= stations.size() - 1; j++) {
					st_id[j] = stations.get(j).getStId();
				}
				int nums = stations.size();
				for (int m = 0; m <= students.size() - 1; m++) {
					score = 0.00;
					for (int n = 0; n <= st_id.length - 1; n++) {
						List<Score> scores = scoreService.gainScore(students.get(m).getSNo(), st_id[n]);
						if (scores.size() == 1) {
							score = score + scores.get(0).getScTotalScore();
						} else if (scores.size() > 1) {
							Double average_score = 0.00;
							for (int l = 0; l <= scores.size() - 1; l++) {
								average_score = average_score + scores.get(l).getScTotalScore();
							}
							average_score = average_score / scores.size();
							score = score + average_score;
							System.out.println(score);
						} else {
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
			}
			ExcelServiceImpl es = new ExcelServiceImpl();
			excelStream = es.getExcelInputStream(studentScores);
			return "excel";
		}
		List<Student> students = studentService.getStudentsByClass(class_name);
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
    public String getAllcasesScoreExcel() throws Exception{
		Double score;
		if(class_name.equals("全部全部")){
			long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
			System.out.println("开始 "+startMili);
			String classesString = iTestService.getOneTest(test_id).getClassName();
			String[] classes = classesString.split(",");
			List<StudentAllCaseScore> studentScores = new ArrayList<StudentAllCaseScore>();
			for(int t = 0;t<=classes.length-1;t++) {
				List<Student> students = studentService.getStudentsByClass(classes[t]);
				List<Station> stations = stationService.gainAllStations(test_id);
				int[] st_id = new int[stations.size()];
				for (int j = 0; j <= stations.size() - 1; j++) {
					st_id[j] = stations.get(j).getStId();
				}
				int nums = stations.size();
				for (int m = 0; m <= students.size() - 1; m++) {
					score = 0.00;
					for (int n = 0; n <= st_id.length - 1; n++) {
						List<Case> cases = caseService.getCases(st_id[n]);
						for(int k = 0;k<=cases.size()-1;k++) {
							List<Score> scores = scoreService.getScoreBySNoAndCId(students.get(m).getSNo(), cases.get(k).getCId());
							if(scores.size()==0){
								StudentAllCaseScore studentScore = new StudentAllCaseScore();
								studentScore.setSNo(students.get(m).getSNo());
								studentScore.setSName(students.get(m).getSName());
								studentScore.setSGrade(students.get(m).getSGrade());
								studentScore.setSClass(students.get(m).getMclass().getClassName());
								studentScore.setCaseName("未参加"+cases.get(k).getCName()+"案例考试");
								studentScore.setStationName("未参加"+stations.get(n).getStName()+"站考试");
								studentScore.setTName("未参加本案例考试");
								studentScore.setScore(score);
								studentScores.add(studentScore);
							}
							for(int v = 0;v<=scores.size()-1;v++){
								System.out.println(score);
								StudentAllCaseScore studentScore = new StudentAllCaseScore();
								studentScore.setSNo(students.get(m).getSNo());
								studentScore.setSName(students.get(m).getSName());
								studentScore.setSGrade(students.get(m).getSGrade());
								studentScore.setSClass(students.get(m).getMclass().getClassName());
								studentScore.setCaseName(cases.get(k).getCName());
								studentScore.setStationName(stations.get(n).getStName());
								studentScore.setTName(userService.getTeacherByTId(scores.get(v).getTeacher().getTId()).getTName());
								studentScore.setScore(scores.get(v).getScTotalScore());
								studentScores.add(studentScore);
							}
						}
					}

				}
			}
			long endMili=System.currentTimeMillis();
			System.out.println("结束 s"+endMili);
			System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
			long startMili1=System.currentTimeMillis();// 当前时间对应的毫秒数
			System.out.println("开始 "+startMili);
			ExcelServiceImpl es = new ExcelServiceImpl();
			excelStream = es.getExcelInputStreamAllCases(studentScores);
			long endMili1=System.currentTimeMillis();
			System.out.println("结束 s"+endMili);
			System.out.println("总耗时为："+(endMili1-startMili1)+"毫秒");
			return "excel";
		}
		List<StudentAllCaseScore> studentScores = new ArrayList<StudentAllCaseScore>();

		List<Student> students = studentService.getStudentsByClass(class_name);
		List<Station> stations = stationService.gainAllStations(test_id);
		int[] st_id = new int[stations.size()];
		for (int j = 0; j <= stations.size() - 1; j++) {
			st_id[j] = stations.get(j).getStId();
		}
		int nums = stations.size();
		for (int m = 0; m <= students.size() - 1; m++) {
			score = 0.00;
			for (int n = 0; n <= st_id.length - 1; n++) {
				List<Case> cases = caseService.getCases(st_id[n]);
				for(int k = 0;k<=cases.size()-1;k++) {
					List<Score> scores = scoreService.getScoreBySNoAndCId(students.get(m).getSNo(), cases.get(k).getCId());
					if(scores.size()==0){
						StudentAllCaseScore studentScore = new StudentAllCaseScore();
						studentScore.setSNo(students.get(m).getSNo());
						studentScore.setSName(students.get(m).getSName());
						studentScore.setSGrade(students.get(m).getSGrade());
						studentScore.setSClass(students.get(m).getMclass().getClassName());
						studentScore.setCaseName("未参加"+cases.get(k).getCName()+"案例考试");
						studentScore.setStationName("未参加"+stations.get(n).getStName()+"站考试");
						studentScore.setTName("未参加本案例考试");
						studentScore.setScore(score);
						studentScores.add(studentScore);
					}
					for(int v = 0;v<=scores.size()-1;v++){
						System.out.println(score);
						StudentAllCaseScore studentScore = new StudentAllCaseScore();
						studentScore.setSNo(students.get(m).getSNo());
						studentScore.setSName(students.get(m).getSName());
						studentScore.setSGrade(students.get(m).getSGrade());
						studentScore.setSClass(students.get(m).getMclass().getClassName());
						studentScore.setCaseName(cases.get(k).getCName());
						studentScore.setStationName(stations.get(n).getStName());
						int TId = scores.get(v).getTId();
						studentScore.setTName(scores.get(v).getTName());
						studentScore.setScore(score);
						studentScores.add(studentScore);
					}
				}
			}

		}
		ExcelServiceImpl es = new ExcelServiceImpl();
		excelStream = es.getExcelInputStreamAllCases(studentScores);
		return "excel";
	}
    //get set...   
    public String getParticularScoresExcel() throws Exception{
		Double score;
		if(class_name.equals("全部全部")){
			long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
			System.out.println("开始 "+startMili);
			String classesString = iTestService.getOneTest(test_id).getClassName();
			String[] classes = classesString.split(",");
			List<String> stationNames = new ArrayList<>();
			List<totalScore> studentScores = new ArrayList<totalScore>();
			for(int t = 0;t<=classes.length-1;t++) {
				List<Student> students = studentService.getStudentsByClass(classes[t]);
				List<Station> stations = stationService.gainAllStations(test_id);

				int[] st_id = new int[stations.size()];
				for (int j = 0; j <= stations.size() - 1; j++) {
					st_id[j] = stations.get(j).getStId();
					stationNames.add(stations.get(j).getStName());
				}
				for (int m = 0; m <= students.size() - 1; m++) {
					score = 0.00;
					totalScore studentScore = new totalScore();
					studentScore.setStationNums(st_id.length);
					studentScore.setStudentNum(students.get(m).getSNo());
					studentScore.setStudentName(students.get(m).getSName());
					studentScore.setStduentClassName(students.get(m).getMclass().getClassName());
					List<Double> scoresExcel = new ArrayList<Double>();
					for (int n = 0; n <= st_id.length - 1; n++) {
						double averageScore = 0;
						List<Case> cases = caseService.getCases(st_id[n]);
						for(int k = 0;k<=cases.size()-1;k++) {
							List<Score> scores = scoreService.getScoreBySNoAndCId(students.get(m).getSNo(), cases.get(k).getCId());
							if(scores.size()==0){
								averageScore = 0.0;
							}
							for(int v = 0;v<=scores.size()-1;v++){
							    averageScore = averageScore + scores.get(v).getScTotalScore();
							}
							if(averageScore > 0.0) {
								averageScore = averageScore / scores.size();
							}
						}
						scoresExcel.add(averageScore);
					}
					studentScore.setAllCasesScores(scoresExcel);
					studentScores.add(studentScore);

				}
			}
			long endMili=System.currentTimeMillis();
			System.out.println("结束 s"+endMili);
			System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
			long startMili1=System.currentTimeMillis();// 当前时间对应的毫秒数
			System.out.println("开始 "+startMili);
			ExcelServiceImpl es = new ExcelServiceImpl();
			excelStream = es.getExcelInputStreamAllCasesByRows(studentScores,stationNames);
			long endMili1=System.currentTimeMillis();
			System.out.println("结束 s"+endMili);
			System.out.println("总耗时为："+(endMili1-startMili1)+"毫秒");
			return "excel";
		}
		long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		System.out.println("开始 "+startMili);
		String classesString = iTestService.getOneTest(test_id).getClassName();
		List<String> stationNames = new ArrayList<>();
		List<totalScore> studentScores = new ArrayList<totalScore>();
		List<Student> students = studentService.getStudentsByClass(class_name);
		List<Station> stations = stationService.gainAllStations(test_id);
		int[] st_id = new int[stations.size()];
		for (int j = 0; j <= stations.size() - 1; j++) {
			st_id[j] = stations.get(j).getStId();
			stationNames.add(stations.get(j).getStName());
		}
			for (int m = 0; m <= students.size() - 1; m++) {
				score = 0.00;
				totalScore studentScore = new totalScore();
				studentScore.setStationNums(st_id.length);
				studentScore.setStudentNum(students.get(m).getSNo());
				studentScore.setStudentName(students.get(m).getSName());
				studentScore.setStduentClassName(students.get(m).getMclass().getClassName());
				List<Double> scoresExcel = new ArrayList<Double>();
				for (int n = 0; n <= st_id.length - 1; n++) {
					double averageScore = 0;
					List<Case> cases = caseService.getCases(st_id[n]);
					for(int k = 0;k<=cases.size()-1;k++) {
						List<Score> scores = scoreService.getScoreBySNoAndCId(students.get(m).getSNo(), cases.get(k).getCId());
						if(scores.size()==0){
							averageScore = 0.0;
						}
						for(int v = 0;v<=scores.size()-1;v++){
							averageScore = averageScore + scores.get(v).getScTotalScore();
						}
						if(averageScore > 0.0) {
							averageScore = averageScore / scores.size();
						}
					}
					scoresExcel.add(averageScore);
				}
				studentScore.setAllCasesScores(scoresExcel);
				studentScores.add(studentScore);

			}
		long endMili=System.currentTimeMillis();
		System.out.println("结束 s"+endMili);
		System.out.println("总耗时为："+(endMili-startMili)+"毫秒");
		long startMili1=System.currentTimeMillis();// 当前时间对应的毫秒数
		System.out.println("开始 "+startMili);
		ExcelServiceImpl es = new ExcelServiceImpl();
		excelStream = es.getExcelInputStreamAllCasesByRows(studentScores,stationNames);
		long endMili1=System.currentTimeMillis();
		System.out.println("结束 s"+endMili);
		System.out.println("总耗时为："+(endMili1-startMili1)+"毫秒");
		return "excel";
	}
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
}  
