import java.util.*;

public class Project3 {

    public static void main (String[] args) 
	{
        int[] numberArray = {3, 1, 7, 5, 8, 4};
        System.out.println("Total Sum by Player 1 = " + solve(numberArray));

    }

    private int mySolution(int first, int last)
	{
        int sum = 0;
        return sum;
    }

    public static int solve(int[] numberArray) 
	{
        int[][] myValue = new int[numberArray.length][numberArray.length];

        for (int interval = 0; interval < numberArray.length; interval++) 
		{
            for (int i = 0, j = interval; j < numberArray.length; i++, j++) 
			{
                // x = myValue(i+2,j) - 1 choose i, 2 choose i+1
                // y = myValue(i+1,j-1)- 1 choose i , 2 choose j OR 1 chooses j ,2 chooses i
                // z = myValue(i,j-2)- 1 choose j , 2 choose j-1
				
                int x, y, z;
                if (i + 2 <= j)
                    x = myValue[i + 2][j];
                else
                    x = 0;
       
                if (i + 1 <= j - 1)
                    y = myValue[i + 1][j - 1];
                else
                    y = 0;
 
                if (i <= j - 2)
                    z = myValue[i][j-2];
                else
                    z = 0;
             
                myValue[i][j] = Math.max(numberArray[i] + Math.min(x, y), numberArray[j]+ Math.min(y, z));

            }
        }
        for(int i = 0; i < myValue.length; i++)
		{
            for(int j = 0; j < myValue.length; j++)
			{
                if(i == j || i == myValue.length - 1 || j == 0)
				{
                    if(myValue[i][j] == 0)
					{
                        System.out.print("-- ");
                    }
                    else
					{
                        System.out.print(myValue[i][j] + "F ");
                    }

                }
                else 
				{
                    if(myValue[i][j] == 0){
                        System.out.print("-- ");
                    }
                    else 
					{
                        int scoreLeft = myValue[i][j - 1];
                        int scoreDown = myValue[i + 1][j];
                        if (scoreDown < scoreLeft) 
						{
                            System.out.print(myValue[i][j] + "F ");
                        } else 
						{
                            System.out.print(myValue[i][j] + "L ");
                        }
                    }
                }

            }
            System.out.println();
        }
        return myValue[0][numberArray.length - 1];
    }
}


