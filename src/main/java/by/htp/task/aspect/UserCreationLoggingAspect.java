package by.htp.task.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCreationLoggingAspect {

    @After("execution(public void by.htp.task.service.impl.UserServiceImpl.createUser(by.htp.task.entity.User)))")
    public void afterCreateUserAdvice() {

        System.out.println("\n==>>> Create user");
    }
}
