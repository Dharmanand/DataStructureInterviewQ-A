package ds.list;

public class LinkedList {

	private Node head;

	public void insert(Integer value) {
		Node node = new Node();
		node.data = value;
		Node n = head;
		if (n == null) {
			head = node;
		} else {
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void showData() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public Integer deleteAtIndex(int i) {
		if(i < 0)
			throw new RuntimeException("Index should not be negative.");
		if(i > size()-1)
			throw new RuntimeException("Index should be less than : "+size());
		Node n = head;
		Node temp;
		if (i == 0) {
			temp = head;
			head = head.next;
		}
		else {
			while (--i > 0)
				n = n.next;
			temp = n.next;
		}
		n.next = n.next.next;
		return temp.data;
	}

	public int size() {
		int i = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(50);
		list.insert(30);
		list.insert(90);
		list.showData();
		System.out.println("-----");
		System.out.println(list.deleteAtIndex(4));
		System.out.println("-----");
		list.showData();
	}

}
