package dsa;

public class StackFunctions {
    private String [] elements = new String [5];

    private int count = 0;
    public int element;
    public void push(int element) {
        this.element = element;
        count++;
    }
    public boolean IsEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }
    public void push(String element) {
        if (count == elements.length) {
            throw new StackOverflowError();
        }

        elements[count] = element;
        count++;
    }

    public String pop() {
        count --;
        return elements[count];
    }

    public String peek() {
        if (count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[count - 1];
    }
    public int size() {
        return count;
    }
    private String [] elements = new String [5];

    private int count = 0;
    public int element;
    public void push(int element) {
        this.element = element;
        count++;
    }
    public boolean IsEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }
    public void push(String element) {
        if (count == elements.length) {
            throw new StackOverflowError();
        }

        elements[count] = element;
        count++;
    }

    public String pop() {
        count --;
        return elements[count];
    }

    public String peek() {
        if (count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[count - 1];
    }
    public int size() {
        return count;
    }
    private String [] elements = new String [5];

    private int count = 0;
    public int element;
    public void push(int element) {
        this.element = element;
        count++;
    }
    public boolean IsEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }
    public void push(String element) {
        if (count == elements.length) {
            throw new StackOverflowError();
        }

        elements[count] = element;
        count++;
    }

    public String pop() {
        count --;
        return elements[count];
    }

    public String peek() {
        if (count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[count - 1];
    }
    public int size() {
        return count;
    }

}
