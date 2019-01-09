package com.qdm.collection.list.linklist;

/**
 * @author qiudm
 * @date 2019/1/7 10:47
 * @desc
 */
public class MyLinkList<E> {

    /**
     * 集合大小
     */
    private int size;

    /**
     * 首部节点
     */
    private Node<E> first;

    /**
     * 尾部节点
     */
    private Node<E> last;



    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean add(int index, E e) {
        checkPositionIndex(index);
        if(index == size) {
            linkLast(e);
        } else {
            linkBefore(getIndexNode(index), e);
        }
        return true;
    }


    public E get(int index) {
        checkElementIndex(index);
        return getIndexNode(index).e;
    }


    public void remove(E e) {
        for(Node<E> node = first; node != null; node = node.next) {
            if (e.equals(node.e)) {
                unLink(node);
            }
        }
    }



    E unLink(Node<E> x) {
        final E ele = x.e;
        final Node pred = x.prev;
        final Node next = x.next;
        if (pred == null) {
            first = next;
        } else {
            pred.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = pred;
        } else {
            next.prev = pred;
            x.next = null;
        }
        size--;
        x.e = null;
        return ele;
    }



    public int size() {
        return size;
    }

    private void checkElementIndex(int index) {
        if(!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("索引位置不正确");
        }
    }

    private void checkPositionIndex(int index) {
        if(!isIndexPosition(index)) {
            throw new IndexOutOfBoundsException("索引位置不正确");
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isIndexPosition(int index) {
        return index >= 0 && index <= size;
    }


    private Node<E> getIndexNode(int index) {
        //数字右移1位后的值(结论是 偶数减半， 奇数-1 后减半)
        if(index < (size >> 1)) {
            Node res = first;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
            return res;
        } else {
            Node res = last;
            for (int i = size - 1; i > index; i--) {
                res = res.prev;
            }
            return res;
        }
    }



    /**
     * 在尾部加上新的元素
     * @param e
     */
    void linkLast(E e) {
        final Node l = last;
        Node newNode = new Node(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 在头部加上新的元素
     * @param e
     */
    void linkPrv(E e) {
        final Node p = first;
        Node newNode = new Node(null, e, p);
        first = newNode;
        if(p == null) {
            last = newNode;
        } else {
            p.prev = newNode;
        }
        size++;
    }



    /**
     * 在元素前加上新的元素
     * @param e
     */
    void linkBefore(Node node, E e) {

        Node pred = node.prev;
        Node newNode = new Node(pred, e, node);
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }


    private class Node<E> {

        private Node<E> prev;

        private Node<E> next;

        private E e;

        protected Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }



    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.add("a");
        myLinkList.add("b");
        myLinkList.add("c");
        myLinkList.add( "d");
        myLinkList.remove("c");
        System.out.println("myLinkList = " + myLinkList.size());
     //   System.out.println("myLinkList = " + myLinkList.get(3));
        for (int i=0; i < myLinkList.size(); i++) {
            System.out.println("myLinkList = " + myLinkList.get(i));
        }
    }



}
