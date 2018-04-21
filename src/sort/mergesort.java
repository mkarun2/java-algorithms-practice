package sort;

import java.util.Arrays;

public class mergesort {
    public void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public void merge(int a[], int low, int mid, int high) {
        int helper[] = new int[a.length];
        for (int i = low; i <= high; i++) {
            helper[i] = a[i];
        }
        int k = low;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if(helper[left] <= helper[right]) {
                a[k] = helper[left++];
            } else {
                a[k] = helper[right++];
            }
            k++;
        }

        while (left <= mid) {
            a[k++] = helper[left++];
        }
    }

    public static void main(String args[]) {
        mergesort q = new mergesort();
        int a[] = new int[]{4, 6, 1, 9, 190, 23};
        System.out.println(Arrays.toString(a));
        q.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
