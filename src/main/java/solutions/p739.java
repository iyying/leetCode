package solutions;

public class p739 {
    public static int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];

        for (int oIndex = 0; oIndex < output.length; oIndex++) {
            int num = 0;
            for (int iIndex = oIndex + 1; iIndex < T.length; iIndex++) {

                num++;

                if(T[oIndex] < T[iIndex]) {
                    break;
                }

                if(iIndex == output.length - 1) {
                    num = 0;
                }
            }
            output[oIndex] = num;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] output = dailyTemperatures(input);
        for (int i : output) {
            System.out.print(i+", ");
        }
    }
}
