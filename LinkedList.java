import java.util.Scanner;

public class LinkedList {
    private static Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean t = true;
        while (t) {
            System.out.println(
                    "Select from following......\n 1) Insert Last..\n 2) Insert First..\n 3) Insert Specific..\n 4) Delete Last..\n 5) Delete First..\n 6) Delete Specific..\n 7) Display List.");
            System.out.println("select your choice.....");
            int ch = scn.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter data to save....");
                    int data = scn.nextInt();
                    insertLast(data);
                    System.out.println("data Svaed at Last Successfully.....");
                    break;
                case 2:
                    System.out.println("Enter data to save....");
                    int item = scn.nextInt();
                    insertFirst(item);
                    break;
                case 3:
                    System.out.println("Enter data to save....");
                    int d = scn.nextInt();
                    System.out.println("Enter position ....");
                    int pos = scn.nextInt();
                    boolean ans = insertAt(d, pos);
                    if (ans)
                        System.out.println("data saved At :" + pos);
                    else {
                        System.out.println("Some issues occured.....");
                    }
                    break;
                case 4:
                    deleteLast();
                    break;
                case 5:
                    int df = deleteFirst();
                    System.out.println("Deleted Data is:" + df);
                case 6:
                    System.out.println("Enter Position to delete..");
                    int p = scn.nextInt();
                    int ds = deletePos(p);
                    System.out.println("deleted Data is: " + ds);
                    break;
                case 7:
                    display();
                default:
                    break;
            }
        }
        scn.close();
    }

    public static void insertLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public static boolean insertAt(int data, int pos) {
        Node node = new Node(data);
        if (head == null && pos > 1) {
            System.out.println("List is Empty....");
            return false;
        } else if (pos == 1) {
            head = node;
            return true;
        } else {
            Node temp = head;
            int non = 0;
            while (temp.next != null) {
                temp = temp.next;
                non++;
            }
            if (pos > non) {
                System.out.println("Position is greater than Nodes Insertion not Possible...");
                return false;
            } else {
                Node move = head;
                Node pre = head;
                for (int i = 1; i < pos; i++) {
                    pre = move;
                    move = move.next;
                }
                pre.next = node;
                node.next = move;
                return true;
            }
        }

    }

    public static boolean deleteLast() {
        if (head == null) {
            System.out.println("List is Empty....");
            return false;
        } else {
            Node temp = head;
            Node pre = head;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            pre.next = null;
            return true;
        }
    }

    public static int deleteFirst() {
        if (head == null) {
            System.out.println("List is emplty..");
            return 0;
        } else {
            int dd = head.data;
            head = head.next;
            return dd;
        }
    }

    public static int deletePos(int pos) {
        if (head == null) {
            System.out.println("List is empty..");
            return 0;
        } else {
            Node temp = head;
            int non = 1;
            while (temp.next != null) {
                temp = temp.next;
                non++;
            }
            if (non < pos) {
                System.out.println("Number of Nodes is Less Than Position So deletion not possible");
                return 0;
            } else {
                Node n = head;
                Node p = head;
                for (int i = 1; i < pos; i++) {
                    p = n;
                    n = n.next;
                }
                int data = n.data;
                p.next = n.next;
                return data;
            }
        }
    }

    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
