import java.util.Scanner;

/**
 * Created by kt_ki on 11/24/2016.
 */
public class ArrayStructure {

    private static Scanner sc = new Scanner(System.in);
    private int[] arrayLength = new int[50];
    private static int arraySize;
    private boolean flag = false;
    private int counter = 0;

    private void setArrayLength() {
        System.out.print("Set Array Length (Length<50):");
        arraySize = sc.nextInt();
    }

    private void generateRandomArray() {
        if (arraySize < 50) {
            for (int i = 0; i < arraySize; i++) {
                arrayLength[i] = (int) (Math.random() * 10);
                System.out.println("index [" + i + "]: " + arrayLength[i]);
            }
        } else {
            System.out.println("Put the valid amount");
            setArrayLength();
        }
    }

    private void printArray() {
//        System.out.println("New Array :");
        System.out.print("index[] : ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.print("Value   : ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(arrayLength[i] + "   ");
        }
        System.out.println();
    }

    private void getIndexValue(int index) {
        if (index < arraySize) {
            System.out.println("Value at index[" + index + "] is " + arrayLength[index]);
        } else {
            System.out.println("Wrong index Value");
        }
    }

    private void linearSearchValue(int value) {
        int valueFound = -1;
        for (int i = 0; i < arraySize; i++) {
            counter++;
            if (arrayLength[i] == value) {
                valueFound = i;
                System.out.println("Found " + value + " at index[" + i + "]");
            }
        }
        if (valueFound == -1) {
            System.out.println("Not Found");
        }
        System.out.println("Total Iteration: " + counter);
        counter = 0;
    }

    private boolean hasValue(int value) {
        boolean val = false;
        for (int i = 0; i < arraySize; i++) {
            if (arrayLength[i] == value) {
                val = true;
                break;
            }
        }
        return val;
    }

    private void deleteValueAtIndex(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                arrayLength[i] = arrayLength[i + 1];
            }
            arraySize--;
        }
        printArray();
    }

    private void insertValue(int value) {
        if (arraySize < 50) {
            arrayLength[arraySize] = value;
            arraySize++;
        }
        printArray();
    }

    private void swapValue(int i, int j) {
        int temp = arrayLength[i];
        arrayLength[i] = arrayLength[j];
        arrayLength[j] = temp;
    }

    private void bubbleSort() {
        flag = true;
        for (int i = ArrayStructure.arraySize - 1; i > 1; i--) {
            counter++;
            for (int j = 0; j < i; j++) {
                counter++;
                if (arrayLength[j] > arrayLength[j + 1])
                    swapValue(j, j + 1);
            }
        }
        printArray();
        System.out.println("Total Iteration: " + counter);
        counter = 0;
    }

    private void selectionSort() {
        flag = true;

        for (int i = 0; i < arraySize; i++) {
            counter++;
            int min = i;
            for (int j = i; j < arraySize; j++) {
                if (arrayLength[min] > arrayLength[j]) {
                    min = j;
                    counter++;
                }
            }
            swapValue(i, min);
        }
        printArray();
        System.out.println("Total Iteration: " + counter);
        counter = 0;

    }

    private void insertionSort() {
        flag = true;
        for (int i = 0; i < arraySize; i++) {
            counter++;
            int j = i;
            int insertVal = arrayLength[i];

            while ((j > 0) && ((arrayLength[j - 1] > insertVal))) {
                arrayLength[j] = arrayLength[j - 1];
                j--;
                counter++;
            }
            arrayLength[j] = insertVal;
        }
        printArray();
        System.out.println("Total Iteration: " + counter);
        counter = 0;
    }

    // After shorting an Array
    private void binarySearchValue(int value) {
        if (flag) {
            int firstIndex = 0;
            int lastIndex = arraySize - 1;

            while (firstIndex <= lastIndex) {
                int middleIndex = (firstIndex + lastIndex) / 2;
                counter++;
                if (arrayLength[middleIndex] < value) {
                    firstIndex = middleIndex;
                } else if (arrayLength[middleIndex] > value) {
                    lastIndex = middleIndex;
                } else if (arrayLength[middleIndex] == value) {
                    System.out.println("Value " + value + " found at index[" + middleIndex + "]");
//                firstIndex = lastIndex;
                    break;
                }
                if (counter == lastIndex / 2) {
                    System.out.println("No value found");
                    break;
                }
            }
            System.out.println("Iteration: " + counter);
            counter = 0;
        } else {
            System.out.println("Message: Do Any Sorting first");
            switchCase();
        }
    }

    private void switchCase() {
        System.out.println(" 1. Insert into Array \n 2. Linear Search \n 3. Get Index Value \n 4. Delete Index \n" +
                " 5. Check available value \n 6. Bubble Sort \n 7. Selection Sort \n 8. Insertion Sort \n 9. Binary Search(works after sorting) \n" +
                "10. Exit \n ");
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
                System.out.print("Enter Value to search(Linear Search):");
                value = sc.nextInt();
                linearSearchValue(value);
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
                boolean val = hasValue(value);
                System.out.println(val);
                break;
            case 6:
                System.out.println("Bubble sorted Array:");
                bubbleSort();
                break;
            case 7:
                System.out.println("Selection Sorted Array:");
                selectionSort();
                break;
            case 8:
                System.out.println("Insertion Sorted Array:");
                insertionSort();
                break;
            case 9:
                System.out.print("Enter Value to search(Binary search):");
                value = sc.nextInt();
                binarySearchValue(value);
                break;
            case 10:
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

        while (arraySize < 50) {
            arrayStructure.switchCase();
        }

    }
}
