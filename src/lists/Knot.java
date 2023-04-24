package lists;

public class Knot {

    private Object object;

    private Knot next;

    public Knot(Object object) {
        setObject(object);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Knot getNext() {
        return next;
    }

    public void setNext(Knot next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("lists.Knot{");
        sb.append("object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}
