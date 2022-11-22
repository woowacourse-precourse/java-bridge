package bridge.View;

import bridge.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String START_BRIDGE_POINT = "[ ";
    private static final String CLOSE_BRIDGE_POINT = " ]";
    private static final String MIDDLE_BRIDGE_POINT = " | ";
    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private OutputView() {

    }

    /**
     * 게임 시작 메시지를 출력하는 메소드
     */
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridgeFormat 다리의 현재 상태를 갖고 있는 형식
     */
    public static void printMap(List<List<String>> bridgeFormat) {
        String upSideIndex = getUpOrDownSideIndex(bridgeFormat, 0);
        String downSideIndex = getUpOrDownSideIndex(bridgeFormat, 1);
        System.out.println(upSideIndex);
        System.out.println(downSideIndex);
    }

    /**
     * 다리 출력 형식에 필요한 sideIndex를 만들고 반환하는 메소드
     *
     * @param bridgeFormat 다리의 현재 상태를 갖고 있는 형식
     * @param index up 일 경우 0이, down일 경우 1이 입력됨
     * @return sideIndex(String)
     */
    private static String getUpOrDownSideIndex(List<List<String>> bridgeFormat, int index) {
        StringBuilder sideIndex = new StringBuilder();
        sideIndex.append(START_BRIDGE_POINT);
        for (List<String> tmp : bridgeFormat) {
            sideIndex.append(tmp.get(index) + MIDDLE_BRIDGE_POINT);
        }
        sideIndex.delete(sideIndex.length()-3, sideIndex.length());
        sideIndex.append(CLOSE_BRIDGE_POINT);
        return sideIndex.toString();
    }
}