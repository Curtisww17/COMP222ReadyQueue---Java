

public class ReadyQueue {

	public Process head, tail;
	private int size;
	
	public ReadyQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public ReadyQueue(Process head) {
		this.head = head;
		this.tail = head;
		size = 1;
	}
	
	public int getNProcesses() {
		return size;
	}
	
	public void addProcess(Process process) {
		if (tail == null) {
			head = process;
		} else {
			tail.setNext(process);
			process.setPrev(tail);
		}
		tail = process;
		size++;
	}
	
	public String remove(Process process) {
		process.getPrev().setNext(process.getNext());
		process.getNext().setPrev(process.getPrev());
		size--;
		return process.getState();
	}
	
	public void contextSwitch() {
		if (head == null)
			return;
		head.setPrev(tail);
		tail.setNext(head);
		head = head.getNext();
		tail = tail.getNext();
		tail.setNext(null);
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public String toString() {
		
		if (isEmpty())
			return "ReadyQueue is empty.";
		Process current = head;
		String out = "";
		while (current != null) {
			out += current.toString() + "\n";
			current = current.getNext();
		}
		return out;
	}
}
