package bridge;

public enum UserMoveCommand {
    MOVE_UP("U","위"),
    MOVE_DOWN("D","아래");

    private String moveCommand;
    private String position;
    private UserMoveCommand(String moveCommand,String position){
        this.moveCommand = moveCommand;
        this.position = position;
    }
    public String getMoveCommand(){
        return this.moveCommand;
    }
    public String getPosition(){
        return this.position;
    }

}
