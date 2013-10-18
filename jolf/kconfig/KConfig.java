package jolf.kconfig;
import java.io.*;
import java.util.*;
import jolf.kconfig.*;

public class KConfig extends Hashtable<String,KConfigGroup> {

public KConfig(String filename) throws FileNotFoundException {
	Scanner in = new Scanner(new File(filename),"utf-8");
	boolean initialized = false;
	String groupName = null;
	String buffer = "";
	KConfigGroup curGroup = null;
	while (in.hasNextLine()) {
		String cur = in.nextLine();
		if (cur.length() > 0 &&
				cur.charAt(0) == '[' && cur.charAt(cur.length() - 1) == ']') {
			if (initialized) {
				curGroup = KConfigGroup.parse(buffer);
				put(groupName,curGroup);
				buffer = "";
			} else {
				initialized = true;
			}
			groupName = cur.substring(1,cur.length()-1);
		}
		else {
			buffer += cur;
			buffer += "\n";
		}
	}
	if (groupName != null && curGroup != null) {
		curGroup = KConfigGroup.parse(buffer);
		put(groupName,curGroup);
	}
}

public KConfigGroup group(String groupName) {
	return get(groupName);
}


}