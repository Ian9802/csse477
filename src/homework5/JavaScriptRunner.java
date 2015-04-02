package homework5;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptRunner {
	ScriptEngineManager mgr;
	ScriptEngine engine;
	
	public JavaScriptRunner(){
		this.mgr = new ScriptEngineManager();
		this.engine = mgr.getEngineByName("JavaScript");
	};
	
	public Object runJavascript(String code){
		try {
			return engine.eval(code);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return code;
		}
	}
	
}
