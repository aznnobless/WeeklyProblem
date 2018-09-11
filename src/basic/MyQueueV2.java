package basic;

/*
 * Array Size 를 k+1개로 잡아서 empty state 표현
 */

public class MyQueueV2
{

    private  int[] data;
    private int head;
    private int tail;
    private int capacity;

    public MyQueueV2(int k)
    {
        capacity = k + 1; // to figure out empty state, set capacity k + 1
        tail = 0;
        head = 1; // head is one slot ahead of back
        data = new int[capacity];
    }

    public boolean enQueue(int value)
    {
        if(isFull()) return false;
        tail = (tail + 1) % capacity;
        data[tail] = value;
        return true;
    }

    public boolean deQueue()
    {
        if(isEmpty()) return false;
        head = (head + 1) % capacity;
        return true;
    }

    public int front()
    {
        if (isEmpty()) return - 1;

        return data[head];
    }

    public int rear()
    {
        if (isEmpty()) return - 1;

        return data[tail];
    }


    public boolean isFull()
    {
        return (tail+2) % capacity == head; // OR length() - 1;
    }

    public boolean isEmpty()
    {
        return length() == 0;
    }

    public int length()
    {
        return ((tail + capacity) - head + 1) % capacity;
    }


    public static void main(String[] args)
    {
        MyQueueV2 p = new MyQueueV2(3);
        System.out.println(p.enQueue(1)); //true
        System.out.println(p.enQueue(2)); // true
        System.out.println(p.enQueue(3)); // true
        System.out.println(p.enQueue(4)); // false
        System.out.println(p.rear());  // return 3
        System.out.println(p.isFull());  // return true
        System.out.println(p.deQueue());  // return true
        System.out.println(p.enQueue(4));  // return true
        System.out.println(p.rear());  // return 4
    }
}
