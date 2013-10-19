package jolf;
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