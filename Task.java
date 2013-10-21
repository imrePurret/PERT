public class Task
{
	public String Name;
	
	public float Duration;
	
	private Task Subtask;
	
	private Task Task;
	
	private Event Successor;
	
	private Event Predcessor;
	
	public boolean Critical;
	
	
	private Container taskContainer;
	
	public void calculateSlack( )
	{
		
	}
	
	public void calculateCriticalPath( )
	{
		
	}
	
	public void setCritical( boolean isCritical )
	{
		Critical=isCritical;
	}
	
	public boolean isIsCritical( )
	{
		return Critical;
	}
	
	public void setDuration( float duration )
	{
		Duration=duration;
	}
	
	public float getDuration( )
	{
		return Duration;
	}
	
	public void setName( String name )
	{
		Name=name;
	}
	
	public String getName( )
	{
		return Name;
	}
	
	public void setTask( Task task )
	{
		Task=task;
	}
	
	public Task getTask( )
	{
		return Task;
	}
	
}
