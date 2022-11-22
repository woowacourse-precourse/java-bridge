package bridge.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static final String MESSAGE_RESTART_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MESSAGE_START_GAME = "다리 건너기 게임을 시작합니다.";

    private static final String MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_GAME_FINAL_RESULT = "최종 게임 결과";
    private static final String MESSAGE_WHETHER_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String MESSAGE_TRY_COUNT = "총 시도한 횟수: ";

    public void printMap(List<List<String>> map) {
        printOneRoad(map.get(0));
        printOneRoad(map.get(1));
        System.out.println();
    }

    public void printResult(List<List<String>> map, boolean result, int tryCount) {
        printMap(map);
        printSuccessOrNot(result);
        printTryCount(tryCount);
    }

    public void printStartMassage() {
        System.out.println(MESSAGE_START_GAME);
        System.out.println();
    }

    public void printInputMessageGameCommand() {
        System.out.println(MESSAGE_RESTART_GAME);
    }

    public void printInputMessageBridgeSize() {
        System.out.println(MESSAGE_BRIDGE_SIZE);
    }

    public void printInputMessageMoving() {
        System.out.println(MESSAGE_MOVING);
    }

    public void printMessageResult() {
        System.out.println(MESSAGE_GAME_FINAL_RESULT);
    }

    private void printOneRoad(List<String> road) {
        StringBuffer sb = new StringBuffer("[  ]");
        StringJoiner sj = new StringJoiner(" | ");
        for (String path : road) {
            sj.add(path);
        }
        sb.insert(2, sj.toString());

        System.out.println(sb.toString());
    }

    private void printSuccessOrNot(boolean result) {
        System.out.print(MESSAGE_WHETHER_SUCCESS_OR_NOT);
        if (result) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }

    private void printTryCount(int tryCount) {
        System.out.print(MESSAGE_TRY_COUNT);
        System.out.println(tryCount);
    }
}
