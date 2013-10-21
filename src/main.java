package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	 Task task;
		public static void main(String[] args) {
			Container container = new Container();
			container.readPERT();
			System.out.println(container.calculateCriticalPath());
			container.printTaskList();
			container.writeDOT();
	 
		}
}