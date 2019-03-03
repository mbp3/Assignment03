/**
 * Your Name: Michael Poust
 * Date: 3/2/2019 
 * The program provides the code needed to create a doubly linked list to store words in alphabetical order. 
 * YOU ARE NOT TO MODIFY THIS FILE FOR THE FIRST PART
*/

public class NodeList
{
	public static class Node
	{
		
		private Node next; // The node next to this node or Null if this node is at the end
		private Node prev; // The node before this node or Null if this node is at the beginning
		private String name = ""; // The string being stored by this node
		/**
		 * Constructor for a Node
		 * Sets all attributes
		 * @param data - The name
		 */
		public Node(String data)
		{
			name = data;
		}
		
		/**
		 * Get the next node
		 * @return the next node in the list or null
		 */
		public Node getNext()
		{ 
			return next;
		}

		/**
		 * Get the previous node
		 * @return the previous node in the list or null
		 */
		public Node getPrev()
		{ 
			return prev;
		}
		
		/**
		 * Get the payload of the node, in this case the name
		 * @return the name
		 */
		public String getName()
		{ 
			return name;
		}
	}
	
	private Node head; // node at the beginning of the list
	private Node tail; // node at the end of the list
	private int length; // number of nodes in the list
	
	/**
	 * Constructor for a LinkedList.  Initializes an empty list. Both nodes will be null and the length will be zero.
	 */
	public NodeList()
	{
		head = null;
		tail = null;
		length = 0;
	}
	
	/**
	 * Get the beginning of the linked list
	 * @return the head of the linked list, or null if the list's length is 0
	 */
	public Node getHead()
	{
		if(length == 0) return null;
		return head;
	}
	
	/**
	 * Get the end of the linked list
	 * @return the tail of the linked list, null if the list is 0, or the same as head if the length is 1
	 */
	public Node getTail()
	{
		if(length == 0) return null;
		return tail;
	}
	
	public void setLength(int l)
	{
		length = l;
	}
	
	/**
	 * Get the number of nodes in the linked list
	 * @return the length of the linked list
	 */
	public int getLength()
	{ 
		return length;
	}
	
	/**
	 * Add a node to the beginning of the list
	 * @param n - a node to add to the beginning of the list
	 */
	public void addHead(Node n)
	{
		if(length == 0)
		{			
			head = n;
			tail = n;
		}
		else
		{
			head.prev = n;
			n.next = head;
			n.prev = null;
			head = n;
		}
		length = length + 1;
	}
	
	/**
	 * Add a node to the end of the list
	 * @param n - a node to add to the end of the list. If it is the first item inserted, the node will also be the head.
	 */
	public void addTail(Node n)
	{
		if(length == 0)
		{
			head = n;
			tail = n;
		}
		else
		{
			n.next = null;
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
		length = length + 1;
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
		if(i < 0) return false;
		else if(i >= length)
		{
			addTail(n);
		}
		else if(i == 0)
		{
			addHead(n);
		}
		else 
		{
			Node current = get(i);
			Node currentNext = current.next;
			current.next = n;
			currentNext.prev = n;
			n.next = currentNext;
			n.prev = current;
			length = length + 1;
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
		if(i == 0) 
		{
			Node current = head;
			head = null;
			current.next = head;
			head.prev = null;
			length = length - 1;
			return current;
		}
		else if (i == length)
		{
			Node current = head;
			tail = null;
			current.prev = tail;
			tail.next = null;
			length = length - 1;
			return current;
		}
		else if(i > 0 && i < length)
		{
			Node current = get(i);
			Node currentPrev = current.prev;
			Node currentNext = current.next;
			currentPrev.next = currentNext;
			currentNext.prev = currentPrev;
			Node returnNode = current;
			current = null;
			length = length - 1;
			return returnNode;
		}
		return null;
	}
	
	/**
	 * Change the data of a node at a position
	 * @param i - the position to change
	 * @param data - the new information to set for that position
	 * @return - true of the data was replaced
	 */
	public boolean replace(int i, String data)
	{
		if(i < 0 || i > length) return false;
		else
		{
			Node current = get(i);
			current.name = data;
			return true;
		}
	}
	
	/**
	 * Get a node at a position
	 * @param i - position to get node
	 * @return the node at the position, or null if it was not a valid location
	 */
	public Node get(int i)
	{
		if( length == 0 || i > length) return null;
		else
		{
			Node current = head;
			int count = 0;
			while(current != null)
			{
				if(count == i) return current;
				count++;
				current = current.next;
			}
			return current;
		}
	}

	/**
	 * Print each node's payload as [nodeString, nodeString, ...] or [] if empty
	 */
	public void print()
	{
		if(length == 0 ) System.out.println("");
		else
		{
			Node current = head;
			int count = 0;
			while(current != null && count < length)
			{
				System.out.println(current.getName());
				current = current.next;
			}
		}
	}
}
