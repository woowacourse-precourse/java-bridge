package bridge.service.constants;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String value;

    Command(String value){
        this.value = value;
    }

    public String getCommandGame(){
        return value;
    }
}
