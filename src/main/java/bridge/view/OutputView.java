package bridge.view;

import bridge.BridgeGame;
import bridge.MessageGenerator;

import java.util.List;

import static bridge.MessageGenerator.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final MessageGenerator messageGenerator = MessageGenerator.getInstance();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> mapImage = messageGenerator.getMapImage(bridgeGame);

        printBackward(mapImage);
    }

    private void printBackward(List<String> mapImage) {
        for (int i = mapImage.size() - 1; i > -1; i--) {
            System.out.println(mapImage.get(i));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_FINISH_HEADER_MSG);
        printMap(bridgeGame);
        if (bridgeGame.reachOppositeSide()) {
            System.out.println(GAME_FINISH_RESULT_SUCCESS_MSG);
        } else {
            System.out.println(GAME_FINISH_RESULT_FAIL_MSG);
        }
        System.out.println(GAME_FINISH_TOTAL_TRY_MSG + bridgeGame.getTryCount());
    }
}
