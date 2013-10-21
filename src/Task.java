package src;

/**
 * @(#) Task.java
 */
public class Task
{
	
	public String name;
	
	public float duration;
		
	public boolean critical;
		
	private Container taskContainer;
		
	private Task successorTask;
		
	private Task predcessorTask;
		
	
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
