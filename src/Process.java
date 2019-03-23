

import java.util.LinkedList;

public class Process {
	private int pid, timeslice;
	private String name, state;
	private Process next, prev;
	LinkedList<String> files;
	
	public Process(int pid, String name) {
		this.pid = pid;
		this.name = name;
		state = "ready";
		timeslice = 1;
		next = null;
		prev = null;
		files = new LinkedList<String>();
	}
	
	public Process getNext() {
		return next;
	}

	public void setNext(Process next) {
		this.next = next;
	}

	public Process getPrev() {
		return prev;
	}

	public void setPrev(Process prev) {
		this.prev = prev;
	}

	public void openFile(String file) {
		files.add(file);
	}
	
	public void closeFile(String file) {
		if (files.contains(file))
			files.remove(files.indexOf(file));
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTimeslice() {
		return timeslice;
	}

	public void setTimeslice(int timeslice) {
		this.timeslice = timeslice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Process " + pid+ "\t"+name+"\t"+state;
	}
}
