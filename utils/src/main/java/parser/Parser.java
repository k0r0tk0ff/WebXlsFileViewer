package parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Parser {
    public String parse(String pathToFile) throws IOException {
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workbook = null;

        inputStream = new FileInputStream(pathToFile);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            for (Cell cell : row) {
                Enum cellType = cell.getCellTypeEnum();
                switch (cellType.toString()) {
                    case "STRING":
                        result += cell.getStringCellValue() + " = ";
                        break;
                    case "NUMERIC":
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";

        }
        return result;
    }
}
