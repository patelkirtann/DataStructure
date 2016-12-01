import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kt_ki on 11/26/2016.
 */
public class StackStructure {
    private int[] stackLength;
    private static int stackSize;

    private static int topOfStack = -1;

    private StackStructure(int size) {
        stackSize = size;
        stackLength = new int[size];

        Arrays.fill(stackLength, 0);
    }

    private void push(int value) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackLength[topOfStack] = value;
        } else {
            System.out.println("Stack is Full ");
        }
        printStack();
    }

    private void pop() {
        if (topOfStack >= 0) {
            System.out.println("POPed out value " + stackLength[topOfStack] + " at index [" + topOfStack + "]");
            stackLength[topOfStack] = 0;
            topOfStack--;
        } else {
            System.out.println("Stack is Empty");
        }
        printStack();
    }

    private void peek() {
        if (topOfStack >= 0) {
            System.out.println("Top of the stack value is " + stackLength[topOfStack]);
        }else {
            System.out.println("Stack is Empty");
        }
    }

    private void printStack() {
        System.out.print("index[] : ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print("  " + i + "  ");
        }
        System.out.println();
        System.out.print("Value   :  ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print(" " + stackLength[i] + "   ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Stack Size:");
        int size = sc.nextInt();
        StackStructure stackStructure = new StackStructure(size);

        System.out.println("Empty Stack Created:");
        stackStructure.printStack();

        while (topOfStack <= stackSize) {
            System.out.println(" 1. Push \n 2. Pop \n 3. peek \n 4. Exit");
            System.out.print("Enter choice: ");
            int option = sc.nextInt();
            int value;

            switch (option) {
                case 1:
                    System.out.print("Enter Value to Push:");
                    value = sc.nextInt();
                    stackStructure.push(value);
                    break;
                case 2:
                    stackStructure.pop();
                    break;
                case 3:
                    stackStructure.peek();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Enter Valid choice");
                    break;
            }
        }
    }
}
