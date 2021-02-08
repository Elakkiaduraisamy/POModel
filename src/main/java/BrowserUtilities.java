import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.LogManager.*;

public class BrowserUtilities {


 private static Logger logger;

//    static {
//        logger = LogManager.getLogger(String.valueOf(BrowserUtilities.class));
//    }

    public static void main(String[] args) {
        System.out.println("Hello");
        logger.info("message");
//        logger.error("this is erorr");
    }
}