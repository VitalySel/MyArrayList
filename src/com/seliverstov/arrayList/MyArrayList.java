package com.seliverstov.arrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


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
        if (size == this.elements.length){
            Object [] temp  = this.elements;
            this.elements = new Object[temp.length+1];
            System.arraycopy(temp,0,elements,0,temp.length);
        }
        this.elements[this.size++] = t;
        trim();
        return true;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Object[] temp = this.elements;
        this.elements = new Object[temp.length-1];
        System.arraycopy(temp, 0, this.elements, 0,index );
        int elemAfterInd = temp.length-index-1;
        System.arraycopy(temp,index+1,this.elements,index,elemAfterInd);
        this.size--;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) this.elements[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public Iterator <T> iterator() {
        return new MyArrayList.IteratorList();
    }


    private class IteratorList <T> implements Iterator<T> {
        private int cursor;
        private int lastR = -1;


        @Override
        public boolean hasNext() {
            return this.cursor < MyArrayList.this.size;
        }

        @Override
        public T next() {
            int i = this.cursor;
            if (i >= MyArrayList.this.size) throw new NoSuchElementException();
            else {
                this.cursor = i+1;
                return (T) MyArrayList.this.elements[this.lastR = i];
            }
        }

        @Override
        public void remove() {
            if (lastR < 0 || MyArrayList.this.elements[index] == null) throw new IllegalStateException();
            MyArrayList.this.remove(this.lastR);
            this.cursor = this.lastR;
            this.lastR = -1;
        }
    }

    private void trim () {
        if (this.size  < this.elements.length) {
            if (this.size == 0 || this.elements.length == 0) {
                this.elements = empty_elements;
            }
            else {
                this.elements = Arrays.copyOf(this.elements,this.size);
            }
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index > this.elements.length) throw new IllegalArgumentException();
    }
}
