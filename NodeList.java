/**
 * Your Name: Michael Poust
 * Date: 3/4/2019
 * The program provides the code needed to create a doubly linked list to store words in alphabetical order. 
 * YOU ARE REQUIRED TO MODIFY THIS FILE FOR ASSIGNMENT 2- Part 2!
*/
public class NodeList
{
	public static class Node
	{
		/**
		 * Constructor for a Node
		 * @param data - The name
		 */
		public Node(String data)
		{
			name = data;
			next = null;
			prev = null;
		}
		
		private Node next;
		private Node prev;
		private String name = "";
		
		/**
		 * Get the next node
		 * @return the next node in the list or null
		 */
		public Node getNext(){ return next; }
		
		/**
		 * Get the previous node
		 * @return the previous node in the list or null
		 */
		public Node getPrev(){ return prev; }
		
		/**
		 * Get the payload of the node, in this case the name
		 * @return the name
		 */
		public String getName(){ return name; }
	}
	
	/**
	 * Constructor for a LinkedList
	 */
	public NodeList()
	{
		head = null;
		tail = null;
		length = 0;
	}
	
	private Node head;
	private Node tail;
	private int length;
	
	/**
	 * Get the beginning of the linked list
	 * @return the head of the linked list, or null if the list's length is 0
	 */
	public Node getHead(){ return head; }
	
	/**
	 * Get the end of the linked list
	 * @return the tail of the linked list, null if the list is 0, or the same as head if the length is 1
	 */
	public Node getTail(){ return tail; }
	
	/**
	 * Get the number of nodes in the linked list
	 * @return the length of the linked list
	 */
	public int getLength(){ return length; }
	
	/**
	 * Add a node to the beginning of the list
	 * @param n - a node to add to the beginning of the list
	 */
	public void addHead(Node n)
	{
		if (head == null)
		{
			head = n;
			tail = n;
		}
		else
		{
			head.prev = n;
			n.next = head;
			head = n;
		}
		
		length++;
	}
	
	/**
	 * Add a node to the end of the list
	 * @param n - a node to add to the end of the list. If it is the first item inserted, the node will also be the head.
	 */
	public void addTail(Node n)
	{
		if (head == null)
		{
			head = n;
			tail = n;
		}
		else
		{
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		
		length++;
	}
	
	/**
	 * Insert a node at a position in the linked list.
	 * If the position is negative, the node will not be inserted.
	 * If the position is larger than the length, the node will be added to the tail.
	 * @param i - the position to insert
	 * @param n - the node to insert
	 * @return - whether the node was inserted or not.
	 */
	public boolean insert(int i, Node n)
	{
		if (i >= length) addTail(n);
		else
		{
			Node h = get(i);
			if (h == null) return false;
			n.next = h;
			n.prev = h.prev;
			h.prev.next = n;
			h.prev = n;
			length++;
		}
		return true;
	}
	
	/**
	 * Remove the node at position i
	 * @param i - the position to remove a node at
	 * @return the node that was removed, or null if an invalid position was specified
	 */
	public Node remove(int i)
	{
		Node h = get(i);
		if (h == null) return null;
		if (h.prev != null) h.prev.next = h.next;
		if (h.next != null) h.next.prev = h.prev;
		length--;
		return h;
	}
	
	/**
	 * Change the data of a node at a position
	 * @param i - the position to change
	 * @param data - the new information to set for that position
	 * @return - true of the data was replaced
	 */
	public boolean replace(int i, String data)
	{
		Node h = get(i);
		if (h == null) return false;
		else h.name = data;
		return true;
	}
	
	/**
	 * Get a node at a position
	 * @param i - position to get node
	 * @return the node at the position, or null if it was not a valid location
	 */
	public Node get(int i)
	{
		if (i < 0 || i >= length) return null;
		Node h = head;
		for (int x = 0; x < i; x++) h = h.next;  
		return h;
	}

	/**
	 * Print each node's payload
	 */
	public void print()
	{
		if (length == 0) System.out.println("No nodes.");
		else
		{
			Node h = head;
			for (int i = 0; i < length; i++)
			{
				System.out.println(h.name);
				h = h.next;
			}
		}
	}
}