package org.arleth.sample.guice;

import com.google.inject.Injector;
import com.google.inject.Guice;

import javax.script.ScriptException;

public class Main {

    private static void compiledModuleInjection() {
        Injector injector = Guice.createInjector(new HelloWorldModule());
        HelloWorldService service = injector.getInstance(HelloWorldService.class);
        System.out.println( service.hello() );
    }

    private static void jsonModuleInjection() throws ScriptException {
        String bindJson = "{\n" +
                "    \"org.arleth.sample.guice.Hello\" : \"org.arleth.sample.guice.HelloWorldInjectedFromJSON\",\n" +
                "    \"org.arleth.sample.guice.HelloWorldService\" : \"org.arleth.sample.guice.HelloWorldServiceImpl\"\n" +
                "}";
        Injector injector = Guice.createInjector(new JSONModule(bindJson));
        HelloWorldService jsonService = injector.getInstance(HelloWorldService.class);
        System.out.println( jsonService.hello() );
    }

	public static void main(String[] args) throws ScriptException {
        System.out.println( "HelloWorldModule");
        compiledModuleInjection();
        System.out.println("\nJSONModule");
        jsonModuleInjection();
	}
}
