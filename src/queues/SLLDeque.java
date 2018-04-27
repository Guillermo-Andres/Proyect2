package queues;

import interfaces.Deque;

public class SLLDeque<E> implements Deque<E> {

	// inner class for nodes in singly linked lists
	protected static class Node<T> {
		private T element; 
		private Node<T> next; 
		public Node() { 
			element = null; 
			next = null; 
		}
		public Node(T data, Node<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public Node(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}

	}

	private Node<E> first, last; // references to first and last node
	private int size;
	
	public SLLDeque() {
		first = last = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E first() {
		if (isEmpty()) return null; 
		return first.getElement();
	}

	@Override
	public E last() {
		if (isEmpty()) return null;
		return last.getElement();
	}

	@Override
	public void addFirst(E e) {
		Node<E> nn = new Node<E>(e);
		if (size == 0)
			first = last = nn;
		else {
			nn.setNext(first);
			first = nn;
		}
		size++;
	}

	@Override
	public void addLast(E e) {
		Node<E> nn = new Node<E>(e);
		if (size == 0)
			first = last = nn;
		else {
			last.setNext(nn);
			last = nn;
		}
		size++;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		Node<E> ntr = first;
		first = first.getNext();
		if (size == 1) last = null; 
		E etr = ntr.getElement();
		ntr.clean();
		size--;
		return etr;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) return null;
		Node<E> ntr = last;
		Node<E> target = first;
		if (size == 1) first = null; // no estoy segura si esto va
		while (target.getNext() != last)
			target = target.getNext();
		last = target;
		E etr = ntr.getElement();
		ntr.clean();
		size--; 
		return etr;
	}
}