package p338;

public class Solution {

    public static void main(String[] args) {
        int[] result = countBits(5);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] countBits(int num) {

        int[] result = new int[num+1];

        for (int i = 0; i <= num; i++) {
            if(i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[(i - 1)/2] + 1;
            }
        }

        return result;
    }
}
