package bridge.view;

import bridge.constant.Directive;
import bridge.constant.ViewStatus;
import bridge.controller.BridgeGameController;
import bridge.dto.GameResult;
import bridge.utils.ResultParser;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String SUCCESS = "성공";
    private final String FAIL = "실패";
    private final BridgeGameController bridgeGameController;
    private final ResultParser resultParser;

    private String parsedGameResult = "";

    public OutputView(BridgeGameController bridgeGameController) {
        this.bridgeGameController = bridgeGameController;
        this.resultParser = new ResultParser();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        parsedGameResult = resultParser.parseResultToMapUI(gameResult);
        System.out.println(parsedGameResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ViewStatus status) {
        System.out.println(Directive.FINAL_GAME_RESULT.getMessage());
        System.out.println(parsedGameResult);
        printWinOrNot(status);
        printCount();
    }

    private void printWinOrNot(ViewStatus status) {
        System.out.print(Directive.WIN_OR_NOT.getMessage());
        if (status == ViewStatus.WIN) {
            System.out.println(SUCCESS);
        }
        if (status == ViewStatus.LOSE) {
            System.out.println(FAIL);
        }
    }

    private void printCount() {
        System.out.print(Directive.GAME_COUNT.getMessage());
        System.out.println(bridgeGameController.getGameCount());
    }
}
