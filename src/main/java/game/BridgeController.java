package game;

import bridge.*;

import java.util.ArrayList;
import java.util.List;

import static message.GameMessage.*;
import static message.PrintMessage.RETRY_Q_COMMAND;
import static message.PrintMessage.RETRY_R_COMMAND;


public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> commands = new ArrayList<>();


    private int gameRound = 1;
    private String gameResult = "";


    public void settingGame() {
        System.out.println(START_GAME.getStatus());
        System.out.println(BRIDGE_LENGTH.getStatus());
        List<String> bridge = getBridge();

        run(bridge);

        printGameResult();
    }

    private void gameManager() {
        gameRound++;
        commands.clear();
        outputView.clearMap();
    }


    private void run(List<String> bridge) {
        for (int i = 0; i < bridge.size(); i++) {
            String command = moveCommand();
            commands.add(command);
            outputView.commandChecker(bridge, commands, i);
            if (!(bridge.get(i).equals(command))) break;
            gameResult = SUCCESS_MESSAGE.getStatus();
        }
        if (!(commands.equals(bridge))) restart(bridge);
    }


    private void restart(List<String> bridge) {
        String retry = retryCommand();

        if (retry.equals(RETRY_R_COMMAND.getStatus())) {
            gameManager();
            run(bridge);
        }
        if (retry.equals(RETRY_Q_COMMAND.getStatus())) gameResult = FAIL_MESSAGE.getStatus();
    }


    private void printGameResult() {
        System.out.println(FINAL_RESULT.getStatus());
        outputView.printResult();
        System.out.println(GAME_RESULT.getStatus() + gameResult);
        System.out.println(GAME_ROUND.getStatus() + gameRound);
    }


    private List<String> getBridge() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }


    private String moveCommand() {
        System.out.println(MOVE_COMMAND.getStatus());
        return inputView.readMoving();
    }


    private String retryCommand() {
        System.out.println(RETRY_COMMAND.getStatus());
        return inputView.readGameCommand();
    }
}
