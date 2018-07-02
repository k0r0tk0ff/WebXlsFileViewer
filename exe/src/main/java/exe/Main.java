package exe;

import launcher.TomcatLauncher;
import org.apache.catalina.LifecycleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.net.MalformedURLException;

public class Main {
    private static final Logger LOG  = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        TomcatLauncher tomcat = new TomcatLauncher();
        try {
            tomcat.launch();
        }  catch (ServletException | LifecycleException | MalformedURLException e1) {
            LOG.error("TomcatLauncher error", e1);
        }
    }
}
