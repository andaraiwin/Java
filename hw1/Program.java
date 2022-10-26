class Program {
    /*
     * โปรแกรมนี้จะนิยามฟังก์ชั่น where ขึ้นมา
     * โดยฟังก์ชั่นนี้จะเอาไปหาสามาชิกตัวหนึ่งใน Array data
     * โดยสมาชิกนั้นต้องมีค่าเท่ากับ look_for
     * ถ้าหากเจอจะคืนค่าตำแหน่งของสมาชิกตัวนั้น
     * แต่ถ้าไม่เจอจะคืนค่า -1 โดย Complexity ของมันจะเป็น n เมื่อไม่เจอสมาชิกใด
     * และจะไป 1 เมื่อสมาชิกที่ตามหาอยู่ตัวแรก ดังนั้นฟังก์ชั่นนี้จะมีคุณสมบัติ O(n)
     */
    public static int where(int[] data, int look_for) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == look_for)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4 };
        System.out.println(where(x, 2));
        System.out.println(where(x, 5));
    }
}