package jolf;
import jolf.kconfig.*;

public class JolfTest {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Usage error");
			System.exit(-1);
		}
		
		KConfig config = new KConfig(args[0]);
		KConfigGroup courseGroup = config.group("0-course@-50,-50");
		System.out.println(config.size());
		if (courseGroup == null) {
			System.out.println("Error: course group not found");
			System.exit(0);
		}
		String courseName = courseGroup.readEntry("name","not set");
		System.out.print("Course name is ");
		System.out.println(courseName);
		
		System.out.println("Success!!");
		
	}
	
}
			