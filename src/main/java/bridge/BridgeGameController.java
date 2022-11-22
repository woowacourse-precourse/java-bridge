package bridge;

import camp.nextstep.edu.missionutils.Console;

public class BridgeGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        Bridge bridge = createBridge();
        moveAndCheck(bridge);
    }

    private Bridge createBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.receiveBridgeSize();
        return bridgeGame.make(bridgeSize);
    }


    private void moveAndCheck(Bridge bridge) {
        for (int i = 0; i < bridge.getBridge().size(); i++) {
            moveUser(bridge);
            if (bridge.isFalseInResults()) {
                String gameCommand = inputGameCommand();
                i = whenR(bridge, i, gameCommand);
                if (gameCommand.equals("Q")) {
                    result(bridge, "실패");
                    return;
                }
            }
        }
        checkSuccess(bridge);
    }

    private void moveUser(Bridge bridge) {
        System.out.println("이동할 칸을 선택해주세요");
        bridgeGame.move(bridge, inputView.readMoving(Console.readLine()));
        outputView.printMap(bridge);
    }

    private String inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.receiveGameCommand();
    }


    private int whenR(Bridge bridge, int i, String gameCommand) {
        if (gameCommand.equals("R")) {
            i = bridgeGame.retry(bridge);
        }
        return i;
    }

    private void checkSuccess(Bridge bridge) {
        if (!bridge.isFalseInResults() || bridge.getBridge().size() == bridge.getResults().size()) {
            result(bridge, "성공");
        }
    }

    private void result(Bridge bridge, String whetherSuccess) {
        System.out.println("최종 게임 결과");
        outputView.printResult(bridge);
        System.out.println("게임 성공 여부: " + whetherSuccess);
        System.out.println("총 시도한 횟수: " + bridge.getTryCount());
    }
}
