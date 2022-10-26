import java.util.Arrays;

public class MergeSort {
    /*
     * ฟังก์ชันนี้จะรวม array สองฝั่งเข้าก้วยกันโดยจะค่อยๆ
     * ไหลไปบนสมาชิกแต่ละตัวแล้วทั้งสองฝั่งแล้วเทียบกันว่าอันไหนใหญ่กว่ากัน
     * ถ้าใหญ่กว่าก็ไม่ต้องเอาใส่ใน array ใหม่แต่ถ้าไม่ก็เอาใส่ สุดท้ายผลรวมจะได้
     * array ที่เรียงจากเล็กไปใหญ่
     */
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int left_idx = 0, right_idx = 0, result_idx = 0;
        while (left_idx < left.length && right_idx < right.length) {
            if (left[left_idx] <= right[right_idx]) {
                result[result_idx] = left[left_idx];
                left_idx++;
            } else {
                result[result_idx] = right[right_idx];
                right_idx++;
            }
            result_idx++;
        }
        while (left_idx < left.length) {
            result[result_idx] = left[left_idx];
            left_idx++;
            result_idx++;
        }
        while (right_idx < left.length) {
            result[result_idx] = right[right_idx];
            right_idx++;
            result_idx++;
        }
        return result;
    }

    /*
     * merge sort เป็นอัลกอริถึมการเรียงตัวเลขแบบหนึ่ง มีหัวใจในการทำงานคล้ายกับ
     * binary search ที่มีพฤติกรรมเป็น o(log n) โดย merge sort จะแบ่ง array
     * ออกเป็นสองซีกไปเรื่อยๆ จนแบ่งไม่ได้แล้วค่อยๆเรียงจากตัวเล็กๆ
     * ขึ้นมาซึ่งการทำงานนี้จะแบ่ง array เสมอไม่มีจุดที่หยุดแน่งจากจะต้องแบ่งจนเป็น
     * atomic และหลังจากนั้นจะค่อยๆสร้าง array ใหม่ขึ้นมาจากการวนบนข้อมูลที่แบ่ง
     * ซึ่งสามารถสรุปได้ว่า mergeSort (nlog n)
     * และจะไม่มีจุดหยุดก่อนดังนั้นพฤติกรรมที่ได้จะเท่ากับ theta(nlog n)
     */
    static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;

        int[] left = new int[array.length / 2],
                right = new int[array.length / 2];
        int left_idx = 0,
                right_idx = 0;
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length / 2) {
                left[left_idx] = array[i];
                left_idx++;
            } else {
                right[right_idx] = array[i];
                right_idx++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 2, 1, 4 };
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergeSort(array)));
    }
}
