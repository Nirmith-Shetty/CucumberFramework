package Utils;

import constants.Path;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public Map<String, String> getExcelData(int testCaseID, String sheetName) {

        Map<String, String> data = new HashMap<>();
        try {
            Workbook workbook = WorkbookFactory.create(new File(Path.EXCEL_PATH));
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(testCaseID);

            for (int i = 0; i < row.getLastCellNum(); i++) {
                data.put(sheet.getRow(sheet.getFirstRowNum()).getCell(i).getStringCellValue(), row.getCell(i).getStringCellValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


}
