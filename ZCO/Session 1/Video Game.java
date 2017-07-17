import java.io.*;
import java.util.*;


class Main
{
	static int stack[] = new int[100000];

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < n; i++)
		{
			stack[i] = Integer.parseInt(st.nextToken());
		}

		int stackPointer = 0;
		boolean craneHasBox = false;

		int curIns;
		st = new StringTokenizer(f.readLine());
		while((curIns = Integer.parseInt(st.nextToken())) != 0)
		{
			switch(curIns)
			{
				case 1:
					if(stackPointer >= 1)
					{
						stackPointer--;
					}
					break;
				case 2:
					if(stackPointer <= n-2)
					{
						stackPointer++;
					}
					break;
				case 3:
					if(!craneHasBox && stack[stackPointer] > 0)
					{
						craneHasBox = true;
						stack[stackPointer]--;
					}
					break;
				case 4:
					if(craneHasBox && stack[stackPointer] < h)
					{
						craneHasBox = false;
						stack[stackPointer]++;
					}
					break;
			}
		}

		for(int i = 0; i < n; i++)
		{
			System.out.print(stack[i] + " ");
		}
	}
}
