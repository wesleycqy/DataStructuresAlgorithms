import javax.swing.JOptionPane;
public class SelectionSort
{
	public static void main(String[] args)
	{
		int num[]= new int[5];
		for (int x=1; x<=5; x++)
		{
			num[x-1] = Integer.valueOf(JOptionPane.showInputDialog(null,"Input number "+x));

		}
		int numStore, element, temp;
		int size = num.length; 
        System.out.print("\n");
		for (int x=0; x<(size-1); x++)
		{
			numStore=num[x];
			element=x;
			
			for (int y=(x+1); y<(size); y++)
			{
				if (numStore>=num[y])
				{
					element=y;
					numStore=num[y];
				}
			}
			
			temp=num[x];
			num[x]=num[element];
            num[element]=temp;


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
