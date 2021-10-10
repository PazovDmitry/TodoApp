package TODOApp.aspect;

import TODOApp.annotation.Loggable;
import TODOApp.annotation.Loggable2;
import TODOApp.service.context.UserContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private final UserContext userContext;

    public LoggingAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @Before("@annotation(loggable2)")
    public void loggable2(JoinPoint joinPoint, Loggable2 loggable2) {
        String email = userContext.getEmail();


        System.out.printf(
                "[email = %s] request a method: %s",
                email, joinPoint.getSignature().getName()
        );
    }


    @After("@annotation(loggable)")
    public void loggable(JoinPoint joinPoint, Loggable loggable) {
        String email = userContext.getEmail();

        System.out.printf(
                "[email = %s] executed the method: %s",
                email, joinPoint.getSignature().getName()
        );
    }
}
