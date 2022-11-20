package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final BridgeGame manager = BridgeGame.getInstance();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void run() {
        startBridgeGame();
        while(!manager.isGameSuccess()) {
            String movingCommand = getMoving();
            boolean movingSuccess = manager.move(movingCommand);
            outputView.printMap(manager.getMovingStatus(), movingSuccess); // 이동 결과 출력
            if(!movingSuccess && !doRetry()) {
                break;
            }
        }
        outputView.printResult(manager.getMovingStatus(), manager.isGameSuccess(), manager.getAttemptsCount());
    }

    private static void startBridgeGame() {
        outputView.printMessage("다리 건너기 게임을 시작합니다.", "\n");
        int length = getBridgeLength();
        manager.setBridgeStatus(bridgeMaker.makeBridge(length));
    }

    private static boolean doRetry() {
        String command = getGameCommand();
        if(command.equals("R")) {
            manager.retry();
            return true;
        }
        return false;
    }

    private static int getBridgeLength() {
        while(true) {
            try {
                int length = inputView.readBridgeSize("다리의 길이를 입력해주세요.", "\n");
                return length;
            }
            catch(IllegalArgumentException e) {
            }
        }
    }

    private static String getMoving() {
        while(true) {
            try {
                String command = inputView.readMoving("이동할 칸을 선택해주세요. (위: U, 아래: D)", "\n");
                return command;
            }
            catch(IllegalArgumentException e) {
            }
        }
    }

    private static String getGameCommand() {
        while(true) {
            try {
                String command = inputView.readGameCommand("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", "\n");
                return command;
            }
            catch(IllegalArgumentException e) {
            }
        }
    }
}
