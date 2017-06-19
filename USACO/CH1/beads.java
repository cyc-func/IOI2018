/*
ID: swagwamfamanam
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;


class beads
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());
    int N = Integer.parseInt(st.nextToken());

    char beads[] = f.readLine().toCharArray();

    int globalMax = 0;
    for(int i = 0; i < N; i++)
    {
    	int local = maxBeads(i, beads);
    	if(local > globalMax) globalMax = local;
    }

    out.println(globalMax);
    out.close();
	}

	private static int maxBeads(int index, char beads[])	// necklace is broken between index and index + 1
	{
		int ix1m = ((index + 1) % beads.length);

		int cIndx;

		int leftBlue = beads[ix1m] == 'b' ? 1 : 0, rightRed = beads[index] == 'r' ? 1 : 0;
		cIndx = index;
		while(cIndx != ix1m && beads[cIndx] != 'r')
		{
			leftBlue++;

			cIndx--;
			if(cIndx < 0) cIndx += beads.length;
		}
		cIndx = ix1m;
		while(cIndx != index && beads[cIndx] != 'b')
		{
			rightRed++;

			cIndx++;
			if(cIndx >= beads.length) cIndx = 0;
		}
		if(leftBlue + rightRed > beads.length)
		{
			leftBlue = 0;
			rightRed = beads.length;
		}

		int leftRed = beads[ix1m] == 'r' ? 1 : 0, rightBlue = beads[index] == 'b' ? 1 : 0;
		cIndx = index;
		while(cIndx != ix1m && beads[cIndx] != 'b')
		{
			leftRed++;

			cIndx--;
			if(cIndx < 0) cIndx += beads.length;
		}
		cIndx = ix1m;
		while(cIndx != index && beads[cIndx] != 'r')
		{
			rightBlue++;

			cIndx++;
			if(cIndx >= beads.length) cIndx = 0;
		}
		if(leftRed + rightBlue > beads.length)
		{
			leftRed = 0;
			rightBlue = beads.length;
		}

		return Math.max(leftBlue + rightRed, leftRed + rightBlue);
	}
}
