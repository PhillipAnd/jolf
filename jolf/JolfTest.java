package jolf;
import jolf.kconfig.*;

public class JolfTest {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("Usage error");
			System.exit(-1);
		}
		
		CourseInfo info = new CourseInfo();
		info.name = "Untitled";
		info.author = "Unknown";
		JolfGame.courseInfo(info,args[0]);
		
		System.out.println(info.name);
		System.out.println("by " + info.author);
		System.out.println(info.holes + " holes, par " + info.par);
		
	}
	
}
			