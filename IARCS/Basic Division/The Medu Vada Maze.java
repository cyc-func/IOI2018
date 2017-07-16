import java.io.*;
import java.util.*;

/*
6 12
####.#..####
.M.#..#..D.#
#.#...#....#
...#..#..#..
...#.#.###.#
.........###
*/

class Main
{
	static int r, c;
	static int mx, my, dx, dy;
	static char maze[][] = new char[1000][1000];;

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(f.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				maze[i][j] = (char) f.read();

				if(maze[i][j] == 'M')
				{
					mx = i;
					my = j;
				}

				if(maze[i][j] == 'D')
				{
					dx = i;
					dy = j;
				}
			}
			f.read();
		}

		DFS(mx, my);

		System.out.println("NO");
	}

	private static void print()
	{
		System.out.println("YES");
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		System.exit(0);
	}

	private static void DFS(int x, int y)
	{
		if(x == 0)
		{
			if(dx == r-1 && dy == y)
			{
				print();
			}

			if(maze[r-1][y] == '.')
			{
				maze[r-1][y] = 'x';
				DFS(r-1, y);
				maze[r-1][y] = '.';
			}
		}
		else
		{
			if(dx == x-1 && dy == y)
			{
				print();
			}

			if(maze[x-1][y] == '.')
			{
				maze[x-1][y] = 'x';
				DFS(x-1, y);
				maze[x-1][y] = '.';
			}
		}

		if(x == r-1)
		{
			if(dx == 0 && dy == y)
			{
				print();
			}

			if(maze[0][y] == '.')
			{
				maze[0][y] = 'x';
				DFS(0, y);
				maze[0][y] = '.';
			}
		}
		else
		{
			if(dx == x+1 && dy == y)
			{
				print();
			}

			if(maze[x+1][y] == '.')
			{
				maze[x+1][y] = 'x';
				DFS(x+1, y);
				maze[x+1][y] = '.';
			}
		}

		if(y == 0)
		{
			if(dx == x && dy == c-1)
			{
				print();
			}

			if(maze[x][c-1] == '.')
			{
				maze[x][c-1] = 'x';
				DFS(x, c-1);
				maze[x][c-1] = '.';
			}
		}
		else
		{
			if(dx == x && dy == y-1)
			{
				print();
			}

			if(maze[x][y-1] == '.')
			{
				maze[x][y-1] = 'x';
				DFS(x, y-1);
				maze[x][y-1] = '.';
			}
		}

		if(y == c-1)
		{
			if(dx == x && dy == 0)
			{
				print();
			}

			if(maze[x][0] == '.')
			{
				maze[x][0] = 'x';
				DFS(x, 0);
				maze[x][0] = '.';
			}
		}
		else
		{
			if(dx == x && dy == y+1)
			{
				print();
			}

			if(maze[x][y+1] == '.')
			{
				maze[x][y+1] = 'x';
				DFS(x, y+1);
				maze[x][y+1] = '.';
			}
		}
	}
}
