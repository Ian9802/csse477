package homework5;

import java.io.File;
import java.io.FileNotFoundException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JPanel;


public class JavaScriptRunner implements Plugin{
	public ScriptEngineManager mgr;
	public ScriptEngine engine;
	public Invocable inv;
	
	public JavaScriptRunner(){
		this.mgr = new ScriptEngineManager();
		this.engine = mgr.getEngineByName("JavaScript");
	};
	
	public void prepareEngine(String name, Object object){
		engine.put(name, object);
	}
	
	public void dedicateEngine(File file){
		try {
			this.engine.eval(new java.io.FileReader(file));
			this.inv = (Invocable) engine;
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
	};
	
	public Object runFunction(String function){
		try {
			return inv.invokeFunction(function);
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
		return function;
	}
	
	public Object runFunctionWithParameters(String function, String parameters){
		try {
			return inv.invokeFunction(function, parameters);
		} catch (NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
		return function;
	}

	@Override
	public void run() {
		this.runFunction("run");
	}

	@Override
	public JPanel getInterface() {
		return (JPanel) this.runFunction("getInterface");
	}

	@Override
	public String getName() {
		return (String) this.runFunction("getName");
	}

	@Override
	public void setPluginHost(PluginHost host) {
		this.prepareEngine("host", host);
	}
	
}
