package sample;

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
        this.initialCapacity = initialCapacity;
        this.resizable = resizable;
        this.counter = 0;
        this.array = new Integer[initialCapacity];
    }

    public void add(Integer item) throws Exception {
        if (!this.resizable) {
            if (counter.equals(initialCapacity)) {
                this.indiceMaiorOuMenorTamanhoLista(counter + 1);
            }
        }

        this.array[counter] = item;
        counter++;

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    public void add(int index, Integer item) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        Integer[] oldArray = this.toArray();

        for (int i = index; i <= counter; i++) {
            if (index == i) {
                this.array[i] = item;
            } else {
                this.array[i] = oldArray[i - 1];
            }
        }

        counter++;

        if (this.resizable && this.counter.equals(array.length)) {
            resizeArrayList();
        }
    }

    private void resizeArrayList() {
        Integer[] oldArray = this.toArray();

        int oldLength = oldArray.length;
        int newLength = oldLength + X;

        Integer[] newArray = new Integer[newLength];

        System.arraycopy(oldArray, 0, newArray, 0, oldLength);

        this.array = newArray;
    }

    public Integer[] toArray() {
        return this.array;
    }

    public Integer remove(int index) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        Integer[] oldArray = this.toArray();
        Integer oldValue = this.toArray()[index];

        for (int i = index; i < counter; i++) {
            this.array[i] = oldArray[i + 1];
        }

        counter--;

        return oldValue;
    }

    public boolean removeFirst(Integer item) {
        boolean retorno = false;

        for (int i = 0; i < this.counter; i++) {
            if (this.array[i].equals(item)) {
                Integer[] oldArray = this.toArray();

                for (int j = i; j < counter; j++) {
                    this.array[j] = oldArray[j + 1];
                }

                retorno = true;
                counter--;
                break;
            }
        }

        return retorno;
    }

    public void clear() {
        this.array = new Integer[initialCapacity];
    }

    public int size() {
        return this.counter;
    }

    public boolean isEmpty() {
        return this.counter.equals(0);
    }

    public boolean isFull() {
        if (!this.resizable) {
            return this.counter.equals(this.initialCapacity);
        }

        return Boolean.FALSE;
    }

    public Integer get(int index) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        return this.toArray()[index];
    }

    public Integer set(int index, Integer item) throws Exception {
        indiceMaiorOuMenorTamanhoLista(index);

        Integer oldItem = this.toArray()[index];

        this.array[index] = item;

        return oldItem;
    }

    public boolean contains(Integer item) {
        boolean retorno = false;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                retorno = true;
                break;
            }
        }

        return retorno;
    }

    public Integer indexOf(Integer item) {
        int index = -1;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                index = i;
                break;
            }
        }

        return index;
    }

    private Integer lastIndexOf(Integer item) {
        int index = -1;

        for (int i = 0; i < counter; i++) {
            if (this.array[i].equals(item)) {
                index = i;
            }
        }

        return index;
    }

    private void indiceMaiorOuMenorTamanhoLista(int index) throws Exception {
        if (index > counter) {
            throw new Exception("O index é maior do que o número de itens adicionados no array.");
        } else if (index < 0) {
            throw new Exception("O index é menor do que o número de itens adicionados no array.");
        }
    }
}