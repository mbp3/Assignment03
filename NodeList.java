/**
 * Your Name:
 * Date: 
 * The program provides the code needed to create a doubly linked list to store words in alphabetical order. 
 * YOU ARE NOT TO MODIFY THIS FILE FOR ASSIGNMENT 2!
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

		}
		
		/**
		 * Get the next node
		 * @return the next node in the list or null
		 */
		public Node getNext(){ return next;}
		
		/**
		 * Get the previous node
		 * @return the previous node in the list or null
		 */
		public Node getPrev(){ return prev;}
		
		/**
		 * Get the payload of the node, in this case the name
		 * @return the name
		 */
		public String getName(){ return name;}
	}
	
	private Node head; // node at the beginning of the list
	private Node tail; // node at the end of the list
	private int length; // number of nodes in the list
	
	/**
	 * Constructor for a LinkedList.  Initializes an empty list. Both nodes will be null and the length will be zero.
	 */
	public NodeList()
	{

	}
	
	/**
	 * Get the beginning of the linked list
	 * @return the head of the linked list, or null if the list's length is 0
	 */
	public Node getHead(){return head;}
	
	/**
	 * Get the end of the linked list
	 * @return the tail of the linked list, null if the list is 0, or the same as head if the length is 1
	 */
	public Node getTail(){return tail;}
	
	/**
	 * Get the number of nodes in the linked list
	 * @return the length of the linked list
	 */
	public int getLength(){ return 0;}
	
	/**
	 * Add a node to the beginning of the list
	 * @param n - a node to add to the beginning of the list
	 */
	public void addHead(Node n)
	{

	}
	
	/**
	 * Add a node to the end of the list
	 * @param n - a node to add to the end of the list. If it is the first item inserted, the node will also be the head.
	 */
	public void addTail(Node n)
	{

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
		return false;
	}
	
	/**
	 * Remove the node at position i
	 * @param i - the position to remove a node at
	 * @return the node that was removed, or null if an invalid position was specified
	 */
	public Node remove(int i)
	{
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
		return false;
	}
	
	/**
	 * Get a node at a position
	 * @param i - position to get node
	 * @return the node at the position, or null if it was not a valid location
	 */
	public Node get(int i)
	{
		return null;
	}

	/**
	 * Print each node's payload as [nodeString, nodeString, ...] or [] if empty
	 */
	public void print()
	{

	}
}
