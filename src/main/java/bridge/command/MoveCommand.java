package bridge.command;

public enum MoveCommand {
    D("아래"),
    U("위");
    private final String explain;

    MoveCommand(String explain) {
        this.explain = explain;
    }
    public static boolean exist(String name){
        for(MoveCommand moveCommand: MoveCommand.values()){
            if(moveCommand.name().equals(name)){
                return true;
            }
        }
        return false;
    }
}
