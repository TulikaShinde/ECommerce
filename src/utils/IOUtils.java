package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import com.app.core.Student;

public interface IOUtils 
{
	//add a static method to write Stream<Student> to a test file in buffered manner
	//we are returning an open stream from sort method
	static void storeStudentDetails(Stream<Student> students, String fileName) throws IOException
	{
		//chain of I/O streams:writing
		//Java app-->PW-->FW-->text file
		try(PrintWriter pw=new PrintWriter(new FileWriter(fileName)))
		{
			//write data from stream of elements to buffered ___
			//students.forEach(s -> pw.println(s));
			
			//OR: method reference
			students.forEach(pw::println);
			
			//students.forEach(s -> pw.println(s+",")); //cannot be replaced by method reference
		}
	}
}
