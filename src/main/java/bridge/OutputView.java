package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_SENTENCE = "다리 건너기 게임을 시작합니다.";
    private final String INPUT_BRIDGE_LENGTH_SENTENCE = "다리의 길이를 입력해주세요.";
    private final String INPUT_BOARD_SENTENCE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_RETRY_GAME_SENTENCE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String GAME_RESULT_SENTENCE = "최종 게임 결과";
    private final String GAME_SUCCESS_OR_NOT_SENTENCE = "게임 성공 여부: ";
    private final String GAME_TRY_NUMBER_SENTENCE = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBoardCheckList, List<String> downBoardCheckList) {
        String upMap = getUpMap(upBoardCheckList);
        String downMap = getDownMap(downBoardCheckList);
        System.out.println(upMap + downMap);
    }

    private String getUpMap(List<String> upBoardCheckList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < upBoardCheckList.size() - 1; i++) {
            stringBuilder.append(" ").append(upBoardCheckList.get(i)).append(" ");
            stringBuilder.append("|");
        }
        stringBuilder.append(" ").append(upBoardCheckList.get(upBoardCheckList.size() - 1)).append(" ");
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    private String getDownMap(List<String> downBoardCheckList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < downBoardCheckList.size() - 1; i++) {
            stringBuilder.append(" ").append(downBoardCheckList.get(i)).append(" ");
            stringBuilder.append("|");
        }
        stringBuilder.append(" ").append(downBoardCheckList.get(downBoardCheckList.size() - 1)).append(" ");
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        boolean success = bridgeGame.getSuccess();
        int tryCount = bridgeGame.getTryCount();
        List<String> upBoardCheckList = bridgeGame.getUpBoardCheckList();
        List<String> downBoardCheckList = bridgeGame.getDownBoardCheckList();
        System.out.println(GAME_RESULT_SENTENCE);
        printMap(upBoardCheckList,downBoardCheckList);
        System.out.print(GAME_SUCCESS_OR_NOT_SENTENCE);
        printSuccess(success);
        System.out.print(GAME_TRY_NUMBER_SENTENCE);
        System.out.println(tryCount);
    }

    private void printSuccess(boolean success) {
        if (success) System.out.println("성공");
        if (!success) System.out.println("실패");
    }

    /**
     * 게임의 시작 문구를 출력한다.
     */
    public void printStart() {
        System.out.println(START_SENTENCE);
    }

    /**
     * 다리의 길이 입력 문구를 출력한다.
     */
    public void printInputBridgeLength() {
        System.out.println(INPUT_BRIDGE_LENGTH_SENTENCE);
    }

    public void printInputBoard() {
        System.out.println(INPUT_BOARD_SENTENCE);
    }

    /**
     * 게임 재시작 문구 출력
     */
    public void printInputRetry() {
        System.out.println(INPUT_RETRY_GAME_SENTENCE);
    }
}
