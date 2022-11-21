package bridge;

public enum UserCommand {
    MOVE_UP("U","위",1),
    MOVE_DOWN("D","아래",0),
    REPLAY("R","재시도"),
    END("Q","종료");

    private String command;
    private String position;
    private int number;
    private UserCommand(String command, String position,int number){
        this.command = command;
        this.position = position;
        this.number = number;
    }
    private UserCommand(String command, String position){
        this.command = command;
        this.position = position;
    }
    public String getCommand(){
        return this.command;
    }
    public String getPosition(){
        return this.position;
    }

}
