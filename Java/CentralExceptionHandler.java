package com.payu.useridentity.client.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class is used to handle the exception thrown from the application
 * Created by medha.jain on 07-12-2016.
 */
@Service
public class CentralExceptionHandler {

    private static final Logger errorLogger = LogManager.getLogger(CentralExceptionHandler.class);

    public void handleException(Exception ex )  {
        StackTraceElement[] traceElement = ex.getStackTrace();

        String className = traceElement[0].getClassName();
        String methodName = traceElement[0].getMethodName();
        Integer lineNumber = traceElement[0].getLineNumber();

        String exceptionLocation = "ClassName : " + className + ", MethodName : " + methodName + ", Line Number : "
                + (String.valueOf(lineNumber)) + "Error: " + ex.getMessage();

        errorLogger.error(exceptionLocation);
        errorLogger.error(className,ex);
    }

    public  void handleInfomration(String info)
    {
        errorLogger.info(info);
    }
}
