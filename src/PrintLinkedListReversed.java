import java.util.Stack;

public class PrintLinkedListReversed {
    private static void printLinkedList(Node head) {
        Stack<Node> stack = new Stack<>();
        Node node = head;
        if(node == null) return;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }

    private static void printLinkedListWithRecursion(Node head) {
        if(head != null) {
            if(head.next != null) {
                printLinkedListWithRecursion(head.next);
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] argv) {
        Node head = new Node(10);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        head.next = node1;
        node1.next = node2;
        printLinkedList(head);
        printLinkedListWithRecursion(head);
    }


}

class Node {
    Node next;
    int data;
    Node(int n) {
        next = null;
        data = n;
    }
}
