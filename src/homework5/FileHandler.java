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
		Object response = runner.runJavascript(this.files[selected]);
		if (response.equals(this.files[selected])){
			return null;
		}else{
			return response;
		}
	};
	
	public void printListOfFiles(){
		this.importer.printFiles(this.files);
	}
}
