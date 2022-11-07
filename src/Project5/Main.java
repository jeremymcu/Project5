package Project5;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    void bubbleSort(int[] nums, int len){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int num : nums){
            stack1.push(num);
        }

        for (int i=0; i<len-1; i+=1){
            stack2.push(stack1.pop());
            for (int j=0; j<len-i-1; j+=1){
                while(!stack1.isEmpty()){
                    if(stack1.peek()>stack2.peek()){
                        stack2.push(stack1.pop());
                    }
                    else{
                        int temp = stack2.pop();
                        stack2.push(stack1.pop());
                        stack2.push(temp);
                    }
                }
            }
            stack1.push(stack2.pop());

            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        int i=0;
        while (!stack1.isEmpty()){
            nums[i] = stack1.pop();
            i+=1;
        }
    }
    public static void main(String[] args) {
        int[] num = {21, 48, 17, 64, 99, 420, 54, 354, 1, 51};
        Main sort = new Main();
        sort.bubbleSort(num, num.length);
        System.out.println(Arrays.toString(num));
    }
}
