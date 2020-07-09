import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.User;
import org.springframework.core.SpringVersion;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class NormalTest {

    public static void main(String[] args) {
//        System.out.println(SpringVersion.getVersion());
        try {
            excelTest();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Excel相关类
     * @throws Exception
     */
    public static void excelTest() throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(new File("D:\\logMsg.xlsx"));
        //解析excel
        XSSFWorkbook hb = new XSSFWorkbook(fis);
        //获取整个excel
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        XSSFSheet sheet = hb.getSheet("Sheet1");
        //获取第一行
        int firstrow = sheet.getFirstRowNum();
        //获取最后一行
        int lastrow = sheet.getLastRowNum();
        //循环行数依次获取列数
        for (int i = firstrow; i < lastrow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstcell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastcell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstcell; j < lastcell; j++) {
                    if (j == 2){
                        continue;
                    }
                    //获取第j列
                    Cell cell = row.getCell(j);

                    if (cell != null) {
                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
                System.out.println();
            }
        }
        fis.close();
    }
}