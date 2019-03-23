COMP 222: Introduction to Data Structures and Algorithms
Spring 2019
Program 1 – Process Manager
Date Released: 02/25/2019	 
Assignment: For this program, we are building a ready queue for a process manager. Our program consists of three classes: Process, ReadyQueue, and ProcessManager.
Process class:
The Process class represents the programs that are currently running on the machine. The Process class has the following member variables, constructor and methods. Notice that the files data structure is left for you to design and implement. 
Member Variables:
-	int pid: this is a unique process identifier. Each process is assigned a process id whenever it gets created. No two processes in the same system can have the same pid. 
-	String name: this is the name of the process.
-	String state: this is the current state of the process. The state of the process starts at ready and eventually it becomes terminated.
-	int timeslice: an integer representing the number of microseconds this process should run at a time.
-	files: this is a data structure that contains the names of the files that are currently open by this process. The implementation is left up to you. You can choose either a linked list or an array. Think carefully about this choice and justify it in Task 1.
-	One or more member variables to implement the doubly linked list structure.
Constructor:
-	public Process (int pid, name): creates a new process with the specified process identifier and the specified name. It initializes the state variables to “ready” and timeslice to 1. The files data structure should be created but empty.
Methods: 
-	public void openFile(String newfile): should add a new filename to the files data structure.
-	public void closeFile(String newfile): should remove the filename specifies from the files data structure.
-	getters and setters for all the member variables. Feel free to auto-generate these methods. 
-	public String toString(): returns a string representation of the process in the following format:
Process pid	name	state




ReadyQueue class
The ReadyQueue class should implement a doubly linked list of processes. ReadyQueue class has the following structure:
Member Variables: 
-	head: Process that is at the head of the process queue.
-	tail: Process that is at the tail of the process queue.
-	size: the number of processes in the queue.
Constructors: 
-	public ReadyQueue(): creates an empty ready queue.
-	public ReadyQueue(Process head): creates a new ready queue with the head process as its first process.
Methods: 
-	public int getNProcesses(): returns the number of processes in the queue.
-	public void addProcess(Process c): adds a process to the end of the queue.
-	public String removeProcess(): removes a process from the head of the queue and returns its state.
-	public void contextSwitch(): moves the process at the head of the queue to the end of the queue.
-	public boolean isEmpty(): returns true if the queue is empty and false otherwise.
-	public String toString(): returns a String representation of all of the processes in the queue from head to tail. This method should make use of the Process’s toString() method to print each process on a new line. 
ProcessManager class:
The ProcessManager class should run the whole program so it should have a main method according to the specifications below. In addition, it should have the following member variables and methods. 
Member variables: 
-	readyQueue: one queue consisting of a list of processes.
Methods: 
-	main method: the main method should have the following steps:
o	create a process whose name is systemd
o	create 10 more processes with the names: agetty, chronyd, crond, dbus-daemon, firewalld, irqbalance, lvmetad, polkitd, sshd, rsyslogd
o	run 1 round of round robin scheduling 
o	sshd process opens two files: hello.c and hello.h.
o	sshd process closes hello.c file.
o	terminate the process whose name is crond
o	print the ready queue
o	terminates all the processes
o	print the ready queue 
o	exit the program
-	public int createProcess(String name): this should create a new process with the specified name and return its process pid. The pid of the new process should 1+the highest pid in the ready queue. For example: if the queue is empty, then the process gets a pid of 1. If the queue has two processes with pids 5 and 10, the new process should get a pid of 11. 
-	public String terminateProcess(int pid): this should terminate the process whose pid is specified. This means that process should be removed from the ready queue. 
-	public void roundRobin(): this should traverse the ready queue from front to end printing the pids of all the processes encountered. This method should make use of the contextSwitch method in the ready queue.

Instructions: This program is split into two tasks:
Task 1: 
Design the data structure used to store the files for each process. You may add other member variables to the Process class to accommodate your design. The deliverables in this task: 
-	word document explaining which data structure you chose and justifying why you chose it.
Task 2: 
Implement the three classes: Process, ReadyQueue, and ProcessManager. You may add other variables and methods to these classes if needed. The deliverables for this task:
-	Process.java
-	ReadyQueue.java
-	ProcessManager.java
Make sure you comment each of the classes stating any assumptions you made during the implementation. 

Program policies:
•	A program that does not compile or run will not be graded.
•	Extensions will not be granted for technology-related issues.  Leave yourself enough time to complete the assignment, submit the assignment using mygcc, and contact the instructor if you run into problems.
•	This program should be completed by each student. It is not a group project. 
•	Please refer to the syllabus for the academic integrity policy that applies to this course. 





Rubric:	 The points for this program are awarded according to the following:

Task 1

Choice of data structure …………………………………………………………………….. 5 points
Justification of the choice…………………………………………………………………….. 5 points
	10 pts
Task 2	
Process class
-	Implementation of the files data structure………………………………….. 5 points
-	Member variables…………………………………………………………………….. 5 points
Methods:
-	openFile…………………………………………………………………….. 5 points
-	closeFile…………………………………………………………………….. 5 points
-	getters and setters…………………………………………………………………….. 5 points
-	toString…………………………………………………………………….. 2 points	27 pts
ReadyQueue class
Member variables…………………………………………………………………….. 5 points
Constructors…………………………………………………………………….. 5 points
Methods:
-	getNProcesses()…………………………………………………………………….. 2 points
-	addProcess(Process c) ……………………………………………………….. 5 points
-	removeProcess()…………………………………………………………………….. 5 points
-	contextSwitch()……………………………………………………………………..6 points
-	isEmpty()…………………………………………………………………….. 2 points
-	toString()…………………………………………………………………….. 5 points	35 pts
ProcessManager class
Methods: 
-	main method…………………………………………………………………….. 7 points
-	createProcess(String name):………………………………………………………….. 7 points
-	terminateProcess(int pid): ……………………………………………………….. 7 points
-	roundRobin():…………………………………………………………………….. 7 points	28 pts


Submission:	
Assignments must be submitted electronically via my.gcc. Be sure to upload your files correctly the first time. Acceptable document formats include Microsoft Word for task 1 and java files for task 2.  

