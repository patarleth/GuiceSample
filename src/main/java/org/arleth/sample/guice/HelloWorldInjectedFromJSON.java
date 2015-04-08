package org.arleth.sample.guice;

/**
 * Created by arlethp1 on 4/8/15.
 */
public class HelloWorldInjectedFromJSON implements Hello {

    public String world() {
            return "yo, how's it going from HelloWorldInjectedFromJSON!";
        }
}
