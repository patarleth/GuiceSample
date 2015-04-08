package org.arleth.sample.guice;

import com.google.inject.Inject;

public class HelloWorldServiceImpl implements HelloWorldService {
	Hello hello;

	@Inject
	public HelloWorldServiceImpl(Hello hello) {
		this.hello = hello;
	}

	public String hello() {
		return hello.world();
	}
}
