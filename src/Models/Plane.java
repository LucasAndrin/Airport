package Models;

public class Plane {

    private int time;

    private int id;

    private int gas;

    public Plane(int time, int id) {
        setId(id);
    }

    public Plane(int time, int id, int gas) {
        setId(id);
        setGas(gas);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane {");
        sb.append("id=").append(id);
        if (gas > 0) {
            sb.append(", gas=").append(gas);
        }
        sb.append('}');
        return sb.toString();
    }
}
