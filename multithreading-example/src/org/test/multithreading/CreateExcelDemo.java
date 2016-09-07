package org.test.multithreading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class CreateExcelDemo {

	private HSSFWorkbook workbook = new HSSFWorkbook();
	private static HSSFCellStyle headerStyle;
	HSSFWorkbook     excelWorkbook     = new HSSFWorkbook();
	HSSFSheet        excelSheet        = null;
	HSSFRow          sheetRow          = null;
	HSSFCell         rowCell           = null;
	
	 
	public CreateExcelDemo() {
		headerStyle = this.workbook.createCellStyle();
		//this.headerStyle.setFont(headerFont);
		this.headerStyle.setFillPattern(headerStyle.SOLID_FOREGROUND);
		this.headerStyle.setBorderBottom(headerStyle.BORDER_THIN);
		this.headerStyle.setBorderLeft(headerStyle.BORDER_THIN);
		this.headerStyle.setBorderRight(headerStyle.BORDER_THIN);
		this.headerStyle.setBorderTop(headerStyle.BORDER_THIN);
		this.headerStyle.setBottomBorderColor(HSSFColor.WHITE.index);
		this.headerStyle.setLeftBorderColor(HSSFColor.WHITE.index);
		this.headerStyle.setRightBorderColor(HSSFColor.WHITE.index);
		this.headerStyle.setTopBorderColor(HSSFColor.WHITE.index);
	}
	
	public HSSFSheet createSheet(String sheetName){
		return workbook.createSheet(sheetName);
	}
	
	
	 public HSSFCellStyle getHeaderStyle()
	 {
		 return this.headerStyle;
	 }
	
	public void writeContent(HSSFSheet sheet){
		
		String name = sheet.getSheetName();
		for (int i = 0; i < 255; i++) {
			HSSFRow rowA = sheet.createRow(i);
			for (int j = 0; j < 255; j++) {
				HSSFCell cellA = rowA.createCell(j);
				cellA.setCellValue(new HSSFRichTextString(name + " Dummy Content " + i + " - " + j));
				//cellA.setCellStyle(headerStyle);
			} 
		}
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public void generateExcel(String fileName){
		FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:\\"+fileName+".xls"));
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	public static void main(String[] args) {
        
		CreateExcelDemo createExcelDemo = new CreateExcelDemo();
		
		long startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			HSSFSheet sheet = createExcelDemo.createSheet("sheet " + (i+1));
			createExcelDemo.writeContent(sheet);
		}
		
		createExcelDemo.generateExcel("syncExcelFile");
		
		long endTime = System.nanoTime();
		System.out.println("Time taken without Multithreaded way = " + ((endTime - startTime)/1000000)+" ms");
        
		startTime = System.nanoTime();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.submit(new Runnable() {
			
			CreateExcelDemo createExcelDemo = new CreateExcelDemo();
			int i=0;
			
			@Override
			public void run() {
				HSSFSheet sheet = createExcelDemo.createSheet("sheet " + (i+1));
				createExcelDemo.writeContent(sheet);
			}
		});
		
		executorService.shutdown();
		createExcelDemo.generateExcel("asyncExcelFile");
	
		endTime = System.nanoTime();
		System.out.println("Time taken with Multithreaded way = " + ((endTime - startTime)/1000000)+" ms");
		
		
		
		
		
    }
}

