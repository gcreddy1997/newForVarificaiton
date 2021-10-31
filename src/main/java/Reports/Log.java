package Reports;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	
	public static int  randomNumber = 0; // some code to generate the random Number
	public static Logger log = Logger.getLogger(Reports.class.getName());
	
	public static void startTest( String TestCaseName) {
	//	DOMConfigurator.configure("Log4j.xml");
		log.info(" *****************            "  +TestCaseName + "         ***********************" );
		log.info("-----------------------------------------------------------------------------------");
	}
	
//	Log.info("Browser invoked suscessully")
	public static void info( String details) {
		log.info(details);
	}
	
	public static void pass( String details) {
		log.info(details);
	}
	
	public static void fail( String details) {
		log.info(details);
	}
	
	public static void warn( String details) {
		log.info(details);
	}
	
	public static void fatal( String details) {
		log.info(details);
	}
	
	public static void endTest() {
		log.info("################################################################");
		
	}
   
}
