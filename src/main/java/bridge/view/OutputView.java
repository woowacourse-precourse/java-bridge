package bridge.view;

import bridge.domain.Player;

import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_INPUT_BRIDGE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String START_MAP = "[ ";
    private static final String FINISH_MAP = " ]";
    private static final String INTERVAL_BRIDGE = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String COLLECT = "O";
    private static final String LAST_COLLECT = "O$";
    private static final String WRONG = "X";
    private static final String BLANK = " ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public void printStartGame() {
        System.out.println(MESSAGE_GAME_START);
        System.out.println();
    }

    public void printPleaseInputBridgeLength() {
        System.out.println(MESSAGE_INPUT_BRIDGE);
    }

    public void printNewline() {
        System.out.println();
    }

    public void printChoiceMove() {
        System.out.println(MESSAGE_INPUT_MOVE);
    }

    public void printMap(Player player) {
        String upMap = makeMap(player, UP);
        String downMap = makeMap(player, DOWN);

        System.out.println(upMap);
        System.out.println(downMap);
        System.out.println();
    }

    private String makeMap(Player player, String base) {
        String intervalMap = player.getMoveInfo().stream()
                .map(upDown -> convertUpDownToResult(upDown, base))
                .collect(Collectors.joining(INTERVAL_BRIDGE));

        if (!player.getIsMove()) {
            intervalMap = intervalMap.replaceAll(LAST_COLLECT, WRONG);
        }
        return START_MAP + intervalMap + FINISH_MAP;
    }

    private String convertUpDownToResult(String input, String base) {
        if (input.equals(base)) {
            return COLLECT;
        }
        return BLANK;
    }

    public void printPleaseInputRetry() {
        System.out.println(MESSAGE_INPUT_RETRY);
    }

    public void printResult(Player player) {
        System.out.println("최종 게임 결과");
        printMap(player);

        System.out.println("게임 성공 여부: " + moveResult(player.getIsMove()));
        System.out.println("총 시도한 횟수: " + player.getTotalTry());
    }

    public String moveResult(boolean isMove) {
        if (isMove) {
            return SUCCESS;
        }
        return FAIL;
    }
}
