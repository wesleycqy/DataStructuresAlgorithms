import javax.swing.JOptionPane;

public class QuickSort 
{ 

    int partition(int A[], int p, int r) 
    { 
        int x = A[r];  
        int i = p-1; 
        for (int j=p; j<=r-1; j++) 
        { 
            if (A[j] <= x) 
            { 
                i = i+1; 
                int temp = A[j]; 
                A[j] = A[i]; 
                A[i] = temp; 
            } 
        } 
        int temp = A[r]; 
        A[r] = A[i+1]; 
        A[i+1] = temp; 
  
        return (i+1); 
    } 
  
  
    void QuickSort(int A[], int p, int r) 
    { 
        if (p < r) 
        { 
            int q = partition(A, p, r); 
            QuickSort(A, p, q-1); 
            QuickSort(A, q+1, r); 
        } 
        int size = A.length; 
        System.out.println("");
        for (int v=0;v<size;v++)
        {
            System.out.print(A[v]+"\t");
        }
        System.out.print("");
    } 
  
    
  
    public static void main(String args[]) 
    { 
        int A[] = {2,8,7,1,3,5,6,4,1,8}; 
        int size = A.length; 
  
        QuickSort array = new QuickSort(); 
        array.QuickSort(A, 0, size-1); 
  
        System.out.print("\n\nSorted Array: \t"); 
        for (int v=0;v<size;v++)
        {
            System.out.print(A[v]+"\t");
        }
        System.out.print("");
    } 
} 