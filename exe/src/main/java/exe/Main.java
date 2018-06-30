package exe;

import parser.Parser;

import java.io.IOException;

public class Main {
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
