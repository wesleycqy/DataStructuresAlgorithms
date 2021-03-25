import javax.swing.JOptionPane;
public class InsertionSort
{
	public static void main(String[] args)
	{
		int num[]= new int[5];
		for (int x=1; x<=5; x++)
		{
			num[x-1] = Integer.valueOf(JOptionPane.showInputDialog(null,"Input number "+x));

		}
		int temp;
		int size = num.length; 
        System.out.println("");
		for (int x=0; x<(size); x++)
		{
			for (int y=0; y<(x); y++)
			{
				if (num[x]<=num[y])
				{
					temp = num[x];
					for (int z=x; z>y; z--)
					{
						num[z]=num[z-1];
					}
					num[y]=temp;
				}
            }

            System.out.print("Step "+x+":\t\t");
            for (int v=0;v<size;v++)
            {
                System.out.print(num[v]+"\t");
            }
            System.out.println("");
        }
        
        System.out.print("\nSorted Array:\t");
		for (int v=0;v<size;v++)
		{
			System.out.print(num[v]+"\t");
        }
        System.out.println("\n");
	}
}
