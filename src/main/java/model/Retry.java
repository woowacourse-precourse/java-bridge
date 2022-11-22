package model;

public class Retry {
    private int count;

    public Retry(int count) {
        this.count = count;
    }

    public void add() {
        count++;
    }

    public String toString(){
        return String.valueOf(count);
    }
}
