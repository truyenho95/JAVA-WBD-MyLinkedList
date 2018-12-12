import java.awt.*;

public class MyOwnLinkedList {
  private Point headPoint;
  private int numberOfPoint;

  public MyOwnLinkedList(Object data) {
    headPoint = new Point(data);
  }

  public void add(int index, Object data) {
    checkPositionIndex(index);

    if (index == (numberOfPoint+1))
      addLast(data);
    else if (index == 0)
      addFirst(data);
    else {
      Point temp = headPoint;
      Point holder;

      for (int i = 0; i < index - 1 && temp.nextPoint != null; i++) {
        temp = temp.nextPoint;
      }
      holder = temp.nextPoint;
      temp.nextPoint = new Point(data);
      temp.nextPoint.nextPoint = holder;
      numberOfPoint++;
    }
  }

  private void checkPositionIndex(int index) {
    if (!isPositionIndex(index))
      throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  }

  private String outOfBoundsMsg(int index) {
    return "Index: "+index+", Size: "+(numberOfPoint+1);
  }

  private boolean isPositionIndex(int index) {
    return index >= 0 && index <= (numberOfPoint+1);
  }

  public void addFirst(Object data) {
    Point temp;
    temp = headPoint;
    headPoint = new Point(data);
    headPoint.nextPoint = temp;
    numberOfPoint++;
  }

  public MyOwnLinkedList addLast(Object data) {
    Point temp = headPoint;
    for (int i = 0; i < numberOfPoint; i++) {
      temp = temp.nextPoint;
    }
    temp.nextPoint = new Point(data);
    numberOfPoint++;
    return this;
  }

  public Object get(int index) {
    Object data = null;
    Point temp = headPoint;
    for (int i = 0; i < index; i++) {
      data = temp.data;
      temp = temp.nextPoint;
    }
    return data;
  }

  public void printList() {
    Point temp = headPoint;
    int index = 1;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.nextPoint;
    }
  }

  private class Point {
    private Point nextPoint;
    private Object data;

    public Point(Object data) {
      this.data = data;
    }

    public Object getData() {
      return data;
    }
  }
}
