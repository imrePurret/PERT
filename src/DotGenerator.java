package src;

import java.util.ArrayList;
import java.util.List;

public class DotGenerator {
	Container container;
	String output = "";
	List<Task> generatedTasks = new ArrayList<Task>();
	
	
	public DotGenerator(Container container){
		this.container = container;
	}
	
	public String Generate(){;
		output += "digraph G {\n";
		Task start = container.findStartTask();
		generateTasks(start);
		output += "}";
		return output;
		
	}

	private void generateTasks(Task start) {
		if(isTaskGenerated(start.getName())){
			return;
		} else {
			generatedTasks.add(start);
		}
		output += "	"+ start.getName() + " [shape=box,label=\""+start.getName() + " (" + start.getDuration()+" days )\"];\n";
		if(start.isCritical()){
			output += "	"+ start.getName() + " [color=red];\n";
		}
		for(Task task : start.getSuccessorTask()){
			output += "	"+ task.getName() + " [shape=box];\n";
			output += "	"+ start.getName() + " -> "+ task.getName() + ";\n";
			generateTasks(task);
		}
	}
	
	public boolean isTaskGenerated(String name){
		for(Task task  : generatedTasks){
			if(name.equals(task.getName())){
				return true;
			}
		}
		return false;
	}

}
