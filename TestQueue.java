class QueueArray {
	
	private int[] arr;
	private int front;
	private int rear;
	
	public QueueArray(int size) {
		
		this.arr = new int[size];
		this.front = -1; // we keep front = 0 in normal queue but in circular queue it is better to assign -1
		this.rear = -1;
		
	}
	
	public  boolean isEmpty () {
		
		return front == -1; //here empty condition is front == -1
		
	}
	
	public boolean isFull() {
		
		return (rear + 1) % arr.length == front; // here if we keep front == 0 this condition can be true even its not full
		
	}
	
	
	public void insert(int item) {
		
		if (isFull()) {
			
			System.out.println ("Queue is full! cannot insert : "+item);
			return;
			
		}
		
		if (front == -1) {
			
			front = 0;//after passing isfull condition we assign front == 0 for first insertion
			
		}
			
	rear = (rear + 1) % arr.length; //wrap around at the end of the array *arr.length - 1* if rear's index becomes 4,at next insertion rear is 0
	arr[rear] = item;
	System.out.println (item+" is inserted successfullly!");
		
	}
	
	public int remove() {
		
		if (isEmpty()) {
			
			System.out.println ("Queue is empty, so cannot remove");
			return -1;
			
		}
		 	
		int remove = arr[front];//we assign the arrys front index element to remove variable
		
		//**this IF part is important** means after assigning front to remove variable we front == rear this means front is pointitng into last element 
		// [_,_,_,_,4] now rear is 4 and front is also 4 that means when we return the remove variable no element exist in this array so we arrange the value of rear and front
		
		if (front == rear) {
			
			rear = -1;
			front = -1;
		
		} else {
			
			front = (front + 1) % arr.length;// else wrap around again
			
		}
		
		return remove;
			
			
	}
	
	public int peekFront() {
		
		if (isEmpty()) {
			
			System.out.println ("Queue is empty, so cannot peek");
			return -1;
			
		}
		
		return arr[front];
		
	}
	
}

public class TestQueue {
	
	public static void main (String...args) {
		
		QueueArray sa = new QueueArray(5);
		
		sa.insert(0);
		sa.insert(1);
		sa.insert(2);
		sa.insert(3);
		sa.insert(4);
		sa.insert(5);
		
		System.out.println ("removed : "+sa.remove());
		System.out.println ("removed : "+sa.remove());
		System.out.println ("removed : "+sa.remove());
		System.out.println ("removed : "+sa.remove());
		System.out.println ("removed : "+sa.remove());
		
		sa.insert(5);
		sa.insert(6);
		System.out.println ("front element : "+sa.peekFront());
		
	}
}

	
/* This is circular queue implementation in java based on array , queue follows the FIFO principal that means the frist element inserted

is the first one to remove */

//output format
/*
0 is inserted successfullly!
1 is inserted successfullly!
2 is inserted successfullly!
3 is inserted successfullly!
4 is inserted successfullly!
Queue is full! cannot insert : 5
removed : 0
removed : 1
removed : 2
removed : 3
removed : 4
5 is inserted successfullly!
6 is inserted successfullly!
front element : 5
*/
		