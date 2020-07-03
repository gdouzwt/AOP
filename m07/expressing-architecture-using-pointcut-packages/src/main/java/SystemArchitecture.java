import org.aspectj.lang.annotation.Pointcut;


public class SystemArchitecture {

    @Pointcut("execution(* io.zwt..repository.*Repository.*(..))")
    public void Repository() {
    }

    @Pointcut("execution(* io.zwt..service.*.*(..))")
    public void Service() {
    }

}
