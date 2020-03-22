package com.basic.sort;

/**
 * 堆排序
 * 空间复杂度O(1)
 * 大根堆：树的头节点是最大值（比左右子节点大），树的子树的最大值也是头节点
 * 节点的左子节点：2*i+1，右子节点：2*i+2，节点的父节点：（i-1）/2
 * 建立大根堆：将数组映射为树，若当前节点的值比父节点大，则交换当前节点和父节点的值，最后达到父节点（包括每棵子树）比子节点大
 * <p>
 * 排序：建立起大根堆后，堆顶（第一个数）为最大的值，与堆底（最后一个数）交换，堆的size-1，就是将最后一个数排除在堆外，剩下的继续建立大根堆，以此类推
 *
 * 先将数组建成大根堆，再将大根堆的堆顶（最大的数）拿出，再建立大根堆，依次拿出堆顶最大的值，进行排序
 * 建立大根堆还可以做别的操作，找到数组最大值、并删掉它……
 * 建立大根堆：O(N)
 *
 * 不稳定，常数项较大
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        // 先将第一个排好的大根堆，堆顶堆底互换，堆的size-1
        swap(arr, 0, --heapSize);
        // 当堆里还有元素时
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }
    // 建立大根堆：如果当前节点比父节点大，则交换，交换后继续与父节点比较

    static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 从数组的0下标开始，与子节点比较，如果小于子节点，交换
    static void heapify(int[] arr, int index, int heapSize) {
        // 左子节点
        int left = 2 * index + 1;
        while (left < heapSize) {
            // 左子节点和右子节点决胜负
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // index与上一行胜出子节点比较大小
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            // 上一步if没有break说明largest不等于index，也就是子节点，交换堆顶与这个子节点的元素
            swap(arr, largest, index);
            // index 成为子节点的下标继续向下比较
            index = largest;
            left = 2 * index + 1;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 0, 6, 3, 2, 7};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
