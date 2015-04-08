package org.arleth.sample.guice;

import com.google.inject.AbstractModule;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.StringReader;
import java.util.Map;

/**
 * Created by arlethp1 on 4/8/15.
 */
public class JSONModule extends AbstractModule {
    Map<String,Object> jsonMap;
    public JSONModule(String json) throws ScriptException {
        super();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsengine = manager.getEngineByName("js");
        jsengine.getBindings(ScriptContext.GLOBAL_SCOPE).put("json", json);
        this.jsonMap = (Map<String,Object>) jsengine.eval("JSON.parse(json)");
    }

    @Override
    protected void configure() {
        for(Map.Entry<String,Object> next : jsonMap.entrySet()) {
            try {
                Class interfaceClass = Class.forName(next.getKey());
                Class implClass = Class.forName(next.getValue().toString());
                bind(interfaceClass).to(implClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
