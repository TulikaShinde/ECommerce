package tester;

import java.util.HashMap;
import java.util.Map;
import static utils.StudentCollectionUtils.*;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DOBSorterTask;
import runnable_tasks.GPASorterTask;

public class TestCollectionIOThreads 
{

	public static void main(String[] args) 
	{
		
		try(Scanner sc=new Scanner(System.in))
		{
			Map<String, Student> populatedStudentMap = populateMap(populateList());
			
			System.out.println("Enter File name for storing GPA based detail:");
			//create task instance and attach it to thread
			//Thread(Runnable task instance, String name)
			Thread t1=new Thread(new GPASorterTask(populatedStudentMap, sc.nextLine()), "gpa_sorter");//t1:NEW
			
			System.out.println("Enter File name for storing DOB based detail:");
			//create task instance and attach it to thread
			//Thread(Runnable task instance, String name)
			Thread t2=new Thread(new DOBSorterTask(populatedStudentMap, sc.nextLine()), "dob_sorter");//t2:NEW
			
			//startt threads
			t1.start();
			t2.start();
			System.out.println("Main waiting for child threads");
			t1.join();
			t2.join();
			System.out.println("main over");
		}
		catch(Exception e)
		{
			System.out.println("error in min thread "+e);
		}
	}

}
