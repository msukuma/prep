package dataStructures;

public interface Tree<T>{
	public Tree<T> getLeft(); 
	public Tree<T> getRight();
	public void add(T value);
	public T getValue();
}
