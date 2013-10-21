import java.util.ArrayList;
import java.util.List;

public class Task
{
	private String name;
	
	private float duration;
	
	private boolean critical = false;
	
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
	
	public void setDuration( float duration )
	{
		this.duration=duration;
	}
	
	public float getDuration( )
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

	public List<Task> getPredcessorTask() {
		return predcessorTask;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", duration=" + duration + ", critical="
				+ critical + "]";
	}
		
}