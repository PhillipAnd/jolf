package jolf.kconfig;
/*
    Copyright (C) 2002-2005, Jason Katz-Brown <jasonkb@mit.edu>
    Copyright 2010 Stefan Majewsky <majewsky@gmx.net>
	Port to Java by Phillip Andrews, 2013

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
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

	public boolean hasGroup(String groupName) {
		return containsKey(groupName);
	}


}