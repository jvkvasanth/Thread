public class Addition {
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    synchronized public void add() {
        i += 1;
    }
}
