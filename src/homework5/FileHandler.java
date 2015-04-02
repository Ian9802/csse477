package homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {
	FileImporter importer;
	JavaScriptRunner runner;
	File [] files;
	
	public FileHandler(){
		this.importer = new FileImporter();
		this.runner = new JavaScriptRunner();
	};
	
	public void getFiles(){
		this.files = this.importer.getPluginsFromFolder();
	};
	
	public Object runFile(int selected){
		String stringifiedJS = makeStringFromJS(this.files[selected]);
		if(stringifiedJS.isEmpty()){
			return null;
		}else{
			Object response = runner.runJavascript(stringifiedJS);
			if (response.equals(stringifiedJS)){
				return null;
			}else{
				return response;
			}
		}
	};
	
	private String makeStringFromJS(File selectedFile){
		try {
			return new Scanner(selectedFile).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public void printListOfFiles(){
		this.importer.printFiles(this.files);
	}
}
