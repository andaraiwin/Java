import java.util.Arrays;

public class BubbaSort { // in memories of bubba gump
    /*
     * สลับตำแหน่งข้อมูลใน array
     */
    static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    /*
     * ฟังก์ชันนี้จะเรียงข้อมูลใน array โดยจะเรียงลำดับจากน้อยไปมาก
     * ซึ่งจะเริ่มทำงานโดยใช้สมาชิกแรก และเปรียบเทียบกับสมาชิกตัวถัดไปเรื่อยๆ
     * กล่าวคือ จะสมาชิกตัวปัจจุบันไปเปรียบเทียบกับตัวหลังทุกตัว
     * ซึ่งถ้าสมาชิกตัวปัจจุบันมากกว่าตัวถัดไปจะทำการสลับตำแหน่งกัน
     * และมีการตรวจสอบตลอดด้วยว่ามันเรียงหมดละยัง ถ้าเรียกหมดค่อยหยุด
     * ดังนั้นมันจะเป็น theta(n^2) ไม่ได้แต่จะเป็น o(n^2) แทน
     */
    static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 3, 2, 1, 4 };
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
}
