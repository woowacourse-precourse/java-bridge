package bridge;

public class Retry {
    private int count;

    public Retry(int count) {
        this.count = count;
    }

    public void add() {
        count++;
    }

    public int getCount(){
        return count;
    }
}
