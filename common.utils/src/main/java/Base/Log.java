package Base;

import java.util.logging.Logger;

public class Log {

    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){

        Log.info("-------Scenario Started-------------------------------- "+sTestCaseName);
        Log.info("--------------------------------------------------------------");

    }

    public static void endTestCase(String sTestCaseName){

        Log.info("-------Scenario Ended-------------------------------- "+sTestCaseName);
        Log.info("--------------------------------------------------------------");

    }

    public static void info(String message) {

        Log.info(message);

    }

    public static void error(String message) {

       // Log.error(message);

    }


}
