import java.io.*;
import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        int cont = 1;
        int choice = 0;


        Scanner scan = new Scanner(System.in);
        while (cont == 1) {
            System.out.println("1.MERGE SORT");
            System.out.println("2.HEAP SORT");
            System.out.println("3.QUICK SORT REGULAR METHOD");
            System.out.println("4.QUICK SORT 3-MEDIAN METHOD");
            System.out.println("5.INSERTION SORT");
            System.out.println("6.SELECTION SORT");
            System.out.println("7.BUBBLE SORT");
            System.out.println("ENTER YOUR CHOICE: ");
            choice = scan.nextInt();
            /*
            System.out.println("ENTER THE NUMBER OF INPUTS YOU WANT GIVE: ");
            int number_of_inputs = scan.nextInt();
            int array[] = new int[number_of_inputs];
            System.out.print("ENTER YOUR " + number_of_inputs + " NUMBERS FOR SORTING:");
            for (int i = 0; i < number_of_inputs; i++) {
                array[i] = scan.nextInt();
            }*/

            System.out.println("ENTER THE NUMBER OF INPUTS YOU WANT GIVE: ");
            int number_of_inputs = scan.nextInt();
            Random random= new Random();
            int array[]= new int[number_of_inputs];
            for(int i=0;i < number_of_inputs; i++)
            {
                array[i]=random.nextInt(1000);
            }

            System.out.println("----------------ARRAY BEFORE SORTING---------------");
            print_array(array);

            switch (choice) {
                case 1:
                    long start_time= System.nanoTime();
                    merge_sort(array, 0, array.length-1);
                    long stop_time= System.nanoTime();
                    long total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for Merge sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;



                case 2:
                    start_time= System.nanoTime();
                    heap_sort(array);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for heap sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;


                case 3:
                    start_time= System.nanoTime();
                    recursive_QuickSort(array, 0, array.length - 1);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for Quick sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;


                case 4:
                    start_time= System.nanoTime();
                    quick_sort3(array,0,array.length-1);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for 3-median Quick sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;



                case 5:
                    start_time= System.nanoTime();
                    insertion_sort(array);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for Insertion sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;


                case 6:
                    start_time= System.nanoTime();
                    selection_sort(array);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for Selection sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;



                case 7:
                    start_time= System.nanoTime();
                    bubble_sort(array);
                    stop_time= System.nanoTime();
                    total_time= stop_time-start_time;

                    System.out.println("----------------ARRAY AFTER SORTING---------------");
                    print_array(array);
                    System.out.println("Time taken for bubble sort : "+total_time);
                    System.out.println("Do you wish to continue [1= Continue/0= Exit]: ");
                    cont = scan.nextInt();
                    break;

                default:
                    System.out.println("INVALID CHOICE");


            }
        }


    }

    static void print_array(int[] arr) {

        for(int i1=0; i1<arr.length; i1++) {
            System.out.print(arr[i1] + "\t");

        }
        System.out.println(" ");
    }

    static void swap(int array[],int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    static void merge(int array[], int first, int middle, int last) {
        int first_subarray_lenth = middle - first + 1;
        int second_subarray_length = last - middle;

        int first_subarray[] = new int[first_subarray_lenth];
        int second_subarray[] = new int[second_subarray_length];


        int i2=0, i6=0;
        while (i2 < first_subarray_lenth)   {
            first_subarray[i2] = array[first + i2];
            i2++;
        }
        while(i6 < second_subarray_length){
            second_subarray[i6] = array[middle + i6 + 1];
            i6++;
        }


        int i5 = first;
        int i3 = 0, i4=0;
        while (i3 < first_subarray_lenth && i4 < second_subarray_length) {
            if (first_subarray[i3] <= second_subarray[i4]) {
                array[i5] = first_subarray[i3];
                i3++;
                i5++;
            } else {
                array[i5] = second_subarray[i4];
                i4++;
                i5++;
            }

        }

        while (i3 < first_subarray_lenth) {
            array[i5] = first_subarray[i3];
            i3++;
            i5++;
        }

        while (i4 < second_subarray_length) {
            array[i5] = second_subarray[i4];
            i4++;
            i5++;
        }
    }



    static void merge_sort(int array[], int first, int last) {

        if (first < last) {

            int middle = (first + last) / 2;

            merge_sort(array, first, middle);
            merge_sort(array,middle + 1, last);


            merge(array, first, middle, last);
        }


    }

    static void heap_sort(int array[])
    {
        int k;

        build_heap(array);

        for( k=(array.length)-1; k>0;)
        {
            swap(array,0,k);
            heapify(array,0,k--) ;

        }

    }


    static void build_heap(int array[])
    {
        int length=array.length;
        for(int i11=(length/2)-1;i11>=0;i11--)
        {
            heapify(array,i11,length);
        }

    }


    static void heapify(int array[],int j,int m)
    {

        int left=2*j+1;
        int right=2*j+2;

        int large;

        if(left<m && array[left]>array[j])
        {
            large=left;
        }
        else {
            large = j;
        }
        if(right<m && array[right]>array[large])
        {
            large=right;
        }

        if(large!=j)
        {
            swap(array,large,j);
            heapify(array,large,m);
        }


    }



    static void recursive_QuickSort(int[] array, int first, int last) {
        int position  = partition_quicksort(array, first, last);
        if (first < position  - 1) {

            recursive_QuickSort(array, first, position  - 1);
        }

        if (last > position ) {
            recursive_QuickSort(array, position , last);
        }

    }

    static int partition_quicksort(int[] array, int first, int last) {
        int pivot = array[first];
        while (first <= last) {
            while (array[first] < pivot) {
                first++;
            }

            while (array[last] > pivot) {
                last--;
            }

            if (first <= last) {
                swap(array, first, last);
                first++;
                last--;
            }
        }
        return first;
    }
    public static void quick_sort3(int[] array, int first, int last) {
        int size = last - first + 1;
        if (size <= 3)
            Sort_quick(array, first, last);
        else {
            double median = three_median(array, first, last);
            int partition = partition_quicksort3(array, first, last, median);
            quick_sort3(array, first, partition - 1);
            quick_sort3(array, partition + 1, last);
        }
    }

    public static int three_median(int[] array, int first, int last) {
        int center = (first + last) / 2;

        if (array[first] > array[center])
            swap(array, first, center);

        if (array[first] > array[last])
            swap(array, first, last);

        if (array[center] > array[last])
            swap(array, center, last);

        swap(array, center, last - 1);
        return array[last - 1];
    }



    public static int partition_quicksort3(int[] array, int first, int last, double pivot) {
        int leftPtr = first;
        int rightPtr = last - 1;

        while (true) {
            while (array[++leftPtr] < pivot)
                ;
            while (array[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr, rightPtr);
        }
        swap(array, leftPtr, last - 1);
        return leftPtr;
    }

    public static void Sort_quick(int[] array, int first, int last) {
        int size = last - first + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (array[first] > array[last])
                swap(array, first, last);
            return;
        } else {
            if (array[first] > array[last - 1])
                swap(array, first, last - 1);
            if (array[first] > array[last])
                swap(array, first, last);
            if (array[last - 1] > array[last])
                swap(array, last - 1, last);
        }
    }

    static void insertion_sort(int array[])
    {
        int length= array.length;
        for (int i6 = 0; i6 < length; i6++) {
            int position = array[i6];
            int i7 = i6 - 1;

            while (i7 >= 0 && array[i7] > position) {
                array[i7 + 1] = array[i7];
                i7--;
            }
            array[i7 + 1] = position;
        }
    }


    static void selection_sort(int array[]) {
        int length = array.length;
        for (int i10 = 0; i10 < length - 1; i10++) {
            int minimum = i10;
            for (int k = i10 + 1; k <= length - 1; k++)
                if (array[k] < array[minimum])
                    minimum = k;
            swap(array, i10, minimum);


        }
    }


    static void bubble_sort(int array[]) {
        int length= array.length;

        for(int i8 = 0; i8 < length; i8++) {
            for(int i9=1; i9 < (length-i8); i9++) {
                if(array[i9-1] > array[i9]) {
                    swap(array,i9-1,i9);
                }
            }
        }
    }


}









