import java.util.Arrays;

/**
 * Created by kt_ki on 12/4/2016.
 */
public class QueueStructure {

    private int[] queueLength;
    private int queueSize;

    private int front, rear, totalItems;

    QueueStructure(int size) {
        queueSize = size;
        queueLength = new int[size];

        Arrays.fill(queueLength, 0);
    }

    private void insert(int value) {
        if (totalItems < queueSize) {
            queueLength[rear] = value;
            rear++;
            totalItems++;
            System.out.println(value + " added at index[" + rear + "]");
        } else {
            System.out.println("Queue is full.");
        }
    }

    private void remove() {
        if (totalItems > 0) {
            System.out.println(queueLength[front] + " is removed.");
            queueLength[front] = 0;
            front++;
            totalItems--;
        } else {
            System.out.println("The Queue is Empty.");
        }
    }

    private void peek() {
        System.out.println("The first Element is " + queueLength[front]);
    }

    private void printQueue() {
        System.out.print("index[] : ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print("  " + i + "  ");
        }
        System.out.println();
        System.out.print("Value   :  ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print(" " + queueLength[i] + "   ");
        }
        System.out.println();
    }

    private void priorityQueue(int value) {
        int i;
        if (totalItems == 0) {
            insert(value);
        } else {
            for (i = totalItems - 1; i >= 0; i--) {
                if (value > queueLength[i]) {
                    queueLength[i + 1] = queueLength[i];
                } else break;
            }
            queueLength[i + 1] = value;
            rear++;
            totalItems++;
        }
    }

    public static void main(String[] args) {
        QueueStructure qs = new QueueStructure(10);

        qs.peek();
        qs.printQueue();

        qs.priorityQueue(52);
        qs.priorityQueue(53);
        qs.priorityQueue(20);
        qs.priorityQueue(60);

        qs.peek();
        qs.printQueue();
    }
}
