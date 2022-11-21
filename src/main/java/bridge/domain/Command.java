package bridge.domain;

public enum Command {

    MOVE_UP("U"),
    MOVE_DOWN("D"),
    RETRY_GAME("R"),
    QUIT_GAME("Q");

    final private String value;

    Command(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
