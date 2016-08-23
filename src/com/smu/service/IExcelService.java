package com.smu.service;

import java.io.InputStream;
import java.util.List;

import com.smu.util.StudentScore;
public interface IExcelService {
	InputStream getExcelInputStream(List<StudentScore> socres);
}
