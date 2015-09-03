package liquibase.ext.logging;

import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.logging.core.AbstractLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stupid class, to enable liquibase logging.
 * <p>
 * Liquibase finds this class by itself by doing a custom component scan (they though sl4fj wasn't generic enough).
 */

//TODO: remove forced debug methods to return without doing nothing, need to figure out how to make sl4j respect debug levels.
public class LiquibaseLogger extends AbstractLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseLogger.class);

    private String name = "";

    public void setName(String name) {
        this.name = name;
    }


    public void severe(String message) {
        LOGGER.error("{} {}", name, message);
    }


    public void severe(String message, Throwable e) {
        LOGGER.error("{} {}", name, message, e);
    }


    public void warning(String message) {
        LOGGER.warn("{} {}", name, message);
    }


    public void warning(String message, Throwable e) {
        LOGGER.warn("{} {}", name, message, e);
    }


    public void info(String message) {
        return;
    }


    public void info(String message, Throwable e) {
        return;
    }


    public void debug(String message) {
        return;
    }


    public void debug(String message, Throwable e) {
        return;
    }

    public void setLogLevel(String logLevel, String logFile) {

    }

    public void setChangeLog(DatabaseChangeLog databaseChangeLog) {
        super.setChangeLog(databaseChangeLog);
    }

    public void setChangeSet(ChangeSet changeSet) {
        super.setChangeSet(changeSet);
    }

    public int getPriority() {
        return Integer.MAX_VALUE;
    }
}