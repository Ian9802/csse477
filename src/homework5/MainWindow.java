package homework5;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 5675542081671881032L;
	
	private JList pluginList;
	private ListModel plugins;
	private JPanel executionPanel;
	private JLabel statusLine;
	
	MainWindow() {
		super("Homework 5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plugins = new DefaultListModel<String>();
		((DefaultListModel<String>)plugins).addElement("Plugins");
		pluginList = new JList(plugins);
		pluginList.setPrototypeCellValue("MMMMMMMMMMMMMMMM");
		
		executionPanel = new JPanel();
		statusLine = new JLabel("No Messages.");
		
		executionPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.setSize(841,594);
		this.getContentPane().add(new JScrollPane(pluginList), BorderLayout.WEST);
		this.getContentPane().add(executionPanel, BorderLayout.CENTER);
		this.getContentPane().add(statusLine, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame win = new MainWindow();
				win.setVisible(true);
			}
		});
	}
}
