package homework5;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileImporter {

	public FileImporter(){
	};
	
	public File[] getPluginsFromFolder(){
		File dir = new File("../plugins/");
		File [] files = dir.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name){
				return name.endsWith(".js");
			}
		});
		return files;
	};
	
	public void printFiles(ArrayList<File> files){
		for(File file : files){
			System.out.println(file);
		}
	};
	
}
