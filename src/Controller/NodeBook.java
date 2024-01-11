/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import java.util.Scanner;

/**
 *
 * @author thaip
 */
public class NodeBook extends Book {
    private NodeBook next;
    private Book value;
    private static NodeBook head; 

    public NodeBook() {
    }

    public NodeBook(Book value) {
        this.value = value;
    }

    public NodeBook(NodeBook next, Book value) {
        this.next = next;
        this.value = value;
    }

    Scanner sc = new Scanner(System.in);

    public static NodeBook linkList(NodeBook head, NodeBook tail) {
        head.next = tail;
        return head;
    }

    public NodeBook addToHead(Book b) {
        NodeBook newB = new NodeBook(b);
        if (head != null) {
            newB.next = head;
        }
        head = newB; 
        return newB;
    }

    public NodeBook addToMid(Book b, int index) {
        NodeBook addB = new NodeBook(b);
        if (index == 0) {
            return addToHead(b);
        }
        NodeBook current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count == index) {
                addB.next = current.next;
                current.next = addB;
                break;
            }
            current = current.next;
        }
        printNode();
        return addB;
    }

    public void printNode() {
        NodeBook current = head;
        if (current == null) {
            System.out.println("List is empty!");
        } else {
            NodeBook temp = head;
            while (temp != null) {
                System.out.println(temp.value.toString());
                System.out.println("------------------------");
                temp = temp.next;
            }
        }
    }

    public NodeBook addNewNode(Book b) {
        NodeBook newNode = new NodeBook(b);
        NodeBook lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        
        return newNode;
    }

    public NodeBook findBook(int ch) {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            NodeBook temp = head;
            switch (ch) {
                case 1:
                    System.out.println("Enter your ISBN : ");
                    String id = sc.nextLine();
                    while (temp != null) {
                        if (temp.value.getISBN().equals(id)) {
                            System.out.println(temp.value.toString());
                        }
                        temp = temp.next;
                    }
                    break;
                case 2:
                    System.out.println("Enter your Title : ");
                    String tieude = sc.nextLine();
                    while (temp != null) {
                        if (temp.value.getTitle().equals(tieude)) {
                            System.out.println(temp.value.toString());
                        }
                        temp = temp.next;
                    }
                    break;
                case 3:
                    System.out.println("Enter your Title : ");
                    String tacgia = sc.nextLine();
                    while (temp != null) {
                        if (temp.value.getAuthor().equals(tacgia)) {
                            System.out.println(temp.value.toString());
                        }
                        temp = temp.next;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return null;
    }

    public NodeBook removeBook(String id) {
        NodeBook cur = head;
        NodeBook prev = null;
        boolean flag = false;
        while (cur != null) {
            if (cur.value.getISBN().equals(id)) {
                flag = true;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        if (flag) {
            if (prev == null) {
                head = head.next;
            } else {
                if (cur != null) {
                    prev.next = cur.next;
                }
            }
        }
        printNode();
        return head;
    }
}
