package homework5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class PluginListModel extends AbstractListModel<String> {
	
	private static final long serialVersionUID = 4461850099085972137L;
	private List<Plugin> list;
	
	public PluginListModel(){
		super();
		list = new ArrayList<Plugin>();
	}

	@Override
	public String getElementAt(int i) {
		return list.get(i).getName();
	}

	@Override
	public int getSize() {
		return list.size();
	}
	
	public void add(Plugin e) {
		list.add(e);
		this.fireIntervalAdded(this, list.size()-1, list.size()-1);
	}
	
	public void remove(Plugin e) {
		list.remove(e);
		this.fireIntervalRemoved(this, list.size(), list.size());
	}
	
	public Plugin get(int i) {
		return list.get(i);
	}

}
