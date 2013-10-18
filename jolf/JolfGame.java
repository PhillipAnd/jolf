package jolf;
import jolf.kconfig.*;

public class JolfGame {

	public static void courseInfo(CourseInfo info, String filename)
		throws java.io.FileNotFoundException {
		
		KConfig config = new KConfig(filename);
		KConfigGroup configGroup = config.group("0-course@-50,-50");
		info.author = configGroup.readEntry("author",info.author);
		info.name = configGroup.readEntry("Name",info.name);
		
		int hole = 1;
		int par = 0;
		
		while (true) {
			String group = hole + "-hole@-50,-50|0";
			if (!config.hasGroup(group)) {
				hole--;
				break;
			}
			
			configGroup = config.group(group);
			par += Integer.parseInt(configGroup.readEntry("par","3"));
			
			hole++;
		}
		
		info.par = par;
		info.holes = hole;
	}

	
}

class CourseInfo {

	public String name;
	public String author;
	public int holes;
	public int par;
	
}