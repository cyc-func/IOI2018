/*
ID: yashary1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride
{
  public static void main(String [] args) throws IOException
  {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

    char comet[] = f.readLine().trim().toCharArray();
    char group[] = f.readLine().trim().toCharArray();

    int cometNum = 1;
    int groupNum = 1;

    for(int i = 0; i < comet.length; i++)
    {
    	cometNum *= comet[i] - 'A' + 1;
    }

    for(int i = 0; i < group.length; i++)
    {
    	groupNum *= group[i] - 'A' + 1;
    }

    cometNum %= 47;
    groupNum %= 47;

    if(cometNum == groupNum)
    {
    	out.println("GO");
    }
    else
    {
    	out.println("STAY");
    }

    out.close();
  }
}
