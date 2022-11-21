package bridge;

public class User {
    private int position;
    private int attempt;
    private String direction;

    User(){
        this.position = -1;
        this.attempt = 1;
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){return direction;}
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
        this.position = -1;
    }

}
