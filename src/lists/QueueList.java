package lists;

public class QueueList {

    private Knot start;

    private Knot end;

    private int limit;

    private int length;

    public QueueList(int limit) {
        setLimit(limit);
    }

    public boolean isEmpty() {
        return getLength() == 0;
    }

    public boolean isFull() {
        return getLength() == getLimit();
    }

    public boolean add(Object object) {
        if (isFull()) {
            return false;
        }

        Knot newKnot = new Knot(object);
        if (isEmpty()) {
            setStart(newKnot);
            setEnd(newKnot);
        } else {
            Knot end = getEnd();
            end.setNext(newKnot);
            setEnd(newKnot);
        }
        incrementLength();
        return true;
    }

    public boolean remove() {
        if (isEmpty()) {
            return false;
        }

        Knot start = getStart().getNext();
        setStart(start);
        decrementLength();

        if (isEmpty()) {
            setEnd(null);
        } else if (getLength() == 1) {
            setEnd(start);
        }

        return true;
    }

    public void removeObj(Knot obj) {
        if (isEmpty()) {
            return;
        }

        Knot prev = getStart();

        if (obj.equals(prev)) {
            remove();
            return;
        }

        while (prev != null) {
            Knot aux = prev.getNext();
            if (obj.equals(aux)) {
                prev.setNext(aux.getNext());
                decrementLength();
                return;
            }
            prev = aux;
        }
    }

    public Knot getStart() {
        return start;
    }

    public void setStart(Knot start) {
        this.start = start;
    }

    public Knot getEnd() {
        return end;
    }

    public void setEnd(Knot end) {
        this.end = end;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void incrementLength() {
        setLength(length + 1);
    }

    public void decrementLength() {
        setLength(length - 1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueueList {");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", limit=").append(limit);
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }

    public String toStringValues() {
        final StringBuilder sb = new StringBuilder("QueueList {");
        Knot aux = getStart();
        boolean first = true;
        while (aux != null) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(aux);
            aux = aux.getNext();
        }
        sb.append('}');
        return sb.toString();
    }

}
