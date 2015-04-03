
function getName() {
	return "Timer Plugin";
}

var panel = new Packages.javax.swing.JPanel();
var label = new Packages.javax.swing.JLabel();
panel.add(label, java.awt.BorderLayout.CENTER);

function run() {
	var time = 10000;
	while(1) {
		java.lang.Thread.sleep(100);
		time = time - 100;
		if(time < 0) {
			host.postStatus("Timer expired!");
			time = 10000;
		}
		label.setText("Time until next event: " + time.toString());
	}
	
}

function getInterface() {
	host.postStatus("Hello, I'm a timer plugin.");
	return panel;
}