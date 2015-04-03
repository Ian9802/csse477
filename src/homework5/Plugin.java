package homework5;

import javax.swing.JPanel;

public interface Plugin extends Runnable {

	JPanel getInterface();
	String getName();
	void setPluginHost(PluginHost host);
	
}
