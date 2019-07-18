class Ex1_12 {
    private static Object[] elementData = new Object[1];
    private int size = 1;

    private void fastRemove(Object[] es, int i) {
        // Do nothing here. Just to keep the copied code the same.
    }

    /**
     * Copied from Java ArrayList code. (java.base/java/util/ArrayList.java)
     */
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        boolean found = false;
        if (o == null) {
            for (; i < size; i++)
                if (es[i] == null)
                    found = true;
        } else {
            for (; i < size; i++)
                if (o.equals(es[i]))
                    found = true;
        }
        if (!found) {
            return false;
        }
        fastRemove(es, i);
        return true;
    }

}
