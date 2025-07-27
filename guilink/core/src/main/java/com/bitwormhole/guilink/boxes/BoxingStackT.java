package com.bitwormhole.guilink.boxes;

public abstract class BoxingStackT<T> {

    private final T[] items;
    private final int capacity;
    private int size;

    public BoxingStackT(int _capacity) {
        this.capacity = _capacity;
        this.items = this.createNewArray(_capacity);

    }

    protected abstract T createNewItem(int index, T parent);

    protected abstract T[] createNewArray(int size);

    public T getItemAt(int index, boolean enable_create) {
        if (index < 0) {
            return null;
        }
        if (index >= this.capacity) {
            return null;
        }
        T item = this.items[index];
        if ((item == null) && (enable_create)) {
            T parent = this.getItemAt(index - 1, false);
            item = this.createNewItem(index, parent);
            this.items[index] = item;
            this.size = index + 1;
        }
        return item;
    }

    public int getSize() {
        return this.size;
    }
}
