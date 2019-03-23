

public class ProcessManager {

	static ReadyQueue processes;
	
	public static void main(String[] args) {
		
		//Create new ReadyQueue
		processes = new ReadyQueue(); //agetty, chronyd, crond, dbus-daemon, firewalld, irqbalance, lvmetad, polkitd, sshd, rsyslogd
		
		
		//Creates and adds the systemd process
		Process systemd = createProcess("systemd");
		processes.addProcess(systemd);
		
		//Goes through creating and adding each other process,
		//as the instructions state.
		Process agetty = createProcess("agetty");
		processes.addProcess(agetty);
		Process chronyd = createProcess("chronyd");
		processes.addProcess(chronyd);
		Process crond = createProcess("crond");
		processes.addProcess(crond);
		Process dbusdaemon = createProcess("dbus-daemon");
		processes.addProcess(dbusdaemon);
		Process firewalld = createProcess("firewalld");
		processes.addProcess(firewalld);
		Process irqbalance = createProcess("irqbalance");
		processes.addProcess(irqbalance);
		Process lvmetad = createProcess("lvmetad");
		processes.addProcess(lvmetad);
		Process polkitd = createProcess("polkitd");
		processes.addProcess(polkitd);
		Process sshd = createProcess("sshd");
		processes.addProcess(sshd);
		Process rsyslogd = createProcess("rsyslogd");
		processes.addProcess(rsyslogd);
		
		
		
		//Preforms the RoundRobin scheduling
		roundRobin();
		
		//Opens the two given files
		sshd.openFile("hello.c");
		sshd.openFile("hello.h");
		
		//Closes the hello.c file
		sshd.closeFile("hello.c");
		
		//Terminates the crond process
		terminateProcess(crond.getPid());
		
		//Prints out the processes
		System.out.println(processes);
		
		//Terminates the rest of the processes, as the instructions state
		terminateProcess(systemd.getPid());
		terminateProcess(agetty.getPid());
		terminateProcess(chronyd.getPid());
		terminateProcess(dbusdaemon.getPid());
		terminateProcess(firewalld.getPid());
		terminateProcess(irqbalance.getPid());
		terminateProcess(lvmetad.getPid());
		terminateProcess(polkitd.getPid());
		terminateProcess(sshd.getPid());
		terminateProcess(rsyslogd.getPid());
		
		//Prints out processes again
		System.out.println(processes);
		
	}
	
	public static Process createProcess(String name) {
		Process highestPid = processes.head;
		if (processes.isEmpty())
			return new Process(1, name);
		Process current = highestPid;
		while (current != null) {
			if (current.getPid() > highestPid.getPid())
				highestPid = current;
			current = current.getNext();
		}
		Process process = new Process(highestPid.getPid() + 1, name);
		return process;
	}
	
	public static String terminateProcess(int pid) {
		Process current = processes.head;
		while (current != null && current.getPid() != pid) {
			current = current.getNext();
		}
		if (current != null)
			return processes.remove(current);
		else return "";
	}
	
	public static void roundRobin() {
		if (processes.isEmpty())
			return;
		Process first = processes.head;
		
		Process current = first;
		do {
			System.out.print(current.getPid() + ", ");
			processes.contextSwitch();
			current = processes.head;
		} while (first.getPid() != current.getPid());
		System.out.print("\n");
	}

}
