package exe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;

import java.io.IOException;

public class Main {
    private static final Logger LOG  = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            System.out.println(parser.parse("file.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("asdf");
    }
}
