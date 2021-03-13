package sample;

import java.util.Objects;

public class ListaComArray {
    private Integer[] array;
    private boolean resizable;
    private int initialCapacity;
    private Integer counter;
    private final int X = 10;

    public ListaComArray() {
        this(10);
    }

    public ListaComArray(int initialCapacity) {
        this(initialCapacity, true);
    }

    public ListaComArray(int initialCapacity, boolean resizable) {
        this.initialCapacity = 10;
        this.resizable = resizable;
        this.counter = 0;
        this.array = new Integer[initialCapacity];
    }

    public void add(Integer item) {
        this.array[counter] = item;
        counter++;

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    public void add(int index, Integer item) throws Exception {
        if(index > counter){
           throw new Exception("O index é maior do que o número de itens adicionados do array.");
        }

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    private void resizeArrayList() {
        Integer[] oldArray = this.toArray();

        int oldLength = oldArray.length;
        int newLength = oldLength + X;

        Integer[] newArray = new Integer[newLength];

        for (int i = 0; i < oldLength; i++) {
            newArray[i] = oldArray[i];
        }

        this.array = newArray;
    }

    public Integer[] toArray() {
        return this.array;
    }

    public Integer remove(int index) {
        Integer oldValue = this.array[index];

        this.array[index] = null;

        return oldValue;
    }
}
