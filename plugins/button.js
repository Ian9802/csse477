
function getName() {
	return "Button Plugin";
}

function run() {}


var panel = new Packages.javax.swing.JPanel();
var button = new Packages.javax.swing.JButton();
var buttonListener = {
	actionPerformed : function(e) {
		host.postStatus("Button Pressed!");
	}
};
button.addActionListener(new java.awt.event.ActionListener(buttonListener));
button.setText("Press Me!");
panel.add(button, java.awt.BorderLayout.CENTER);

function getInterface() {
	host.postStatus("Hello, I'm a button plugin");
	return panel;
}