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
            moveUser(bridge); // 사용자 이동
            String examineResult = examineBridge(bridge);
            if (examineResult.equals("R")) {
                i = -1;
            }
            if (examineResult.equals("Q")) {
                return;
            }
        }
        checkSuccess(bridge);
    }

    private String examineBridge(Bridge bridge) {
        if (bridge.isFalseInResults()) { // False가 발생했다면
             return checkRestartOrQuit(bridge);
        }
        return "";
    }

    private String checkRestartOrQuit(Bridge bridge) {
        String gameCommand = inputGameCommand(); // 게임 재시도 여부 입력받기
        if (gameCommand.equals("R")) {
            bridgeGame.retry(bridge);
        }
        if (gameCommand.equals("Q")) { // 게임 종료(Q)를 입력받았다면
            result(bridge, "실패"); // 최종 결과 출력하고
        }
        return gameCommand;
    }

    private void moveUser(Bridge bridge) {
        System.out.println("이동할 칸을 선택해주세요");
        bridgeGame.move(bridge, inputView.receiveMoveDirection());
        outputView.printMap(bridge);
    }

    private String inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.receiveGameCommand();
    }

    private void checkSuccess(Bridge bridge) {
        if (!bridge.isFalseInResults() || bridge.getBridge().size() == bridge.getResults().size()) {
            result(bridge, "성공");
        }
    }

    private void result(Bridge bridge, String whetherSuccess) {
        outputView.printResult(bridge);
        System.out.println("게임 성공 여부: " + whetherSuccess);
        System.out.println("총 시도한 횟수: " + bridge.getTryCount());
    }
}
