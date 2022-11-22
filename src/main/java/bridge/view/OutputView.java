package bridge.view;

import bridge.model.MapFormat;
import bridge.model.PlayerMap;
import bridge.model.TotalResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "최종 게임 결과";

    private static final String WIN_OR_LOSE_MESSAGE = "게임 성공 여부: ";
    private static final String WIN = "성공";
    private static final String LOSE = "실패";

    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PlayerMap routeMap) {
        routeMap.toStringsByFormat(MapFormat.FORMAT).forEach(System.out::println);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(TotalResult totalResult) {
        System.out.println(TOTAL_RESULT_HEADER_MESSAGE);
        printMap(totalResult.getPlayerMap());
        printWinOrLose(totalResult);
        printTotalTryCnt(totalResult);
    }

    private void printWinOrLose(TotalResult totalResult) {
        if (totalResult.winGame()) {
            System.out.println(WIN_OR_LOSE_MESSAGE + WIN);
            return;
        }
        System.out.println(WIN_OR_LOSE_MESSAGE + LOSE);
    }

    private void printTotalTryCnt(TotalResult totalResult) {
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + totalResult.getTryCnt());
    }
}
