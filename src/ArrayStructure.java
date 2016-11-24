import java.util.Scanner;

/**
 * Created by kt_ki on 11/24/2016.
 */
public class ArrayStructure {

    private static Scanner sc = new Scanner(System.in);
    private int[] totalArray = new int[50];
    private static int arrayLength;

    private void setArrayLength() {
        System.out.print("Set Array Length (Length<50):");
        arrayLength = sc.nextInt();
    }

    private void generateRandomArray() {
        if (arrayLength < 50) {
            for (int i = 0; i < arrayLength; i++) {
                totalArray[i] = (int) (Math.random() * 10);
                System.out.println("index [" + i + "]: " + totalArray[i]);
            }
        } else {
            System.out.println("Put the valid amount");
            setArrayLength();
        }
    }

    private void printArray() {
        System.out.println("New Array :");
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("index [" + i + "]: " + totalArray[i]);
        }
    }

    private void getIndexValue(int index) {
        if (index < arrayLength) {
            System.out.println("Value at index[" + index + "] is " + totalArray[index]);
        } else {
            System.out.println("Wrong index Value");
        }
    }

    private void searchValue(int value) {
        int valueFound = -1;
        for (int i = 0; i < arrayLength; i++) {
            if (totalArray[i] == value) {
                valueFound = i;
                System.out.println("Found " + value + " at index[" + i + "]");
            }
        }
        if (valueFound == -1) {
            System.out.println("Not Found");
        }
    }

    private boolean hasValue(int value){
        boolean val = false;
        for (int i = 0; i < arrayLength; i++) {
            if (totalArray[i] == value){
                val = true;
            }
        }
        return val;
    }

    private void deleteValueAtIndex(int index) {
        if (index < arrayLength) {
            for (int i = index; i < arrayLength - 1; i++) {
                totalArray[i] = totalArray[i + 1];
            }
            arrayLength--;
        }
        printArray();
    }

    public void insertValue(int value) {
        if (arrayLength < 50) {
            totalArray[arrayLength] = value;
            arrayLength++;
        }
        printArray();
    }

    private void switchCase() {
        System.out.println(" 1. Insert into Array \n 2. Search Value \n 3. Get Index Value \n 4. Delete Index \n" +
                " 5. Check available value \n 6. Exit \n ");
        System.out.print("Enter the choice number: ");
        int choice = sc.nextInt();
        int value;
        switch (choice) {
            case 1:
                System.out.print("Enter value to insert:");
                value = sc.nextInt();
                insertValue(value);
                break;
            case 2:
                System.out.print("Enter Value to search:");
                value = sc.nextInt();
                searchValue(value);
                break;
            case 3:
                System.out.print("Enter Index to get Value:");
                value = sc.nextInt();
                getIndexValue(value);
                break;
            case 4:
                System.out.print("Enter Index to be Deleted:");
                value = sc.nextInt();
                deleteValueAtIndex(value);
                break;
            case 5:
                System.out.print("Enter Value to check the availability:");
                value = sc.nextInt();
                hasValue(value);
            case 6:
                System.exit(0);
            default:
                System.out.println("Enter Proper Option");
                break;
        }
    }


    public static void main(String[] args) {
        ArrayStructure arrayStructure = new ArrayStructure();
        arrayStructure.setArrayLength();
        arrayStructure.generateRandomArray();

        while (arrayLength < 50){
            arrayStructure.switchCase();
        }
    }
}
