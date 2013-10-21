package src;

/**
 * @(#) Task.java
 */

public class Task
{
	public String name;
	
	public float duration;
	
	private Task Subtask;
	
	private Task Task;
	
	private Event Successor;
	
	private Event Predcessor;
	
	public boolean critical;
	
	private Container taskContainer;
	
	public void calculateSlack( )
	{
		
	}
	
	public void calculateCriticalPath( )
	{
		
	}
	
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
	
	
}
