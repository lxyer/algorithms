package com.lxyer.algorithms.code;

/**
 * 循环队列
 * 可以充分利用数组的空间,还避免了数组元素整体移动的成本
 */
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element
     * @throws Exception
     */
    public void push(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int element = array[rear];
        front = (front + 1) % array.length;
        return element;
    }

}
