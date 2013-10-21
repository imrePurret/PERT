package src;
public class Main {
		public static void main(String[] args) {
			Container container = new Container();
			container.readPERT(args[0]);
			container.calculateCriticalPath();
			container.writeDOT(args[0]);
		}
}