import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class ServerClass implements Handler {

    static Logger log = Logger.getLogger(ServerClass.class.getName());


    public void startServer() throws Exception {
        int port = 8890;

        Server server = new Server(port);
        server.setHandler(this);

        ResourceHandler resource_handler = new ResourceHandler();

        // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
        // In this example it is the current directory but it can be configured to anything that the jvm has access to.
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
        resource_handler.setResourceBase("src/main/resources/");

        // Add the ResourceHandler to the server.
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { this, resource_handler, new DefaultHandler()});
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if(request.getRequestURI().equals("/murmur.hash")) {
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
            int hash = MurmurHash3_x86_32.hash(Long.valueOf(request.getParameter("key")), Integer.valueOf(request.getParameter("seed")));
            httpServletResponse.setStatus(200);
            PrintWriter writer = httpServletResponse.getWriter();
            httpServletResponse.setContentType("application/json");
            writer.print("["+request.getParameter("key")+","+request.getParameter("seed")+","+hash+"]");
            request.setHandled(true);
        }
    }

    public void setServer(Server server) {

    }

    public Server getServer() {
        return null;
    }

    public void destroy() {

    }

    public void start() throws Exception {

    }

    public void stop() throws Exception {

    }

    public boolean isRunning() {
        return false;
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isStarting() {
        return false;
    }

    public boolean isStopping() {
        return false;
    }

    public boolean isStopped() {
        return false;
    }

    public boolean isFailed() {
        return false;
    }

    public void addLifeCycleListener(Listener listener) {

    }

    public void removeLifeCycleListener(Listener listener) {

    }
}
