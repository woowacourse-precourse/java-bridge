package bridge;
import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(HashMap<String, List<String>> result) {

        printBridge(result.get("U"));
        printBridge(result.get("D"));

    }

    private void printBridge(List<String> bridge) {
        String forPrint = bridge.toString();
        System.out.println(forPrint.replace(", ","|"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(HashMap<String, List<String>> result, boolean isSucceed, int tryCount) {

        System.out.println(OutputDocuments.GAME_END);
        printMap(result);

        System.out.println(OutputDocuments.makeResultDocument(isSucceed));
        System.out.println(OutputDocuments.makeTryCount(tryCount));
    }

    public void printStartDocs() {
        System.out.println(OutputDocuments.GAME_START);
    }
    public void printRequestBridgeLengthDocs() {
        System.out.println(OutputDocuments.REQUEST_BRIDGE_LENGTH);
    }
    public void printRequestSelectDocs() {
        System.out.println(OutputDocuments.REQUEST_MOVE_SELECT);
    }
    public void printSelectRetryDocs() {
        System.out.println(OutputDocuments.REQUEST_RETRY);
    }



}

class OutputDocuments {
    public static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    public static final String REQUEST_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String REQUEST_MOVE_SELECT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String GAME_END = "최종 게임 결과";
    private static final String GAME_RESULT = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNT = "총 시도한 횟수: ";

    public static String makeResultDocument(boolean isSucceed) {
        if (isSucceed) {
            return GAME_RESULT + "성공";
        }
        return  GAME_RESULT + "실패";
    }
    public static String makeTryCount(int tryCount) {
        return GAME_TRY_COUNT + tryCount;
    }
}