package runnable_tasks;

import java.util.Map;
import static utils.StudentCollectionUtils.sortStudentsByGPA;
import static utils.IOUtils.storeStudentDetails;
import com.app.core.Student;

public class GPASorterTask implements Runnable 
{
	//state:
	private Map<String, Student> studentMap;
	private String fileName;
	
	//ctor:
	public GPASorterTask(Map<String, Student> studentMap, String fileName) {
		super();
		this.studentMap = studentMap;
		this.fileName = fileName;
		System.out.println("ctor invoked by "+Thread.currentThread().getName());
	}
	
	
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName()+" started");
		try 
		{
			//1. Sorting, 2. storing details
			storeStudentDetails(sortStudentsByGPA(studentMap), fileName); //returns Stream<Student>
			System.out.println("GPA based details stored...");
			
		}
		catch(Exception e)
		{
			System.out.println("error in "+Thread.currentThread().getName()+" exec "+e);
		}
		
		System.out.println(Thread.currentThread().getName()+" over ");
	}

}
