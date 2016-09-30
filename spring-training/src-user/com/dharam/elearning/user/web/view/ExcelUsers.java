package com.dharam.elearning.user.web.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.dharam.elearning.user.bean.User;

public class ExcelUsers extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<User> users = (List) model.get("users");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow header = sheet.createRow(0);
		header.createCell((short) 0).setCellValue("Name");
		header.createCell((short) 1).setCellValue("Code");
		header.createCell((short) 2).setCellValue("Desc");
		header.createCell((short) 3).setCellValue("Created On");
		header.createCell((short) 4).setCellValue("Modified On");
		int rowNum = 1;
		for (User user : users) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell((short) 0).setCellValue(user.getName());
			row.createCell((short) 1).setCellValue(user.getCode());
			row.createCell((short) 2).setCellValue(user.getDescription());
			row.createCell((short) 3).setCellValue(dateFormat.format(user.getCreatedOn()));
			row.createCell((short) 4).setCellValue(dateFormat.format(user.getModifiedOn()));
		}
	}

}
