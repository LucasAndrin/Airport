package Models;

import lists.QueueList;

public class Track {

    final static int limitQueue = 30;

    private QueueList landing = new QueueList(limitQueue);

    private QueueList takingOff = new QueueList(limitQueue);

    public QueueList getLanding() {
        return landing;
    }

    public QueueList getTakingOff() {
        return takingOff;
    }

    public void setPlaneLanding(Plane plane) {
        landing.add(plane);
    }

    public void setPlaneTakingOff(Plane plane) {
        takingOff.add(plane);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pista {");
        sb.append("pouso = ").append(landing.toStringValues());
        sb.append(", decolagem = ").append(takingOff.toStringValues());
        sb.append("}");
        return sb.toString();
    }
}
