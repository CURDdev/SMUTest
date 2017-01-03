package com.smu.util;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.smu.model.Requirement;


import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.smu.service.IRequirementService;
public class ExcelServiceImpl{
   
	public InputStream getExcelInputStream(List<StudentScore> scores) {
		 

        ByteArrayOutputStream out = new ByteArrayOutputStream();   

        putDataOnOutputStream(out,scores);   

        return new ByteArrayInputStream(out.toByteArray());   
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
