package launcher;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class TomcatLauncher {

    public void launch() throws ServletException, LifecycleException {
        final int port = 8080;
        final String hostName = "localhost";

        String contextPath = "/" ;
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setHostname(hostName);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);

        tomcat.start();
        tomcat.getServer().await();
    }
}
