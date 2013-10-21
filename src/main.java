package src;

public class main {
		public static void main(String[] args) {
			Container container = new Container();
			container.readPERT(args[0]);
			container.calculateCriticalPath();
			container.writeDOT(args[0]);
		}
}