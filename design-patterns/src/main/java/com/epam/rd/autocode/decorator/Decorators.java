package com.epam.rd.autocode.decorator;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {

        return new AbstractList<>() {
            @Override
            public String get(int index) {
                if (index < 0 || index >= size()) {
                    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
                }
                return sourceList.get(index * 2);
            }

            @Override
            public int size() {
                return (sourceList.size() + 1) / 2;
            }

            @Override
            public Iterator<String> iterator() {
                return new Iterator<>() {
                    private int currentIndex = 0;

                    @Override
                    public boolean hasNext() {
                        return currentIndex < size();
                    }

                    @Override
                    public String next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return get(currentIndex++);
                    }
                };
            }
        };

    }


}
