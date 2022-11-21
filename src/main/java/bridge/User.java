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
    public int getPosition(){
        return position;
    }

    public int getAttempt(){
        return attempt;
    }

    public void addPosition(){
        this.position += 1;
    }

    public void addAttempt(){
        this.attempt += 1;
    }

    public void initializePosition(){
        this.position = -1;
    }

}
