package bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BagRA<Item> {

    private Item[] bag;
    private int size;

    public static void main(String[] args) {
        BagRA<Integer> bag = new BagRA<Integer>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }
        System.out.println(bag.isEmpty());
        System.out.println(bag.size());

        Iterator<Integer> it = bag.iterator();

        it.forEachRemaining(System.out::println);
    }

    public BagRA() {
        bag = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (size == bag.length) {
            this.resizeBag(bag.length * 2);
        }
        bag[size++] = item;
    }

    private void resizeBag(int max){
        assert max >= size;
        Item[] newBag = (Item[]) new Object[max];
        for (int i = 0; i < bag.length; i++) {
            newBag[i] = this.bag[i];
        }
        this.bag = newBag;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return bag[i+1] != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item next = bag[++i];
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


        @Override
        public void forEachRemaining(Consumer<? super Item> action) {
            for (Item item : bag) {
                if(item != null){
                    action.accept(item);
                }
            }
        }
    }

}
