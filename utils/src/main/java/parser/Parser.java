package parser;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Parser {

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);

    public ArrayList<ArrayList<String>> parse(String pathToFile) throws IOException {
        //String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workbook = null;
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        inputStream = new FileInputStream(pathToFile);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            for (Cell cell : row) {
                Enum cellType = cell.getCellTypeEnum();
                ArrayList<String> arrayList = new ArrayList<>();
                switch (cellType.toString()) {
                    case "STRING":
                        arrayList.add(cell.getStringCellValue());
                        //result += cell.getStringCellValue() + " = ";
                        break;
                    case "NUMERIC":
                        arrayList.add(String.valueOf(cell.getNumericCellValue()));
                        //result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        //result += "|";
                        break;
                }
                list.add(arrayList);
            }
            //result += "\n";

        }

        LOG.debug("Parse success");

        return list;

    }
}
