package solutions;

import java.util.Stack;

public class p739 {
    public static int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int oIndex = 1; oIndex < output.length; oIndex++) {
            while (!stack.empty() && T[oIndex] > T[stack.peek()]) {
                output[stack.peek()] = oIndex - stack.pop();
            }
            stack.push(oIndex);
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
