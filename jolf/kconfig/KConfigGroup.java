package jolf.kconfig;
import java.util.Hashtable;
import java.util.Scanner;

public class KConfigGroup extends Hashtable<String,String> {

	public String readEntry(String key, String def) {
		String result;
		if ((result = get(key.toLowerCase())) != null)
			return result;
		else
			return def;
	}
	
	public static KConfigGroup parse(String raw) {
		KConfigGroup result = new KConfigGroup();
		Scanner in = new Scanner(raw);
		while (in.hasNextLine()) {
			String[] components = in.nextLine().split("=",2);
			if (components.length == 2) {
				result.put(components[0].toLowerCase(),components[1]);
			}
		}
		
		return result;
	}
	
}