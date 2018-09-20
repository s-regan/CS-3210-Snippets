import java.util.Scanner;

public class Floyd {

    private static int[][] tableDist;
    private static int[][] tablePath;
    private static int vertNum;
    public static void main(String[] args)
    {
        System.out.print("Number of vertices: ");
        Scanner sysin = new Scanner( System.in );
        vertNum = sysin.nextInt();
        tableDist = new int[vertNum][vertNum];
        tablePath = new int[vertNum][vertNum];

        for(int i = 0; i < vertNum; i++)
		{
            System.out.println("Row weights (use space to separate): ");
                for(int j = 0; j < vertNum; j++)
                        tableDist[i][j] = sysin.nextInt();
        }
        floyds();
    }
	private static void print(int[][] table1, int[][] table2)
	{
        for(int i = 0; i < table1.length && i < table2.length; i++)
		{
            for(int k = 0; k < table1[i].length && k < table2[i].length; k++)
			{
                if(table1[i][k] == -1)
                    System.out.print("-" + " (" + table2[i][k] + ")");
                else
                    System.out.print(table1[i][k] + " (" + table2[i][k] + ")");
				System.out.print("\t|\t");
            }
            System.out.println();
        }
    }

    private static void floyds()
	{
        System.out.println("\n ITERATION: (0) ");
        print(tableDist, tablePath);

        // Floyd's 
        // k = iteration #
        // i = row #
        // j = column #
        for(int k = 0; k < vertNum; k++) 
		{
            for (int i = 0; i < vertNum; i++) 
			{
                for (int j = 0; j < vertNum; j++) 
				{
                    if ((tableDist[i][j] > (tableDist[i][k] + tableDist[k][j])|| tableDist[i][j] < 0)&& tableDist[k][j] > 0 && tableDist[i][k] > 0) 
					{
                        tableDist[i][j] = tableDist[i][k] + tableDist[k][j];
                        tablePath[i][j] = k+1;
                    }
                }
            }
            System.out.println("\n ITERATION:(" + (k+1) + ") ");
            print(tableDist, tablePath);
            
        }
    }  
}