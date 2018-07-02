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
import java.util.Iterator;

public class Parser {

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);

    public ArrayList<ArrayList<String>> parse(String pathToFile) throws IOException {

        InputStream inputStream;
        HSSFWorkbook workbook;
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        inputStream = new FileInputStream(pathToFile);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            ArrayList<String> arrayList = new ArrayList<>();
            for (Cell cell : row) {
                Enum cellType = cell.getCellTypeEnum();
                switch (cellType.toString()) {
                    case "STRING":
                        //arrayList.add(cell.getStringCellValue());
                        arrayList.add(cell.getRichStringCellValue().getString());
                        break;
                    case "NUMERIC":
                        arrayList.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    default:
                        break;
                }
            }
            list.add(arrayList);
        }
        LOG.debug("Parse success");
        return list;
    }
}
