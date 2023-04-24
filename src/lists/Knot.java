package lists;

import Models.Plane;

public class Knot {

    private Plane plane;

    private Knot next;

    public Knot(Plane plane) {
        setPlane(plane);
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
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
        sb.append("obj=").append(plane);
        sb.append('}');
        return sb.toString();
    }
}
