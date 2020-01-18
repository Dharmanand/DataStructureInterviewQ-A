package ds.stack;

import java.util.Arrays;

public class Stack {

	private float loadFactor = 0.75f;
	private int top = -1;
	private int[] stack = new int[5];

	public void push(int data) {
		reSize();
		stack[++top] = data;
	}

	public int pop() {
		if(top == -1)
			throw new RuntimeException("Stack is empty.");
		int popVal = stack[top];
		stack[top--] = 0;
		return popVal;
	}

	public int size() {
		return top + 1;
	}

	public void reSize() {
		if ((float) size()/(float) stack.length >= loadFactor)
			stack = Arrays.copyOf(stack, stack.length * 2);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.size());
		stack.push(10);
		stack.push(20);
		stack.push(15);
		stack.push(25);
		stack.push(35);
		System.out.println(stack.size());
		System.out.println(stack.pop());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.size());
	}
}
