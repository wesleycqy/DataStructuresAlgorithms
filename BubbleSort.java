import javax.swing.JOptionPane;
public class BubbleSort
{
	public static void main(String[] args)
	{
		int num[]= new int[5];
		for (int x=1; x<=5; x++)
		{
			num[x-1] = Integer.valueOf(JOptionPane.showInputDialog(null,"Input number "+x));

		}
		System.out.print("\n");
		int numStore;
		int size = num.length; 

		for (int x=0; x<(size-1); x++)
		{
			for (int y=0; y<(size-1); y++)
			{
				if (num[y]>num[y+1])
				{
					numStore=num[y];
					num[y]=num[y+1];
					num[y+1]=numStore;
				}
            }
            System.out.print("Step "+x+":\t\t");
            for (int z=0; z<size; z++)
            {
                System.out.print(num[z]+"\t");
            }
            System.out.print("\n");
        }


        System.out.print("\nSorted array:\t");
		for (int x=0; x<size; x++)
		{
			System.out.print(num[x]+"\t");
		}
		System.out.print("\n\n");
	}
}
