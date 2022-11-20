package bridge.dto.controller;

import bridge.dto.output.PrintMapDto;
import bridge.utils.game.GameStatus;

public class MoveDto {

    private final GameStatus nextGameStatus;
    private final PrintMapDto printMapDto;

    public MoveDto(GameStatus nextGameStatus, PrintMapDto printMapDto) {
        this.nextGameStatus = nextGameStatus;
        this.printMapDto = printMapDto;
    }

    public GameStatus getNextGameStatus() {
        return nextGameStatus;
    }

    public PrintMapDto getPrintMapDto() {
        return printMapDto;
    }
}
