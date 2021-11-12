
public class MergeSort {
	public static void mergeSort(int[] arr,int si,int ei)
    {
        //int si=0;
        //int ei=arr.length-1;
        int mid =(si+ei)/2;
        if(si>=ei)
        {
            return;
        }
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,ei);
        
    }

    public static void merge(int[] arr,int si,int ei)
    {
        int mid=(si+ei)/2;
        int[] ans=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei)
        {
            if(arr[i]<arr[j])
            {
                ans[k]=arr[i];
                k++;i++;
            }
            else
            {
                ans[k]=arr[j];
                k++;j++;
            }
        }
        while(i<=mid)
        {
            ans[k]=arr[i];
            k++;i++;
        }
        while(j<=ei)
        {
            ans[k]=arr[j];
            k++;j++;
        }
        for(int index=0;index<ans.length;index++)
        {
            arr[si+index]=ans[index];
        }

    }

    public static void printarr(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr={8,2,5,1,5,7,3};
        mergeSort(arr,0,arr.length-1);
        printarr(arr);
    }
}
