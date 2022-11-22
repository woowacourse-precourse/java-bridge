package bridge;

public class Player {
    public int getPosition() {
        return position;
    }

    private int position;
    Stage stage;

    public int getAttempt() {
        return attempt;
    }

    private int attempt;

    //전진
    public void forward() {
        this.position++;
        this.attempt++;
    }
    //후진
    public void backward() {
        if(position>=1)
            this.position--;
    }

}
