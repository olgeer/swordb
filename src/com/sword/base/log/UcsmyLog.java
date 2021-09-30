package com.sword.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Max on 2017/6/13.
 */
public class UcsmyLog {
    private Logger logger;
    private String className;
    private String trace;
    private static boolean log2usp;
    private boolean write2usp = true;

    private void init() {

    }

    public UcsmyLog(String className) {
        init();
        this.className = className;
        logger = LoggerFactory.getLogger(className);
    }

    public void setWrite2usp(boolean write2usp) {
        this.write2usp = write2usp;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public void info(String msg) {
        info(msg, true);
    }

    public void info(String msg, boolean writeUsp) {
        logger.info(msg);
        if (log2usp && write2usp) {
            try {
                //if(writeUsp)Log.LogText(this.className, msg, this.trace, false);
                //if (writeUsp) Log.LogText(this.trace, this.className, msg, this.trace);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void debug(String msg) {
        debug(msg, true, null);
    }

    public void debug(String msg, boolean writeUsp) {
        debug(msg, writeUsp, null);
    }

    public void debug(String msg, String traceid) {
        debug(msg, true, traceid);
    }

    public void debug(String msg, boolean writeUsp, String traceid) {
        logger.debug(msg);
        if (log2usp && write2usp) {
            try {
                //if(writeUsp)Log.LogText(this.className, msg, this.trace, false);
                if (writeUsp) {
                    if (traceid == null) {
                        //Log.LogText(this.trace, this.className, msg, this.trace);
                    } else {
                        //Log.LogText(traceid, this.className, msg, this.trace);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void warn(String msg) {
        logger.warn(msg);
        if (log2usp) {
            try {
                //EarlyWarn.AlarmLog(null, null, this.trace, EarlyWarnLevelEnum.警告.getValue(), this.className, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void error(String msg) {
        error(msg, null);
    }

    public void error(String msg, String traceid) {
        logger.error(msg);
        if (log2usp) {
            try {
                if (traceid == null) {
                    //EarlyWarn.AlarmLog(null, null, this.trace, EarlyWarnLevelEnum.紧急.getValue(), this.className, msg);
                } else {
                    //EarlyWarn.AlarmLog(null, null, traceid, EarlyWarnLevelEnum.紧急.getValue(), this.className, msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
