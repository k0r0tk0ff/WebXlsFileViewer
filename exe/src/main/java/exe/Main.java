package exe;

import launcher.TomcatLauncher;
import org.apache.catalina.LifecycleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;


import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final Logger LOG  = LoggerFactory.getLogger(Main.class);

    public static ArrayList<ArrayList<String>> list;

    public static void main(String[] args) {
        Parser parser = new Parser();
        TomcatLauncher tomcat = new TomcatLauncher();
        String tomcatErrorMessage = "TomcatLauncher error";

        try {
            //System.out.println(parser.parse("file.xls"));
            list = parser.parse("file.xls");
            System.out.println(Arrays.asList(parser.parse("file.xls")));
            tomcat.launch();

        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Parser error!", e);
        } catch (ServletException e1) {
            LOG.error(tomcatErrorMessage, e1);
        } catch (LifecycleException e2) {
            LOG.error(tomcatErrorMessage, e2);
        }
    }
}
