import java.io.*;
import java.util.*;
import java.util.Queue;


class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Vertex vertex[] = new Vertex[3500];
		for(int i = 0; i < 3500; i++)
		{
			vertex[i] = new Vertex(i);
		}

		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(f.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			vertex[u].neighbours.add(v);
			vertex[v].neighbours.add(u);
		}

		st = new StringTokenizer(f.readLine());
		int s = Integer.parseInt(st.nextToken()) - 1;
		int t = Integer.parseInt(st.nextToken()) - 1;

		System.out.println(BFS(s, t, vertex));
	}

	private static int BFS(int src, int dest, Vertex vertex[])
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		vertex[src].distance = 0;
		queue.add(src);

		while(!queue.isEmpty())
		{
			int cur = queue.remove();
			for(int elem : vertex[cur].neighbours)
			{
				if(elem == dest)
				{
					return vertex[cur].distance + 1;
				}

				if(vertex[elem].distance == -1)
				{
					vertex[elem].distance = vertex[cur].distance + 1;
					queue.add(elem);
				}
			}
		}

		return 0;
	}

	static class Vertex
	{
		int u;
		int distance = -1;

		List<Integer> neighbours = new ArrayList<Integer>();

		Vertex(int u)
		{
			this.u = u;
		}
	}
}
