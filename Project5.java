import java.util.Scanner;

public class Project5 {
    private static String first, second;
    private static int[][] penalty;
    private static String[][] decision;
    private static final String DWN = "||";
    private static final String DGNL = "\\";
    private static final String RGHT = ">>";
	
    public static void main(String[] args) 
	{
        if (args.length == 2) 
		{
            first = args[0];
            second = args[1];
        } else 
		{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your two strings, (on seperate lines):");
            first = sc.nextLine().trim().toUpperCase();
            second = sc.nextLine().trim().toUpperCase();
        }
        createTable();
        printTable();
        alignString();
    }
    private static void createTable() {
        int firstLength = first.length();
        int secondLength = second.length();

        penalty = new int[firstLength + 1][secondLength + 1];
        decision = new String[firstLength + 1][secondLength + 1];
		
        for (int i = 0; i <= firstLength; i++) 
		{
            penalty[i][secondLength] = (firstLength - i) * 2;
            decision[i][secondLength] = DWN;
        }

        //bottom row.
        for (int j = 0; j <= secondLength; j++) 
		{
            penalty[firstLength][j] = (secondLength - j) * 2;
            decision[firstLength][j] = RGHT;
        }

        decision [firstLength][secondLength] = "XX";


        for (int i = firstLength - 1; i >= 0; i--) 
		{
            for (int j = secondLength - 1; j >= 0; j--) 
			{
                int mismatch_penalty = first.charAt(i) == second.charAt(j) ? 0 : 1;
                int rght = 2 + penalty[i][j + 1];
                int dgnl = mismatch_penalty + penalty[i + 1][j + 1];
                int down = 2 + penalty[i + 1][j];

                if (down < dgnl && down < rght) 
				{
                    penalty[i][j] = down;
                    decision[i][j] = DWN;
                }

                else if (rght < dgnl && rght < down) 
				{
                    penalty[i][j] = rght;
                    decision[i][j] = RGHT;
                }

                else 
				{
                    penalty[i][j] = dgnl;
                    decision[i][j] = DGNL;
                }
            }
        }
    }
    private static void printTable() 
	{
        int firstLength = first.length();
        int secondLength = second.length();
        System.out.println("Chart:");
        System.out.print("    ");  
        for (int j = 0; j < secondLength; j++)
            System.out.printf("%4c ", second.charAt(j));
			System.out.println("  -");  
        for (int i = 0; i < firstLength; i++) 
		{
            System.out.printf("%2c ", first.charAt(i));

            for (int j = 0; j <= secondLength; j++)
                System.out.printf("%4d ", penalty[i][j]);
				System.out.print("\n     ");

            for (int j = 0; j <= secondLength; j++)
                System.out.printf("%3s  ", decision[i][j]);
				System.out.println("\n");
        }
        System.out.print(" - ");
        for (int j = 0; j <= secondLength; j++)
            System.out.printf("%4d ", penalty[firstLength][j]);
        System.out.print("\n    ");

        for (int j = 0; j <= secondLength; j++)
            System.out.printf("%3s  ", decision[firstLength][j]);
        System.out.println();  
    }


    private static void alignString() 
	{
        String alignFirst = "";
        String alignSecond = "";
        for (int i = 0, j = 0; i < first.length() || j < second.length();) 
		{
            switch (decision[i][j]) 
			{
                case DGNL:
                    alignFirst += first.charAt(i);
                    alignSecond += second.charAt(j);
                    i++; j++;
                    break;

                case DWN:
                    alignFirst += first.charAt(i);
                    alignSecond += "-";
                    i++;
                    break;

                case RGHT:
                    alignFirst += "-";
                    alignSecond += second.charAt(j);
                    j++;
                    break;
            }
        }
        System.out.printf("%nOptimal:%2d%n", penalty[0][0]);
        System.out.printf("Aligned Strings:  %S%n                  %S%n",alignFirst, alignSecond);
    }
}
//CATGAATACGTA 
//CTGAATACTGTA
