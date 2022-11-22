package bridge;

public enum MoveCommand {
    UP('U'), DOWN('D');

    private final char value;

    MoveCommand(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static MoveCommand of(char c){
        if(c != 'U' && c != 'D')
            throw new IllegalArgumentException("잘못된 MoveCommand 입력.");
        if(c == 'U')
            return UP;
        return DOWN;
    }
}
