package org.arleth.sample.guice;

import com.google.inject.AbstractModule;

public class HelloWorldModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Hello.class).to(HelloWorld.class);
		bind(HelloWorldService.class).to(HelloWorldServiceImpl.class);
	}

}
