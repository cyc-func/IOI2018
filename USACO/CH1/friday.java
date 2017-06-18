/*
ID: yashary1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;


class friday
{
	private static boolean isLeap(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	private static int dayAfterKDays(int day, int k)
	{
		return (day + k - 1) % 7;
	}

  public static void main(String [] args) throws IOException
  {
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    int N = Integer.parseInt(st.nextToken());

    // 0 = sat, 1 = sun, ..., 6 = fri
    int occurances[] = new int[7];

    int monthDays[][] = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
  											 {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

  	int day = 2;
  	for(int year = 1900; year < 1900 + N; year++)
  	{
  		for(int month = 0; month < 12; month++)
  		{
  			occurances[dayAfterKDays(day, 13)]++;
  			day = dayAfterKDays(day, monthDays[isLeap(year) ? 1 : 0][month] + 1);
  		}
  	}

  	for(int i = 0; i < 7; i++)
  	{
  		out.print(occurances[i] + (i == 6 ? "\n" : " "));
  	}
    
    out.close();
  }
}
