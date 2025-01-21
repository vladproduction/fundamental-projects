package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return new Iterator<>() {
            private int index = 0;
            private int repetition = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer value = array[index];
                repetition++;
                if (repetition == 2) {
                    repetition = 0;
                    index++;
                }

                return value;
            }
        };
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new Iterator<>() {
            private int index = 0;
            private int repetition = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer value = array[index];
                repetition++;

                if (repetition == 3) {
                    repetition = 0;
                    index++;
                }

                return value;
            }
        };
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new Iterator<>() {
            private int index = 0;
            private int repetition = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer value = array[index];
                repetition++;

                if (repetition == 5) {
                    repetition = 0;
                    index++;
                }

                return value;
            }
        };
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        return () -> new Iterator<>() {
            private int columnIndex = 0;
            private int rowIndex = 0;

            @Override
            public boolean hasNext() {
                return columnIndex < columns.length && rowIndex < rows.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String cell = columns[columnIndex] + rows[rowIndex];
                rowIndex++;

                if (rowIndex >= rows.length) {
                    rowIndex = 0;
                    columnIndex++;
                }

                return cell;
            }
        };
    }
}



