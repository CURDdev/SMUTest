package com.smu.util;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class ExcelServiceImpl{
	public InputStream getExcelInputStream(List<StudentScore> scores) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        putDataOnOutputStream(out,scores);
        return new ByteArrayInputStream(out.toByteArray());   
	}
    public InputStream getExcelInputStreamAllCases(List<StudentAllCaseScore> scores) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        putDataOnOutputStreamAllCases(out,scores);
        return new ByteArrayInputStream(out.toByteArray());
    }
    public InputStream getExcelInputStreamAllCasesByRows(List<totalScore> scores,List<String> stationNames) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        putDataOnOutputStreamAllCasesByRows(out,scores,stationNames);
        return new ByteArrayInputStream(out.toByteArray());
    }
    private void putDataOnOutputStreamAllCasesByRows(OutputStream os,List<totalScore> scores,List<String> stationNames) {
        jxl.write.Label label;
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            sheet.addCell(new jxl.write.Label(0, 0, "学号"));
            sheet.addCell(new jxl.write.Label(1, 0, "姓名"));
            sheet.addCell(new jxl.write.Label(2, 0, "班级"));
            for(int i = 0;i<=scores.get(0).getStationNums()-1;i++){
                sheet.addCell(new jxl.write.Label(i+3,0,stationNames.get(i).toString()));
            }
            for(int i = 0;i<=scores.size()-1;i++){
                sheet.addCell(new jxl.write.Label(0, i+1, scores.get(i).getStudentNum()));
                sheet.addCell(new jxl.write.Label(1, i+1, scores.get(i).getStudentName()));
                sheet.addCell(new jxl.write.Label(2, i+1, scores.get(i).getStduentClassName()));
                for(int j = 0;j<=scores.get(j).getStationNums()-1;j++){
                    sheet.addCell(new jxl.write.Label(j+3,i+1,scores.get(i).getAllCasesScores().get(j).toString()));
                }
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void putDataOnOutputStreamAllCases(OutputStream os,List<StudentAllCaseScore> scores) {
        jxl.write.Label label;
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(os);
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            sheet.addCell(new jxl.write.Label(0, 0, "学号"));
            sheet.addCell(new jxl.write.Label(1, 0, "姓名"));
            sheet.addCell(new jxl.write.Label(2, 0, "年级"));
            sheet.addCell(new jxl.write.Label(3, 0, "班级"));
            sheet.addCell(new jxl.write.Label(4, 0, "站名"));
            sheet.addCell(new jxl.write.Label(5, 0, "案例名"));
            sheet.addCell(new jxl.write.Label(6, 0, "打分老师"));
            sheet.addCell(new jxl.write.Label(7, 0, "成绩"));
            for(int i = 0;i<=scores.size()-1;i++){
                sheet.addCell(new jxl.write.Label(0, i+1, scores.get(i).getSNo()));
                sheet.addCell(new jxl.write.Label(1, i+1, scores.get(i).getSName()));
                sheet.addCell(new jxl.write.Label(2, i+1, scores.get(i).getSGrade()));
                sheet.addCell(new jxl.write.Label(3, i+1, scores.get(i).getSClass()));
                sheet.addCell(new jxl.write.Label(4, i+1, scores.get(i).getStationName()));
                sheet.addCell(new jxl.write.Label(5, i+1, scores.get(i).getCaseName()));
                sheet.addCell(new jxl.write.Label(6, i+1, scores.get(i).getTName()));
                sheet.addCell(new jxl.write.Label(7, i+1, String.valueOf(scores.get(i).getScore())));

            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void putDataOnOutputStream(OutputStream os,List<StudentScore> scores) {
        jxl.write.Label label;
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(os);      
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            sheet.addCell(new jxl.write.Label(0, 0, "学号"));
            sheet.addCell(new jxl.write.Label(1, 0, "姓名"));
            sheet.addCell(new jxl.write.Label(2, 0, "年级"));
            sheet.addCell(new jxl.write.Label(3, 0, "班级"));
            sheet.addCell(new jxl.write.Label(4, 0, "成绩"));
            for(int i = 0;i<=scores.size()-1;i++){
            sheet.addCell(new jxl.write.Label(0, i+1, scores.get(i).getS_no()));
            sheet.addCell(new jxl.write.Label(1, i+1, scores.get(i).getS_name()));
            sheet.addCell(new jxl.write.Label(2, i+1, scores.get(i).getS_grade()));
            sheet.addCell(new jxl.write.Label(3, i+1, scores.get(i).getS_class()));
            sheet.addCell(new jxl.write.Label(4, i+1, String.valueOf(scores.get(i).getScore())));
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }   

    }   

}
