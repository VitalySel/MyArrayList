package com.seliverstov.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

 class IteratorList<T> implements Iterator<T> {

    private int index = 0;
    private T [] elements;

    IteratorList(T[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return index < elements.length && elements[index] != null;
    }

    @Override
    public T next() {
        if (hasNext())  return elements[index++];
        else throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        if (index == 0 && elements[index] == null) throw new IllegalStateException();
        //if (!hasNext()) throw new NoSuchElementException();
        if (index < elements.length-1) System.arraycopy(elements, index + 1, elements, index, elements.length-index-1);
        elements[elements.length-1] = null;
    }
}
