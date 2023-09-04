import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.students.Student;
import com.students.StudentDao;

public class Main {
	public static void main(String[]args)throws IOException
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			System.out.println("press 1: create student");
			System.out.println("press 2: Delete student");
			System.out.println("press 3: display student");
			System.out.println("press 4: exit");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				//create
				System.out.println("Enter name");
				String name = br.readLine();
				
				System.out.println("Enter phone");
				String phone = br.readLine();
				
				System.out.println("Enter city");
				String city = br.readLine();
				
				Student s = new Student(name,phone,city);
				System.out.println(s);
				boolean res = StudentDao.createStudent(s);
				if(res)
				{
					System.out.println("Successfully added");
				}else {
					System.out.println("failed try again");
				}
				
			}else if(c==2) {
				System.out.println("Enter student id for delete");
				
				int userid = Integer.parseInt(br.readLine());
				boolean validUser = StudentDao.deleteStudent(userid);
				if(validUser)
				{
					System.out.println("deleted Successfully");
				}else {
					System.out.println("Userid is Invaild");
				}
				
			}
			else if(c==3) {
				StudentDao.showAllStudents();
				
			}
			else if(c==4) {
				break;
				
			}else {}
			
			}

		}
	}


