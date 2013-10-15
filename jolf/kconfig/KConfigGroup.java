package jolf.kconfig;
import java.util.Hashtable;

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
		
		return result;
	}
	
}