package homework5;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow extends JFrame implements ListSelectionListener, PluginHost {
	private static final long serialVersionUID = 5675542081671881032L;
	
	private PluginListModel plugins = new PluginListModel();
	private JList<String> pluginList = new JList<String>(plugins);;
	private JLabel statusLine = new JLabel("No messages.");
	private JPanel executionPanel = new JPanel(new CardLayout());
	
	MainWindow() {
		super("Homework 5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pluginList.setPrototypeCellValue("MMMMMMMMMMMMMMMM");
		pluginList.addListSelectionListener(this);
		pluginList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		executionPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		executionPanel.add(new JPanel(), "__default");
		
		
		this.setSize(841,594);
		this.getContentPane().add(new JScrollPane(pluginList), BorderLayout.WEST);
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
		this.getContentPane().add(statusLine, BorderLayout.SOUTH);
	}
	
	public void addPluginToList(Plugin plugin){
		plugins.add(plugin);
		this.postStatus("Added plugin: "+ plugin.getName());
		executionPanel.add(plugin.getInterface(), plugin.getName());
	}
	
	public void removePluginFromList(Plugin plugin){
		plugins.remove(plugin);
		executionPanel.remove(plugin.getInterface());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) {
			return;
		}
		int i = pluginList.getSelectedIndex();
		CardLayout cl = (CardLayout)(executionPanel.getLayout());
		if(i < 0) {
			cl.show(executionPanel, "__default");
		} else {
			cl.show(executionPanel, plugins.get(i).getName());
		}
	}

	@Override
	public void postStatus(String status) {
		statusLine.setText(status);
	}
}
