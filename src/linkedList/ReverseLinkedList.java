package linkedList;

class LinkedList
{
	Entry header;
	
	private static class Entry
	{
		private Integer data;
		private Entry next;
		
		Entry(Integer data, Entry next)
		{
			this.data = data;
			this.next = next;
		}
		
		@Override
		public String toString()
		{
			return String.valueOf(data);
		}
	}
	
	public void insertLast(int data)
	{
		Entry temp = new Entry(data, null);
		Entry curr = header;
		
		if(curr==null)
			header = temp;
		else
		{
			while(curr.next != null)
				curr = curr.next;
			
			curr.next = temp;
		}
	}
	
	public void reverse()
	{
		Entry prev= null;
		Entry curr = header;
		Entry next = null;
		
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		header=prev;
	}
	
	public void rotateLinkedlistFromNthNode(Integer n)
	{
		Entry curr = header;
		Entry prev = null;
		Entry last = header;
		if(header==null)
			System.out.println("List is empty");
		else{
			int counter = 1 ;
			while(counter <= n)
			{
				prev = curr;
				curr = curr.next;
				last = last.next;
				counter++;
			}
			prev.next =null;
			
			while(last.next != null)
				last = last.next;
			
			last.next = header;
			header = curr;
		}
	}
	
	public void displayList()
	{
		Entry curr = header;
		while(curr != null)
		{
			System.out.print(curr + " ");
			curr = curr.next;
		}
	}
}

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insertLast(10);
		list.insertLast(20);
		list.insertLast(30);
		list.insertLast(80);
		list.insertLast(60);
		list.insertLast(70);
		list.displayList();
		
		System.out.println("\n");
		
		list.reverse();
		list.displayList();
		
		System.out.println("\n");
		
		list.reverse();
		list.displayList();
		
		System.out.println("\n");
		
		list.rotateLinkedlistFromNthNode(2);
		list.displayList();
	}
}
