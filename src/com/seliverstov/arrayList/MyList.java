package com.seliverstov.arrayList;

public interface MyList<T> extends Iterable<T> {

        public boolean add(T t);
        void remove(int index);
        T get(int index);
        int size();
}
