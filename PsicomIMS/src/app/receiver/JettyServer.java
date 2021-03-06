package app.receiver;


import javax.annotation.PostConstruct;

import org.mortbay.jetty.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JettyServer
{
    private Server httpServer;
    
    
    
    private int webServerPort;

    @Autowired
    private URLHandler handler;
    
    
    @PostConstruct
    public void start()
    {
    	webServerPort = 8080;
        if (httpServer==null)
        {
            Thread serverRunner = new Thread(new Runnable()
            {
               public void run()
               {
                   System.out.println("Opening Jetty WebServer port: "+webServerPort);
                   httpServer = new Server(webServerPort);
                   httpServer.setHandler(handler);
                   try
                   {
                       httpServer.start();
                       System.out.println("Opening Jetty WebServer done");
                   }
                   catch (Exception e)
                   {
                       System.out.println("Error starting Jetty:"+e.getClass().getName());
                   }
               }
            });
            serverRunner.start();
        }        
    }
    
    public void stop()
    {
        // stop web server
        if (httpServer!=null)
        {
            try
            {
                httpServer.stop();
                httpServer.destroy();
            }
            catch(Exception e)
            {
                System.out.println("Error stopping Jetty:"+e.getClass().getName());
            }
            finally
            {
                httpServer = null;
            }
        }
    }

    
    


}
