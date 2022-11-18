package bridge.service;

import bridge.constant.GuideMessage;
import bridge.view.OutputView;

public class Emcee {

    private final OutputView outputView = new OutputView();

    public void guideGame() {
        String guide = GuideMessage.GAME_STARTING_GUIDE.message();
        outputView.printGuide(guide);
    }

    public void guideEnteringBridgeLength() {
        String guide = GuideMessage.BRIDGE_LENGTH_ENTERING_GUIDE.message();
        outputView.printGuide(guide);
    }

    public void guideEnteringMovement() {
        String guide = GuideMessage.MOVEMENT_ENTERING_GUIDE.message();
        outputView.printGuide(guide);
    }

    public void guideEnteringRetryStatus() {
        String guide = GuideMessage.RETRY_ENTERING_GUIDE.message();
        outputView.printGuide(guide);
    }

    public void showBridgeMovementMap(String movementMap) {
        outputView.printMap(movementMap);
    }

    public void showGameResult(String movementMap, boolean completed, int attemptCount) {
        String result = "최종 게임 결과\n" + movementMap + "\n" +
                "게임 성공 여부: " + (completed ? "성공" : "실패") + "\n" +
                "총 시도한 횟수: " + attemptCount;
        outputView.printResult(result);
    }
}
