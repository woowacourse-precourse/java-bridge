package bridge.domain;

public enum Command {
    UP("U"), DOWN("D"),RETRY("R"), EXIT("Q"),
    ;

    private String key;

    Command(String key) {
        this.key = key;
    }

    //getter 보다는 메세지 :: 리팩토링
    public String getKey() {
        return key;
    }
}
