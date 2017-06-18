/*
ID: yashary1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class account
{
	private String name;
	private int money = 0;

	account(String name)
	{
		this.name = name;
	}

	public void change(int amount)
	{
		money += amount;
	}

	public String getName()
	{
		return name;
	}

	public int getAmount()
	{
		return money;
	}
}

class gift1
{
	private static int getIndex(String name, account peeps[])
	{
		for(int i = 0; i < peeps.length; i++)
		{
			if(name.equals(peeps[i].getName()))
			{
				return i;
			}
		}

		return -1;
	}

  public static void main(String [] args) throws IOException
  {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());

    int NP = Integer.parseInt(st.nextToken());

    account peeps[] = new account[NP];

    for(int i = 0; i < NP; i++)
    {
    	peeps[i] = new account(f.readLine());
    }

    String name;
    while((name = f.readLine()) != null)
    {
    	st = new StringTokenizer(f.readLine());
    	int amount = Integer.parseInt(st.nextToken());
    	int ppl = Integer.parseInt(st.nextToken());

    	if(amount > 0)
    	{
    		peeps[getIndex(name, peeps)].change(-amount + (amount % ppl));
    	}

    	for(int i = 0; i < ppl; i++)
    	{
    		String person = f.readLine();
    		if(amount > 0)
    			peeps[getIndex(person, peeps)].change(amount / ppl);
    	}
    }

    for(int i = 0; i < NP; i++)
    {
    	out.println(peeps[i].getName() + " " + peeps[i].getAmount());
    }

    out.close();
  }
}
