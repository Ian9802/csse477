package homework5;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MainWindow win = new MainWindow();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				win.setVisible(true);
			}
		});
		FileHandler handler = new FileHandler();
		handler.getFiles();
		if (handler.runners != null) {
			for (Plugin plugin : handler.runners) {
				win.addPluginToList(plugin);
			}
		}
	}

}
