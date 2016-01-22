
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringThing {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
        // load application context files
        System.out.println("Starting main");
        ClassPathXmlApplicationContext ctx 
          = new ClassPathXmlApplicationContext(new String []{"applicationContext.xml"});
 
	}

}
