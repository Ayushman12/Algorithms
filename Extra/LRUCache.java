import java.util.*;

public class LRUCache<T> {
	private final int capacity;
	private int size;
	private Map<String,Node> hashmap;
	private DoublyLinkedList queue;
	LRUCache(final int capacity){
		this.capacity = capacity;
		this.hashmap = new HashMap<>();
		this.queue = new DoublyLinkedList();
		this.size = 0;
	}
	public T get(String key) {
		Node node = hashmap.get(key);
		if(node == null)
			return null;
		queue.moveToFront(node);
		return node.value;
	}
	public void put(String key,T value) {
		Node current = hashmap.get(key);
		if(current!=null) {
			current.value = value;
			queue.moveToFront(current);
			return;
		}
		if(size == capacity) {
			T rearkey = queue.removeRearNode();
			hashmap.remove(rearkey);
			size--;
		}
		Node node = new Node(key,value);
		queue.addToFront(node);
		hashmap.put(key, node);
		size++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cache capacity");
		final int n = sc.nextInt();
		LRUCache<Integer> ob = new LRUCache<>(n);
		int operation = 1;
		while(operation!=0) {
			System.out.println("1: Put\n2. Get\n0: Exit");
			operation = sc.nextInt();
			sc.nextLine();
			switch(operation) {
			case 1 :
				System.out.println("Enter key");
				String key = sc.nextLine();
				System.out.println("Enter value");
				int value = sc.nextInt();
				sc.nextLine();
				ob.put(key,value);
				System.out.println("Inserted");
				break;
			case 2 :
				System.out.println("Enter key");
				System.out.println("Value = "+ob.get(sc.nextLine()));
				break;
			case 0:
				System.out.println("Bye");
			}
				
		}
		sc.close();
	}
	
	
	private class Node {
		String key;
		T value;
		Node next,prev;
		public Node(String key, T value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	private class DoublyLinkedList{
		private Node front,rear;
		DoublyLinkedList() {
			front = rear = null;
		}
		private void moveToFront(Node node) {
			if(front == node) {
                return;
            }

            if(node == rear) {
                rear = rear.prev;
                rear.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
		}
		private void addToFront(Node node) {
			if(rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
		}
		private T removeRearNode() {
			T val = rear.value;
			if(rear == null)
				return val;
			else if(front == rear) {
				front = rear = null;
			}
			else {
				rear = rear.prev;
				rear.next = null;
			}
			return val;
		}
	}
}