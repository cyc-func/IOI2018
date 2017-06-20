/*
ID: demonstratingmorethaneverdevastatinghowtogivetheseaudiencefeelinglikeitslevitating
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;


class namenum
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

		long N = Long.parseLong((new StringTokenizer(f.readLine())).nextToken());

		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));

		int count = 0;
		String line;
		while((line = dict.readLine()) != null)
		{
			if(N == getID(line))
			{
				out.println(line);
				count++;
			}
		}

		if(count == 0)
		{
			out.println("NONE");
		}
		
		out.close();
	}

	private static long getID(String name)
	{
		long id = 0;
		for(int i = 0; i < name.length(); i++)
		{
			switch(name.charAt(i))
			{
				case 'A':
				case 'B':
				case 'C':
					id = id * 10 + 2;
					break;
				case 'D':
				case 'E':
				case 'F':
					id = id * 10 + 3;
					break;
				case 'G':
				case 'H':
				case 'I':
					id = id * 10 + 4;
					break;
				case 'J':
				case 'K':
				case 'L':
					id = id * 10 + 5;
					break;
				case 'M':
				case 'N':
				case 'O':
					id = id * 10 + 6;
					break;
				case 'P':
				case 'R':
				case 'S':
					id = id * 10 + 7;
					break;
				case 'T':
				case 'U':
				case 'V':
					id = id * 10 + 8;
					break;
				case 'W':
				case 'X':
				case 'Y':
					id = id * 10 + 9;
					break;
			}
		}
		return id;
	}
}
