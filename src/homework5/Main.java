package homework5;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {

	public static void main(String[] args) {
		final MainWindow win = new MainWindow();
		FileHandler handler = new FileHandler();
		handler.getFiles();
		if (handler.runners != null) {
			for (Plugin plugin : handler.runners) {
				plugin.setPluginHost(win);
				win.addPluginToList(plugin);
				new Thread(plugin).start();
			}
		}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				win.setVisible(true);
			}
		});
		
		//Watch files for changes and update on new plugin additions.
		WatchService watcher = null;
		Path dir = null;
		try {
			watcher = FileSystems.getDefault().newWatchService();
			dir = FileSystems.getDefault().getPath("./plugins/");
			dir.register(watcher, ENTRY_CREATE);
		} catch (IOException e) {
			System.err.println("Error: unable to watch plugin directory");
			System.exit(0);
		}
		for (;;) {
		    WatchKey key;
		    try {
		        key = watcher.take();
		    } catch (InterruptedException x) {
		        continue;
		    }

		    for (WatchEvent<?> event: key.pollEvents()) {
		        WatchEvent.Kind<?> kind = event.kind();

		        if (kind == OVERFLOW) {
		            continue;
		        }

		        @SuppressWarnings("unchecked")
				WatchEvent<Path> ev = (WatchEvent<Path>)event;
		        Path filename = ev.context();

		        if(filename.toString().endsWith(".js")) {
		        	JavaScriptRunner runner = new JavaScriptRunner();
		        	runner.dedicateEngine(dir.resolve(filename).toFile());
					runner.setPluginHost(win);
					win.addPluginToList(runner);
					new Thread(runner).start();
		        }
		    }
		    boolean valid = key.reset();
		    if (!valid) {
		        break;
		    }
		}
	}

}
