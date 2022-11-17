package bridge.command;

public enum GameCommand {
    R("재시작"),
    Q("종료");
    private final String explain;

    GameCommand(String explain) {
        this.explain = explain;
    }

    public static boolean exist(String name){
        for(GameCommand gameCommand: GameCommand.values()){
            if(gameCommand.name().equals(name)){
                return true;
            }
        }
        return false;
    }

}
