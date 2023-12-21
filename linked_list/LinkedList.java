
package linked_list;

public interface LinkedList<E> {
	public boolean isEmpty();
    public int size();
    public Object get(int index);
    public int indexOf(Object object);
    public Object remove(int index);
    public void add(int index, Object theObject);
    public void addFirst(Object theObject);
    public void addLast(Object theObject);
    public String outputList();
    public void clear();
    public boolean isFound(Object theObject);
}
