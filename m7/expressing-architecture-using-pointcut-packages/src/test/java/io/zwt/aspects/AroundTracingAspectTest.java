package io.zwt.aspects;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.zwt.repository.MyRepository;
import io.zwt.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/system-configuration.xml")
public class AroundTracingAspectTest {

	@Autowired
	TracingAspect tracingAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;

	@Before
	public void setUp() {
		tracingAspect.resetCalled();
	}

	@Test
	public void tracingIsCalledForRepositories() {
		assertFalse(tracingAspect.isCalled());
		myRepository.doIt();
		assertTrue(tracingAspect.isCalled());
	}

	@Test
	public void tracingIsCalledForServices() {
		assertFalse(tracingAspect.isCalled());
		myService.doIt();
		assertTrue(tracingAspect.isCalled());
	}

}
