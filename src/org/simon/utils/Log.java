/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.simon.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author XyRoN
 */
public class Log {
    
    public static boolean SILENT = false;
    
    public static final String LOG_EXTENSION = ".log";
    public static final SimpleDateFormat LOG_TIMESTAMP_FORM = new SimpleDateFormat ("HH:mm:ss");
    public static final SimpleDateFormat LOG_DATE_FORM = new SimpleDateFormat ("dd_MM_");
    
    public static final String LOG_PREFIX = "LOG : ";
    public static final String ERR_PREFIX = "ERR : ";
    
    public static final String LOG_FILE = getLogTimestamp() + LOG_EXTENSION;
    
    public static void log (String... lines) {
        for (String line : lines) {
            try {
                String log_line = LOG_PREFIX + getTimestamp() + "  ----  " + line + "\n";
                Writer log = new BufferedWriter (new FileWriter (LOG_FILE, true));
                log.append(log_line);
                if (!SILENT)
                    System.out.print(log_line);
                log.close();
            } catch (IOException ex) {
                String log_line = ERR_PREFIX + getTimestamp() + "  ----  " + "Can't write to log file!" + "\n";
                System.err.println(log_line);
            }
        }
    }
    
    public static void err (String... lines) {
        for (String line : lines) {
            try {
                String log_line = ERR_PREFIX + getTimestamp() + "  ----  " + line + "\n";
                Writer log = new BufferedWriter (new FileWriter (LOG_FILE, true));
                log.append(log_line);
                if (!SILENT)
                    System.err.print(log_line);
                log.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void err (Throwable ex) {
        int stackTraceCount = 2;
        int causeStackTraceCount = 0;
        
        int callersLineNumber = Thread.currentThread().getStackTrace()[stackTraceCount].getLineNumber();
        String callersClassName = Thread.currentThread().getStackTrace()[stackTraceCount].getClassName();
        String callersMethodName = Thread.currentThread().getStackTrace()[stackTraceCount].getMethodName();
        String exceptionClassName = ex.getClass().getSimpleName();
        
        err("Exception "+exceptionClassName+" caught at "+callersClassName+" @ "+callersMethodName+" ln:"+callersLineNumber);
        err("Exception message: "+ex.getMessage());
        
        if (ex.getCause()!=null) {
            int causeLineNumber = ex.getCause().getStackTrace()[causeStackTraceCount].getLineNumber();
            String causeClassName = ex.getCause().getStackTrace()[causeStackTraceCount].getClassName();
            String causeMethodName = ex.getCause().getStackTrace()[causeStackTraceCount].getMethodName();
            String causeName = ex.getCause().getClass().getSimpleName();
            
            err("Cause: "+causeName+" - "+causeClassName+" @ "+causeMethodName+" ln:"+causeLineNumber);
        }
        
        ex.printStackTrace();
    }
    
    public static final String getTimestamp () {
        return LOG_TIMESTAMP_FORM.format(new Date());
    }
    
    public static final String getLogTimestamp () {
        return LOG_DATE_FORM.format(new Date());
    }
    
}
