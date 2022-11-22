package bridge;

public class BridgeMachine {
    private int totalTry = 0;
    private int index = 0;
    private boolean success = false;
    public void initiateBridgeMachine() {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView.gameStart();

        OutputView.inputBridgeSize();
        String bridgeSize = InputView.readBridgeSize(); //예외
        Bridge bridge = new Bridge(bridgeSize);
        while (true) {
            OutputView.inputUserMoveCommand();
            String userMoveCommand = InputView.readMoving();
            //움직이는 거 여부를 판단하는 예외 메소드 추가
            if (!bridgeGame.move(userMoveCommand, bridge, index)){
                bridge.changeBridgeMap(index, userMoveCommand, "X");
                OutputView.printMap(bridge.getBridgeMap(), index);

                OutputView.inputUserReplayCommand();
                String replay = InputView.readGameCommand();
                //게임 재시도 여부 판단하는 예외 메소드 추가
                if (replay == UserCommand.REPLAY.getCommand()) {
                    bridgeGame.retry(bridge);
                    continue;
                }
                if (replay == UserCommand.END.getCommand()) {
                    break;
                }
            }

            bridge.changeBridgeMap(index, userMoveCommand, "O");
            OutputView.printMap(bridge.getBridgeMap(), index);
            index++;
            if (index == bridge.getBridgeSize()) {
                success = true;
                break;
            }
        }
        OutputView.printLastBridgeResult();
        OutputView.printMap(bridge.getBridgeMap(), index);
        if (success == GameResult.FAILED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.FAILED);
        } else if (success== GameResult.PASSED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.PASSED);
        }
        OutputView.printTotalTry(totalTry);
    }


}
