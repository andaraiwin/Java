import java.util.Arrays;

public class SelectionSort {
    /*
     * สลับตำแหน่งข้อมูลใน array
     */
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
     * ฟังก์ชันนี้จะเรียงข้อมูลใน array โดยจะเรียงลำดับจากน้อยไปมาก
     * ซึ่งจะเริ่มทำงานโดยใช้สมาชิกแรก และเปรียบเทียบกับสมาชิกตัวถัดไปเรื่อยๆ
     * กล่าวคือ จะสมาชิกตัวปัจจุบันไปเปรียบเทียบกับตัวหลังทุกตัว
     * ซึ่งถ้าสมาชิกตัวปัจจุบันมากกว่าตัวถัดไปจะทำการสลับตำแหน่งกัน
     * โดยเมื่อทำครบแล้วผลลัพธ์สุดท้ายจะได้สมาชิกตัวใหญ่ที่สุดอยู่หลัง
     * และตัวเล็กที่สุุดอยู่หน้า ซึ่งพฤติกรรม theta(n^2)
     * นั้นมาจากการที่วนกันสองชั้นโดยชั้นแรกจะเป็นการวนกับสมาชิกทั้งหมด
     * และการทุกการวนขั้นแรกก็จะมีการวนกับสมาชิกตัวถัดไปทั้งหมด ดังนั้น o=omega
     * จึงสรุปได้ว่า selectionSort เป็น theta(n^2)
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int smallest_idx = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[smallest_idx] > array[j])
                    smallest_idx = j;

            }
            if (smallest_idx != i)
                swap(array, smallest_idx, i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 2, 1, 4 };
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
