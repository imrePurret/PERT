import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Container
{
	private List<Task> tasksList = new ArrayList<Task>();
	private List<Task> longestPath = new ArrayList<Task>();
	private float longestWay = 0;
	
	public void addTask( String[] strings )
	{
		if(strings.length<2){
			System.out.println("Invalid input!");
			System.exit(0);
		}
		Task task = new Task();
		if(getTask(strings[0])==null){
			tasksList.add(task);
		} else{
			task = getTask(strings[0]);
		}
		task.setName(strings[0]);
		try{
			task.setDuration(Float.parseFloat( strings[1]));			
		} catch(Exception e){
			System.out.println("Invalid input!");
			System.exit(0);
		}
		
		for(int x = 2; x < strings.length; x = x+1) {
	         Task pred = new Task();
	 	     if(getTask(strings[x])==null){
			 	tasksList.add(pred);
			 } else{
			 	pred = getTask(strings[x]);
			 }
	         pred.setName(strings[x]);
	         pred.getSuccessorTask().add(task);
	         task.getPredcessorTask().add(pred);
	      }
	}
	
	private Task getTask(String taskName) {
		for(Task task  : tasksList){
			if(taskName.equals(task.getName())){
				return task;
			}
		}
		return null;
	}
	public void readPERT(String args )
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(args));
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				this.addTask(sCurrentLine.split(","));
			}
			validate();
 
		} catch (IOException e) {
			System.out.println("Invalid input!");
			System.exit(0);
		} catch (Error e){
			System.out.println("Invalid input!");
			System.exit(0);
		}
	}
	
	private void validate() {
		if(findStartTask()==null){
			System.out.println("Invalid input - there is no start task.");
			System.exit(0);
		}
		if(findFinalTask()==null){
			System.out.println("Invalid input - there is no final task.");
			System.exit(0);
		}
		int counter = 0;
		for(Task task  : tasksList){
			if(task.getSuccessorTask().size()==0){
				counter += 1;
			}
		}
		if (counter>1){
			System.out.println("Invalid input - there is more than one task without successors.");
			System.exit(0);
		}
		counter = 0;
		for(Task task  : tasksList){
			if(task.getPredcessorTask().size()==0){
				counter += 1;
			}
		}
		if (counter>1){
			System.out.println("Invalid input - there is more than one task without predecessors.");
			System.exit(0);
		}
	}

	public void writeDOT(String args ){
		DotGenerator dotGen = new DotGenerator(this);
	    PrintWriter out;
		try {
			String[] arg = args.split("\\.");
			out = new PrintWriter(new FileWriter(arg[0]+".dot"), true);
		    out.write(dotGen.Generate());
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public float calculateCriticalPath(){
		return calculateCriticalPathImpl(findFinalTask(), findFinalTask().getDuration(), new ArrayList<Task>() );
	}
	
	public float calculateCriticalPathImpl(Task task1, float duration, ArrayList<Task> tasks )
	{
		try{
			tasks.add(task1);
			float longestWay = duration;
			if(task1.getPredcessorTask().size()==0){
				if(duration>this.longestWay){
					this.longestWay = duration;
					longestPath.clear();
					for(Task taski : tasks){
						longestPath.add(taski);
					}
				}
				tasks.remove(task1);
				return duration;
			} else{
				for(Task task : task1.getPredcessorTask()){
					calculateCriticalPathImpl(task, duration + task.getDuration(), tasks);
				}
			}
			for(Task task2 : longestPath){
				task2.setCritical(true);
			}
			findFinalTask().setCritical(true);
			findStartTask().setCritical(true);
			return longestWay;
		} catch (Error e) {
			System.out.println("Invalid input - PERT chart is cyclic");
			System.exit(0);
		}
		return duration;
	}
	
	public Task findFinalTask(){
		for(Task task  : tasksList){
			if(task.getSuccessorTask().size()==0){
				return task;
			}
		}
		return null;
	}
	
	public Task findStartTask(){
		for(Task task  : tasksList){
			if(task.getPredcessorTask().size()==0){
				return task;
			}
		}
		return null;
	}
	
}

