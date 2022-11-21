package bridge.view;

import bridge.domain.Result;
import bridge.support.ResultSignResolver;
import bridge.view.sign.FirstBridgeSignStrategy;
import bridge.view.sign.SecondBridgeSignStrategy;

import static bridge.view.sign.ResultSign.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String GAME_IS_SUCCEED_MESSAGE = "\n게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    private static final String FAIL_MESSAGE = "실패";
    private static final String SUCCESS_MESSAGE = "성공";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        printFirstBridge(result);
        printSecondBridge(result);
    }

    private void printFirstBridge(Result result) {
        StringBuilder sb = new StringBuilder();

        appendOpenSquareBracket(sb);
        ResultSignResolver resolver = new ResultSignResolver(result, new FirstBridgeSignStrategy(result, sb));
        sb.append(resolver.resolveResult());
        appendCloseSquareBracket(sb);

        System.out.print(sb);
    }

    private void printSecondBridge(Result result) {
        StringBuilder sb = new StringBuilder();

        appendOpenSquareBracket(sb);
        ResultSignResolver resolver = new ResultSignResolver(result, new SecondBridgeSignStrategy(result, sb));
        sb.append(resolver.resolveResult());
        appendCloseSquareBracket(sb);

        System.out.print(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(result);
        if(result.hasWrong()) {
            System.out.println(GAME_IS_SUCCEED_MESSAGE + FAIL_MESSAGE);
            System.out.println(TOTAL_TRY_COUNT + result.getTryCount());
            return;
        }
        System.out.println(GAME_IS_SUCCEED_MESSAGE + SUCCESS_MESSAGE);
        System.out.println(TOTAL_TRY_COUNT + result.getTryCount());
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMoveDirection() {
        System.out.println(INPUT_MOVE_DIRECTION_MESSAGE);
    }

    public void printInputGameCommand() {
        System.out.println(INPUT_GAME_RETRY_MESSAGE);
    }

    private void appendOpenSquareBracket(StringBuilder sb) {
        sb.append(OPEN_BRACKET.getSign());
    }

    private void appendCloseSquareBracket(StringBuilder sb) {
        sb.append(CLOSE_BRACKET.getSign());
    }
}
