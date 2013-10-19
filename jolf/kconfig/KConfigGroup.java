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
	
	static KConfigGroup parse(String raw) {
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