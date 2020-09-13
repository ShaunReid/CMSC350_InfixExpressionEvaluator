
public class EvaluatorStack<E> implements StackInterface<E> {

	private static int DEFAULT_SIZE = 15;
	E stackElements[];
	int numberOfElements = 0;
	
	@SuppressWarnings("unchecked")
	public EvaluatorStack() {
		stackElements = (E[])(new Object[DEFAULT_SIZE]);
	}
	
	@SuppressWarnings("unchecked")
	public EvaluatorStack(int size) {
		stackElements = (E[])(new Object[size]);
	}
	
	public boolean isFull() {
		if (numberOfElements == stackElements.length)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		if (numberOfElements == 0)
			return true;
		else
			return false;
	}
	
	public E peek()  {
		if (numberOfElements == 0)
			System.out.println("Stack is Empty");
		return stackElements[numberOfElements - 1];
	}
	
	public void push(E item) {
		if (numberOfElements == stackElements.length)
			System.out.println("Stack is Full");
		stackElements[numberOfElements] = item;
		numberOfElements++;
		System.out.println(item + " pushed");
		
	}
	
	public E pop() throws ArrayIndexOutOfBoundsException {
		
			if (numberOfElements == 0)
			System.out.println("Stack is Empty");
			E elementToReturn = stackElements[numberOfElements - 1];
			numberOfElements--;
			System.out.println(elementToReturn + " popped");	
			return elementToReturn;
		
		
	}
	
	public void displayStackElements() {
		if (numberOfElements == 0)
			System.out.println("Stack is Empty");
		for(int i = 0; i < numberOfElements; i++) {
			System.out.println(stackElements[i]);
		}
	}
	
}
