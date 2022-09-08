package com.example.daeun_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class SampleAspect {

	/**
	 *  @CustomStopWatch 가 붙은 애들은 실행하기전에 스탑워치를 키고
	 *  실행끝나고나서 끄고, 몇초 걸렸는지 출력하고 싶다.
 	 */
	private final StopWatch stopWatch = new StopWatch();

	@Around(value = "@annotation(CustomStopWatch)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// Before
		stopWatch.start();

		// 기존 메소드 실행
		Object o = joinPoint.proceed();

		// After
		stopWatch.stop();
		System.out.println(joinPoint.getSignature().toShortString() +
			" 실행이 " + stopWatch.getLastTaskTimeMillis() + "ms 걸렸습니다.");

		return o;
	}

	@Before(value = "@annotation(CustomStopWatch)")
	public void before() {
		stopWatch.start();
	}

	@After(value = "@annotation(CustomStopWatch)")
	public void after(JoinPoint joinPoint) {
		stopWatch.stop();
		System.out.println(joinPoint.getSignature().toShortString() +
			" 실행이 " + stopWatch.getLastTaskTimeMillis() + "ms 걸렸습니다.");
	}

}
