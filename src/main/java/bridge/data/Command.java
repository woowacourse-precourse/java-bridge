package bridge.data;

public enum Command {
    RESTART("R"),
    QUIT("Q");

    private final String KEY;

    public String KEY() {return this.KEY;}
    Command(String command){
        KEY = command;
    }
}
