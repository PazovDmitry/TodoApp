package Todo.aspect;

import Todo.annotation.Loggable;
import Todo.service.context.UserContext;
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

    @Before("@annotation(loggable)")
    public void beforeLoggable(JoinPoint joinPoint, Loggable loggable) {
        String email = userContext.getEmail();

        System.out.printf(
                "[email = %s] request a method: %s",
                email, joinPoint.getSignature().getName()
        );
    }


    @After("@annotation(loggable)")
    public void afterLoggable(JoinPoint joinPoint, Loggable loggable) {
        String email = userContext.getEmail();

        System.out.printf(
                "[email = %s] executed the method: %s",
                email, joinPoint.getSignature().getName()
        );
    }
}
