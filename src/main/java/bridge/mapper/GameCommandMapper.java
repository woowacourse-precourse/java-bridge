package bridge.mapper;

import bridge.enums.GameCommand;

public class GameCommandMapper {

    private static GameCommandMapper instance = new GameCommandMapper();

    public static GameCommandMapper getInstance() {
        return instance;
    }

    public GameCommand stringToGameCommand(String input) {
        if(input.equals("R")) {
            return GameCommand.Retrial;
        }

        return GameCommand.Quit;
    }
}
