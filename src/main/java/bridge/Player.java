package bridge;

public class Player {
    private String currentDirection;

    Player(){
        this.currentDirection = "";
    }

    public void moveTo(String direction){
        this.currentDirection = direction;
    }

    public String getCurrentPlace() {
        return this.currentDirection;
    }
}
