package homework5;

import java.io.File;
import java.io.FileNotFoundException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JavaScriptRunner {
	ScriptEngineManager mgr;
	ScriptEngine engine;
	Invocable inv;
	
	public JavaScriptRunner(){
		this.mgr = new ScriptEngineManager();
		this.engine = mgr.getEngineByName("JavaScript");
		this.inv = (Invocable) engine;
	};
	
	public void prepareEngine(String name, Object object){
		engine.put(name, object);
	}
	
	public Object runJavascript(File file){
		try {
			return engine.eval(new java.io.FileReader(file));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return file;
	};
	
	public Object runJavascriptFunction(File file, String function){
		try {
			return inv.invokeFunction(function);
		} catch (NoSuchMethodException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	public Object runJavascriptFunctionWithParameters(File file, String function, String parameters){
		try {
			return inv.invokeFunction(function, parameters);
		} catch (NoSuchMethodException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
}
