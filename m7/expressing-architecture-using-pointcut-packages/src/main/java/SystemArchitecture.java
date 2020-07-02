import org.aspectj.lang.annotation.Pointcut;


public class SystemArchitecture {

	@Pointcut("execution(* com.zwt..repository.*Repository.*(..))")
	public void Repository() {
	}

	@Pointcut("execution(* com.zwt..service.*.*(..))")
	public void Service() {
	}

}
