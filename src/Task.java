package src;

import java.util.ArrayList;
import java.util.List;

public class Task
{
	public String name;
	
	public int duration;
	
	public boolean critical = false;
	
	private Container taskContainer;
	
	private List<Task> successorTask = new ArrayList<Task>();
	
	private List<Task> predcessorTask = new ArrayList<Task>();
	
	
	public void setCritical( boolean critical )
	{
		this.critical=critical;
	}
	
	public boolean isCritical( )
	{
		return critical;
	}
	
	public void setDuration( int duration )
	{
		this.duration=duration;
	}
	
	public int getDuration( )
	{
		return duration;
	}
	
	public void setName( String name )
	{
		this.name=name;
	}
	
	public String getName( )
	{
		return name;
	}

	public List<Task> getSuccessorTask() {
		return successorTask;
	}

	public void setSuccessorTask(List<Task> successorTask) {
		this.successorTask = successorTask;
	}

	public List<Task> getPredcessorTask() {
		return predcessorTask;
	}

	public void setPredcessorTask(List<Task> predcessorTask) {
		this.predcessorTask = predcessorTask;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", duration=" + duration + ", critical="
				+ critical
				+  "]";
	}
	
	
}