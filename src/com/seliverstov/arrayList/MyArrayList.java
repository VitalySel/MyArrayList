package com.seliverstov.arrayList;

import java.util.Arrays;
import java.util.Iterator;


public class MyArrayList<T> implements MyList<T>  {

    private Object[] elements;
    private Object[] empty_elements  = new Object[0];
    private int index;
    private int size;


    public MyArrayList(int init_size) {
        if (init_size > 0)  this.elements =  new Object[init_size];
        else {
            if (init_size != 0) throw new IllegalArgumentException("Wrong size - " + init_size);
            this.elements = empty_elements;
        }
    }

    public MyArrayList() {
        this.elements = empty_elements;
    }


    @Override
    public boolean add(Object t) {
        if (size == elements.length){
            this.elements = Arrays.copyOf(this.elements,this.elements.length + 1);
        }
        elements[size++] = t;
        trim();
        return true;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index < elements.length-1) System.arraycopy(elements, index + 1, elements, index, elements.length-index-1);
        elements[elements.length-1] = null;
        trim ();

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public Iterator <T> iterator() {
        return new IteratorList<T>((T[]) elements);
    }

    private void trim () {
        if (this.size  < this.elements.length) {
            if (this.size == 0 || this.elements.length == 0) {
                this.elements = empty_elements;
            }
            else {
                elements = Arrays.copyOf(this.elements,this.size);
            }
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index > elements.length) throw new IllegalArgumentException();
    }
}
