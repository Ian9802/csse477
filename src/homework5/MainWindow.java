package homework5;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow extends JFrame implements ListSelectionListener {
	private static final long serialVersionUID = 5675542081671881032L;
	
	private JList<String> pluginList;
	private PluginListModel pluginNames;
	private JPanel executionPanel;
	private JLabel statusLine;
	private List<Plugin> plugins;
	
	MainWindow() {
		super("Homework 5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pluginNames = new PluginListModel();
		pluginList = new JList<String>(pluginNames);
		pluginList.setPrototypeCellValue("MMMMMMMMMMMMMMMM");
		
		executionPanel = new JPanel();
		statusLine = new JLabel("No Messages.");
		
		executionPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.setSize(841,594);
		this.getContentPane().add(new JScrollPane(pluginList), BorderLayout.WEST);
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
		this.getContentPane().add(statusLine, BorderLayout.SOUTH);
	}
	
	public static void launchWindow(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame win = new MainWindow();
				win.setVisible(true);
			}
		});
	}
	
	public void addPluginToList(Plugin plugin){
		plugins.add(plugin);
	}
	
	public void removePluginFromList(Plugin plugin){
		plugins.remove(plugin);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Plugin v = pluginNames.get(e.getFirstIndex());
		this.getContentPane().remove(executionPanel);
		executionPanel = v.getInterface();
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
	}
}
