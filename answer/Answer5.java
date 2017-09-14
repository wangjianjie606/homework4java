package answer;

import java.util.Iterator;

/**
 * Created by Dono on 2017/09/14 0014.
 */
public class Answer5 {
    public static void main(String[] arg){
        MyLinkedList<String> list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.set(0,"4");
        list.insert(0,"5");
        list.remove(3);
        System.out.println(list.get(list.size()-1));
        System.out.println(list);
        System.out.println(list.contains("4"));
    }

    private static class MyLinkedList<T> implements Iterable<T>{
        private int size;
        private MyLinkedNode<T> firstChild;
        private MyLinkedNode<T> lastChild;

        public int size(){
            return size;
        }

        public void clear(){
            doClear();
        }

        public MyLinkedList() {
            doClear();
        }

        public void add(T o){
            if (size++ == 0){
                firstChild = new MyLinkedNode<T>(o, null, null);
                lastChild = firstChild;
                return;
            }
            MyLinkedNode<T> newNode = new MyLinkedNode<T>(o, lastChild, null);
            lastChild.next = newNode;
            lastChild = newNode;
        }

        public T insert (int n, T o){
            MyLinkedNode<T> oldNode = getNode(n);
            T oldItem = oldNode.item;
            MyLinkedNode<T> newNode = new MyLinkedNode<T>(o, oldNode.pre, oldNode);
            if(oldNode.pre==null)
                firstChild = newNode;
            else
                oldNode.pre.next = newNode;

            oldNode.pre = newNode;
            size++;
            return oldItem;
        }
        
        public T set(int n, T o){
            MyLinkedNode<T> node = getNode(n);
            T oldItem = node.item;
            node.item = o;
            return oldItem;
        }
        
        public void remove(int n){
            MyLinkedNode<T> node = getNode(n);
            node.pre.next = node.next;
            if(node.next==null)
                lastChild = node.pre;
            else
                node.next.pre = node.pre;
            size--;
        }

        public T get(int n){
            return getNode(n).item;
        }

        public int contains(T o){
            MyLinkedNode<T> node = firstChild;
            for (int i = 0; i < size; i++) {
                if(node.item.equals(o)) return i;
                node = node.next;
            }
            return -1;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer("[");
            MyLinkedNode<T> node = firstChild;
            if(node==null) return sb.toString()+"]";
            else sb.append(node.item);
            while( node.next!=null ){
                node = node.next;
                sb.append(", "+node.item);
            }
            return sb.toString()+"]";
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        private MyLinkedNode<T> getNode(int n){
            if(n>size-1 || n<0) throw new IndexOutOfBoundsException();

            MyLinkedNode<T> node;
            if(n<size/2){
                node = firstChild;
                for (int i=0;i<n;i++)
                    node = node.next;
            }else{
                node = lastChild;
                for(int i=size-1;i>n;i--)
                    node = node.pre;
            }

            return node;
        }

        private void doClear(){
            size = 0;
            firstChild = lastChild = null;
        }

        private class MyLinkedNode<T>{
            MyLinkedNode<T> pre;
            MyLinkedNode<T> next;
            T item;

            public MyLinkedNode(T item, MyLinkedNode<T> pre, MyLinkedNode<T> next) {
                this.pre = pre;
                this.next = next;
                this.item = item;
            }
        }
    }


}
