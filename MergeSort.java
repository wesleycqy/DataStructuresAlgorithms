class MergeSort { 

    private static int[] mergeSort(int A[]) 
    { 
        if (A.length<=1)
        {
            return A;
        }
        int midpoint = A.length/2;
        int[] L = new int[midpoint];
        int[] R;
        if (A.length % 2 ==0){
            R=new int[midpoint];}
        else{
            R = new int[midpoint+1];}


        for(int i=0; i<midpoint; i++){
            L[i]=A[i];
        }
        for(int j=0; j<R.length; j++){
            R[j]=A[midpoint+j];
        }

        int[] result =new int[A.length];

        L = mergeSort(L);
        R = mergeSort(R);
        result = merge(L,R);

        return result;



    } 
  
    private static int[] merge(int[] L, int[] R)
    {

        int[] result = new int[L.length + R.length];

        int LPointer=0;
        int RPointer=0;
        int resultPointer=0;

        while (LPointer < L.length || RPointer < R.length) {
            if (LPointer < L.length && RPointer < R.length) {
                if (L[LPointer] <= R[RPointer])
                   {result[resultPointer++] = L[LPointer++];}
                else
                    {result[resultPointer++] = R[RPointer++];}
            } 
            else if (LPointer < L.length)
                {result[resultPointer++] = L[LPointer++];}
            else if (RPointer < R.length)
                {result[resultPointer++] = R[RPointer++];}
        }
        return result;

    } 
  
    public static void main(String args[]) 
    { 
        int A[] = { 12, 11, 13, 5, 6, 7 }; 
        int size = A.length; 
        
        System.out.print("\nArray Before:\t"); 
        for (int i = 0; i < size; ++i) 
            System.out.print(A[i] + "\t"); 
        System.out.println(); 
        
        A=mergeSort(A);
  
        System.out.print("\nArray Sorted:\t"); 
        for (int i = 0; i < size; ++i) 
            System.out.print(A[i] + "\t"); 
        System.out.println("\n"); 
    } 
} 