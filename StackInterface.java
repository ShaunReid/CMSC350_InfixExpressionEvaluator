
public interface StackInterface<E> {
	public boolean isFull();
	public boolean isEmpty();
	public E peek();
	public void push(E item);
	public E pop();
}
