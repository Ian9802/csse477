To run the software, simply run Homework5.jar
If you're running from the command line, simply run:
java -jar Homework5.jar

Plugins are loaded from the plugin directory. Some example plugins are included 
if you wish to create your own. 

Each plugin must include three functions
	* `getName()` which should return the name of the plugin as a string.
	* `getInterface()` which should return a JPanel of the plugin's interface.
	* `run()` which is run in a separate thread allowing concurrent, non-blocking 
	  processing.
Each plugin may send status updates to the host to be displayed in the status 
bar by calling the `host.postStatus(String status)` function. 