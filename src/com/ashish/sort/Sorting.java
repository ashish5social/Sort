package com.ashish.sort;

public class Sorting {

	public static void bubbleSort(int[] input) {
		for(int i=0; i<input.length; i++) {
			for (int j = 0; j< input.length-1-i; j++) {
				if(input[j]>input[j+1]) {
					int temp = input[j]; 
					input[j] = input[j+1]; 
					input[j+1] = temp; 
				}
			}
		}
	}
	

	public static void quickSort(int[] input) {
		quickSortUtil(input, 0, input.length-1); 
	}
	
	private static void quickSortUtil(int[] input, int low, int high) {
		if(low < high) {
		int pivot = partition(input, low, high); 
		quickSortUtil(input, low, pivot-1);
		quickSortUtil(input, pivot+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		//lets say arr is 1 2 5 3 low=0 high=3
		int pivot = arr[high]; //3
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                int temp = arr[low]; 
                arr[low] = arr[j]; 
                arr[j] = temp;
                low++; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[low]; 
        arr[low] = arr[high]; 
        arr[high] = temp; 
  
        return low; 
	}


	public static void main(String[] args) {
		int[] input = {4, 2, 8, 2, 7, 6, 5}; 
		System.out.println("Before sort "+input);
		mergeSort(input);
		System.out.println("After sort "+input);
	}


	private static void mergeSort(int[] input) {
		mergeSort(input, 0, input.length-1); 
		
	}
	
	static void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }


	private static void merge(int[] arr, int l, int m, int r) {
		 // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
        	//We have created two temp arrays 1 from l to m and another from m+1 to r
        	//i is pointing to start in L and j in R and k in actual array where sorted data is getting place
        	//Put lower amongst L and R to arr[k] 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++;  // if L was smaller, copy L[i] to arr[k] then increase i
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            //in any case increase k
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
		
	} 
	
}
