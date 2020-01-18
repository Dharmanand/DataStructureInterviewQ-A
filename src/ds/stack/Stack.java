package ds.stack;

import java.util.Arrays;

public class Stack {

	private final static float loadFactor = 0.75f;
	private final static int defaultCapacity = 5;
	private int capacity = defaultCapacity;
	private int top = -1;
	private int[] stack = new int[capacity];

	public void push(int data) {
		expand();
		stack[++top] = data;
	}

	public int pop() {
		if (top == -1)
			throw new RuntimeException("Stack is empty.");
		int popVal = stack[top];
		stack[top--] = 0;
		shrink();
		return popVal;
	}

	private void shrink() {
		if (size() <= capacity / 4) {
			capacity = capacity / 2;
			if (capacity < defaultCapacity)
				capacity = defaultCapacity;
			int[] newStackArr = new int[capacity];
			System.arraycopy(stack, 0, newStackArr, 0, size());
		}
	}

	public int peek() {
		if (top == -1)
			throw new RuntimeException("Stack is empty.");
		return stack[top];
	}

	public int size() {
		return top + 1;
	}

	public void expand() {
		if ((float) size() / (float) capacity >= loadFactor) {
			capacity = capacity * 2;
			stack = Arrays.copyOf(stack, capacity);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println("size: " + stack.size());
		System.out.println("capacity: " + stack.capacity);
		stack.push(10);
		stack.push(20);
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(35);
		stack.push(35);
		stack.push(35);
		stack.push(35);
		stack.push(35);
		stack.push(35);
		System.out.println("size: " + stack.size());
		System.out.println("capacity: " + stack.capacity);
		System.out.println(stack.pop());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("size: " + stack.size());
		System.out.println("capacity: " + stack.capacity);
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("size: " + stack.size());
		System.out.println("capacity: " + stack.capacity);
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println("size: " + stack.size());
		System.out.println("capacity: " + stack.capacity);
	}
}
