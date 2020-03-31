package lab2;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	private String path;
	public Reader(String path) {
		this.path = path;
	}
    public List<List> readExcel() throws IndexOutOfBoundsException, BiffException, IOException {
    	FileInputStream is = new FileInputStream(new File(this.path));
        Sheet s = Workbook.getWorkbook(is).getSheet(0);
        List<List> data=new ArrayList<List>();
        for (int i = 0; i < s.getRows(); i++) {
        	List<String> row=new ArrayList<String>();
            for (int j = 0; j < s.getColumns(); j++) {
                String col = s.getCell(j, i).getContents();
                if (col.isEmpty()) continue;
                row.add(col);
            }
            if (row.isEmpty()) continue;
            data.add(i, row);
        }
        is.close();
        return data;
    }
//    public static void main(String[] args) throws IndexOutOfBoundsException, BiffException, IOException {
//    	Reader l = new Reader("C:\\Users\\cxdzb\\Desktop\\eclipse-workspace\\lab2\\resource\\Selenium Lab2020.xls");
//    	List<List> data = l.readExcel();
//    	for (List i: data)
//    		for (Object j: i)
//    			System.out.println(j);
//    }
}
