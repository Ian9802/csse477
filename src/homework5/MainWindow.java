package homework5;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow extends JFrame implements ListSelectionListener, PluginHost {
	private static final long serialVersionUID = 5675542081671881032L;
	
	private JList<String> pluginList;
	private PluginListModel plugins;
	private JPanel executionPanel;
	private JLabel statusLine;
	
	MainWindow() {
		super("Homework 5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plugins = new PluginListModel();
		pluginList = new JList<String>(plugins);
		pluginList.setPrototypeCellValue("MMMMMMMMMMMMMMMM");
		
		executionPanel = new JPanel();
		statusLine = new JLabel("No Messages.");
		
		executionPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.setSize(841,594);
		this.getContentPane().add(new JScrollPane(pluginList), BorderLayout.WEST);
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
		this.getContentPane().add(statusLine, BorderLayout.SOUTH);
		
	}
	
	public void addPluginToList(Plugin plugin){
		plugins.add(plugin);
		this.postStatus("Added plugin: "+ plugin.getName());
	}
	
	public void removePluginFromList(Plugin plugin){
		plugins.remove(plugin);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Plugin v = plugins.get(e.getFirstIndex());
		this.getContentPane().remove(executionPanel);
		executionPanel = v.getInterface();
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
	}

	@Override
	public void postStatus(String status) {
		statusLine.setText(status);
	}
}
