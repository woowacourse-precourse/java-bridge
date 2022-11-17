package bridge.service;

import bridge.io.OutputView;

public class Emcee {

    private final OutputView outputView = new OutputView();

    public void guideGame() {
        String guide = "다리 건너기 게임을 시작합니다.\n" +
                "다리는 위쪽과 아래쪽으로 구별되며 왼쪽에서 오른쪽으로 건너갑니다.\n" +
                "위쪽과 아래쪽 중에서 하나의 칸만 이동이 가능합니다.\n";
        outputView.printGuide(guide);
    }

    public void guideEnteringBridgeLength() {
        String guide = "다리의 길이를 입력해주세요.\n" +
                "다리의 길이는 3 이상 20 이하입니다.";
        outputView.printGuide(guide);
    }

    public void guideEnteringMovement() {
        String guide = "이동할 칸을 선택하세요. (위: U, 아래: D)";
        outputView.printGuide(guide);
    }

    public void guideEnteringRetryStatus() {

    }

    public void showBridgeMovementStatus(String movementStatus) {
        outputView.printMap(movementStatus);
    }

    public void showGameResult() {

    }
}
