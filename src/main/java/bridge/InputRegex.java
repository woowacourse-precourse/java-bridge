package bridge;

public enum InputRegex {
    BridgeSize("^[0-9]{1,2}$"),
    Moving("^[U,D]{1}$"),
    GameCommand("^[R,Q]{1}$");

    private final String regex;

    InputRegex(String regex){
        this.regex=regex;
    }
    public String getRegex(){
        return this.regex;
    }

}
