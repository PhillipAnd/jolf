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
			