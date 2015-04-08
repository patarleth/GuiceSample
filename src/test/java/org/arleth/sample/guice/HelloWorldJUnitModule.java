package org.arleth.sample.guice;

import com.google.inject.AbstractModule;

public class HelloWorldJUnitModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Hello.class).to(HelloWorldForJUnit.class);
		bind(HelloWorldService.class).to(HelloWorldServiceImpl.class);
	}

}
