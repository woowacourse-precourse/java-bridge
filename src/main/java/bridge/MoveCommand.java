package bridge;

public enum MoveCommand {
    UP("U"),
    DOWM("D");

    public static MoveCommand setCommandByNumber(int number) {
        if (number == 1) {
            return MoveCommand.UP;
        }
        if (number == 0) {
            return MoveCommand.DOWM;
        }
        throw new 
    }
}
