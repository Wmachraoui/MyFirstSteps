package test.java.utils.Logs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    //Initialize Log4j instance
    private static final Logger LOG=  LogManager.getLogger(Log.class);

    //Info Level Logs
    public static void info (String message) {
        LOG.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        LOG.warn(message);
    }
        //Error Level Logs
        public static void error (String message) {
            LOG.error(message);
        }

        //Fatal Level Logs
        public static void fatal (String message) {
            LOG.fatal(message);
        }

        //Debug Level Logs
        public static void debug (String message) {
            LOG.debug(message);
        }
    }