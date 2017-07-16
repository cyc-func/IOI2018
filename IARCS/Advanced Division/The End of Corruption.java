import java.io.*;
import java.util.*;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int totalNums = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

		MaxHeap queue = new MaxHeap();

		for(int i = 0; i < totalNums; i++)
		{
			st = new StringTokenizer(f.readLine());
			int cur = Integer.parseInt(st.nextToken());

			if(cur == -1)
			{
				System.out.println(queue.poll());
			}
			else
			{
				queue.add(cur);
			}
		}
	}


	static int heap[] = new int[100000];

	static class MaxHeap
	{
		int size = 0;

		void add(int k)
		{
			heap[size++] = k;

			int i = size - 1;
			while(i > 0 && heap[(i-1)/2] < k)
			{
				int t = heap[i]; heap[i] = heap[(i-1)/2]; heap[(i-1)/2] = t;
				i = (i-1)/2;
			}
		}

		int poll()
		{
			int e = heap[0];
			heap[0] = heap[--size];

			int i = 0;
			while(i < size/2)
			{
				int l = 2*i + 1;
				int max = i;

				if(heap[l] > heap[max]) max = l;
				if(heap[l+1] > heap[max]) max = l+1;

				if(max != i)
				{
					int t = heap[i]; heap[i] = heap[max]; heap[max] = t;
					i = max;
				}
				else
				{
					break;
				}
			}

			return e;
		}
	}
}
