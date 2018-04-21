package sort;

import java.util.Arrays;
import java.util.Stack;

// put the pivot in its right place and sort the rest of the array
public class quicksort {
    private void sort(int a[], int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            sort(a, low, pivot - 1);
            sort(a, pivot + 1, high);
        }
    }

    private void iterativeSort(int a[], int low, int high) {
        Stack<Integer> st = new Stack<>();
        st.push(low);
        st.push(high);
        int pivot;

        while (!st.isEmpty()) {
            high = st.pop();
            low = st.pop();
            pivot = partition(a, low, high);
            if (pivot - 1 > low) {
                st.push(low);
                st.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                st.push(pivot + 1);
                st.push(high);
            }
        }
    }

    private void swap(int a[], int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    private int partition(int a[], int low, int high) {
        // last element as pivot
        int pivot = a[high];

        // move all elements lesser than the pivot to its correct location
        int curIndex = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i] < pivot) {
                curIndex++;
                swap(a, curIndex, i);
            }
        }

        // move pivot to its correct location
        swap(a, (curIndex + 1), high);
        return curIndex + 1;
    }

    public static void main(String args[]) {
        quicksort q = new quicksort();
        int a[] = new int[]{4, 6, 1, 9, 190, 23};
        System.out.println(Arrays.toString(a));
//        q.sort(a, 0, a.length - 1);
        q.iterativeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
