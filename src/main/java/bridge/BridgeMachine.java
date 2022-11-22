package bridge;

public class BridgeMachine {
    private int totalTry = 1;
    private int index = 0;
    private boolean success = false;

    public void initiateBridgeMachine() {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView.gameStart();
        Bridge bridge;
        while(true){
            try{
                OutputView.inputBridgeSize();
                String bridgeSize = InputView.readBridgeSize();
                bridge = new Bridge(bridgeSize);
                break;
            }
            catch(IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }

        }
        while (true) {
            String userMoveCommand;
            while(true){
                try{
                    OutputView.inputUserMoveCommand();
                    userMoveCommand = InputView.readMoving();
                    break;
                }
                catch(IllegalArgumentException e){
                    OutputView.printError(e.getMessage());
                }

            }
            if (!bridgeGame.move(userMoveCommand, bridge, index)) {
                bridge.changeBridgeMap(index, userMoveCommand, "X");
                OutputView.printMap(bridge.getBridgeMap(), index);
                String replay;
                while(true){
                    try{
                        OutputView.inputUserReplayCommand();
                        replay = InputView.readGameCommand();
                        break;
                    }
                    catch(IllegalArgumentException e){
                        OutputView.printError(e.getMessage());
                    }
                }
                if (replay.equals(UserCommand.REPLAY.getCommand())) {
                    bridgeGame.retry(bridge);
                    totalTry++;
                    index = 0;
                } else {
                    break;
                }
            } else {
                bridge.changeBridgeMap(index, userMoveCommand, "O");
                OutputView.printMap(bridge.getBridgeMap(), index);
                index++;
            }
            if (index == bridge.getBridgeSize()) {
                success = true;
                break;
            }
        }
        if (success) {
            index--;
        }
        OutputView.printLastBridgeResult();
        OutputView.printMap(bridge.getBridgeMap(), index);
        if (success == GameResult.FAILED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.FAILED);
        } else if (success == GameResult.PASSED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.PASSED);
        }
        OutputView.printTotalTry(totalTry);
    }
}
