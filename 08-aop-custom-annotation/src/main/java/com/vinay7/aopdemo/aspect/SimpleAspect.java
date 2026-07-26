package com.vinay7.aopdemo.aspect;


import com.vinay7.aopdemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    @Around("@annotation(trackExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint,
                                         TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation= trackExecutionTime.operation();

            if(operation.isBlank()){
                operation=joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT : " +
                        "Time Taken by " +
                        operation  + ": " + duration);
            }
            else {
                System.out.println(
                        "Time Taken by " + operation  + ": " + duration);
            }
        }
    }
}
