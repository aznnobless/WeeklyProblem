package basic;

/*
 *  Size 변수로 empty state 표현
 */

public class MyQueue {

    private  int[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue(int k)
    {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value)
    {
        if (isFull() == true) return false;
        if (isEmpty() == true) head = 0;

        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue()
    {
        if (isEmpty() == true) return false;

        // case: only one element in array and we are going to delete that guy
        if (head == tail)
        {
            head = -1;
            tail = -1;
            return true;
        }

        head = (head + 1) % size;
        return true;
    }

    public int front()
    {
        if (isEmpty()) return -1;

        return data[head];
    }

    public int rear()
    {
        if (isEmpty()) return -1;

        return data[tail];
    }


    public boolean isFull()
    {
        return (tail + 1 % size) == head;
    }

    public boolean isEmpty()
    {
        return head == -1;
    }

    public static void main(String[] args)
    {
        MyQueue p = new MyQueue(3);
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
