/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

/**
 *
 * @author tavar
 */
public class MyLinkedList {

    private Node head; //node yra grandines dalis, head yra pirmas narys

    public MyLinkedList() {
        head = null;
    }

    public int size() {
        int count = 0;
        Node next = head;
        while (next != null) {
            count++;
            next = next.next;
        }
        return count;
    }

    public void add(Object o) { //metodas add (prideti)
        Node n = new Node();
        n.value = o;
        if (head == null) {
            head = n;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = n;
        }
    }

    public String toString() {
        String ret = "{";
        Node next = head;
        while (next != null) {
            ret += next.value;
            if (next.next != null) {
                ret += ",";
            }
            next = next.next;
        }
        ret += "}";
        return ret;
    }

    public Object get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node next = head;
        while (next != null) {
            if (i == index) {
                return next.value;
            }
            i++;
            next = next.next;
        }
        throw new IndexOutOfBoundsException ();
    }
    
    public void set(int index, Object o) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node next = head;
        while (next != null) {
            if (i == index) {
                next.value = o;
                return;
            }
            i++;
            next = next.next;
        }
        throw new IndexOutOfBoundsException ();
    }
    
    public void insert(int index, Object o) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node n = new Node();
            n.value = o;
            n.next = head;
            head = n;
            return;
        }
        int i = 0;
        Node n = head;
        while (n != null) {
            if (i == index -1) {
                Node nn = new Node();
                nn.value = o;
                nn.next = n.next;
                n.next = nn;
                return;
            }
            i++;
            n = n.next;
        }
        throw new IndexOutOfBoundsException ();
    }
    
    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException ();
            }
            head = head.next;
            return;
        }
        int i = 0;
        Node n = head;
        while (n != null) {
            if (i == index -1) {
                if (n.next == null) {
                    throw new IndexOutOfBoundsException ();
                }
                n.next = n.next.next;
                return;
            }
            i++;
            n = n.next;
        }
        throw new IndexOutOfBoundsException ();
    }
    
    

    private class Node {

        Object value;
        Node next;
    }

    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.add("Hello");
        ml.add("!");
        ml.add(5);
        ml.add(10);
        System.out.println(ml.size());
        System.out.println(ml.toString());
        System.out.println(ml.get(0));
        ml.set(2, 25);
        System.out.println(ml.get(2));
        System.out.println(ml.toString());
        ml.insert(2, 77777);
        System.out.println(ml.toString());
        ml.remove(2);
        System.out.println(ml.toString());

    }

}
