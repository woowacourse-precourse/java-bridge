package bridge;

public class User {
    private int position;
    private int attempt;

    User(){
        this.position = 0;
        this.attempt = 0;
    }

    public int getUserPosition(){
        return position;
    }

    public int getUserAttempt(){
        return attempt;
    }

    public void addUserPosition(){
        this.position += 1;
    }

    public void addUserAttempt(){
        this.attempt += 1;
    }

    public void initializeUserPosition(){
        this.position = 0;
    }

}
