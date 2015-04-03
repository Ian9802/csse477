package homework5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
	FileImporter importer;
	ArrayList<JavaScriptRunner> runners;
	ArrayList<File> files;
	
	public FileHandler(){
		this.importer = new FileImporter();
	};
	
	public void getFiles(){
		this.files = new ArrayList<File>(Arrays.asList(this.importer.getPluginsFromFolder()));
		for (File file : files){
			JavaScriptRunner runner = new JavaScriptRunner();
			runner.dedicateEngine(file);
			this.runners.add(runner);
		};
	};
	
	public void printListOfFiles(){
		this.importer.printFiles(this.files);
	}
}
