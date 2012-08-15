package org.arleth.sample.guice;

import com.google.inject.Injector;
import com.google.inject.Guice;

public class Main {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new HelloWorldModule());
		HelloWorldService service = injector.getInstance(HelloWorldService.class);
		System.out.println( service.hello() );
	}
}
