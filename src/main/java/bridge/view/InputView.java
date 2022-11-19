package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.validate.Validator;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        Validator.isNum(bridgeSize);
        Validator.isProperBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public int reReadBridgeSizeWhenError() {
        try{
            return readBridgeSize();
        } catch (IllegalArgumentException e){
            OutputView.printError(e);
            return reReadBridgeSizeWhenError();
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        Validator.isMove(move);
        return move;
    }

    public String reReadMovingWhenError() {
        try{
            return readMoving();
        } catch (IllegalArgumentException e){
            OutputView.printError(e);
            return reReadMovingWhenError();
        }
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        Validator.isProperGameCommand(gameCommand);
        return gameCommand;
    }

    public String reReadGameCommandWhenError() {
        try{
            return readGameCommand();
        } catch (IllegalArgumentException e){
            OutputView.printError(e);
            return reReadGameCommandWhenError();
        }
    }
}
