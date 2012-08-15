package org.arleth.sample.guice;

import com.google.inject.Injector;
import com.google.inject.Guice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloTest {
	private static HelloWorldService service = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Injector injector = Guice.createInjector(new HelloWorldJUnitModule());
		service = injector.getInstance(HelloWorldService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String val = service.hello();
		System.out.println("hello world service says - " + val);
		assertEquals("world", val);
	}

}
