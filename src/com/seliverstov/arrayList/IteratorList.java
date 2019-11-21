package com.seliverstov.arrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorList<E> implements Iterator<E> {
    private int index = 0;
    private E [] obj;

    private IteratorList(E [] obj) {
        this.obj = obj;
    }

    @Override
    public boolean hasNext() {
        return index <= obj.length;
    }

    @Override
    public E next() {
        if (hasNext()) return obj[index++];
        else throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        if (!hasNext()) throw new NoSuchElementException();
        if (index++ < obj.length) {
            System.arraycopy(obj,index++,obj,index,obj.length-1);
        }
        //Дописать условия IllegalStateException
    }

}
