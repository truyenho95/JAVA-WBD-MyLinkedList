public class TestMyOwnLinkedList {
  public static void main(String[] args) {
    MyOwnLinkedList ll = new MyOwnLinkedList(9);
    ll.addFirst(11);
    ll.addLast(12);
    ll.add(1,102);
    ll.add(3, 92);

    ll.printList();
  }
}
