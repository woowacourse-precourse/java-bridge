package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String MOVE_UP_OR_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String TRY_COUNT = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(StringBuilder upperBridge, StringBuilder lowerBridge) {
//        upperBridge.append(" ]");
//        lowerBridge.append(" ]");
        System.out.println(upperBridge);
        System.out.println(lowerBridge);
    }

    public void WriteInitUpperBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        if(success) {
            upperBridge.append("[ ").append("O").append(" ]");
            lowerBridge.append("[ ").append(" ").append(" ]");
        }
        if(!success) {
            upperBridge.append("X").append(" ]");
            lowerBridge.append(" ").append(" ]");
        }
    }

    public void WriteInitLowerBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        if(success) {
            upperBridge.append(" ").append(" ]");
            lowerBridge.append("O").append(" ]");
        }
        if(!success) {
            upperBridge.append(" ").append(" ]");
            lowerBridge.append("X").append(" ]");
        }
    }

    public void WriteUpperBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        bridgeLastCharRemove(upperBridge, lowerBridge);
        if(success) {
            upperBridge.append("| ").append("O").append(" ]");
            lowerBridge.append("| ").append(" ").append(" ]");
        }
        if(!success) {
            upperBridge.append("| ").append("X").append(" ]");
            lowerBridge.append("| ").append(" ").append(" ]");
        }
    }

    public void WriteLowerBridge(StringBuilder upperBridge, StringBuilder lowerBridge, boolean success) {
        bridgeLastCharRemove(upperBridge, lowerBridge);
        if(success) {
            upperBridge.append("| ").append(" ").append(" ]");
            lowerBridge.append("| ").append("O").append(" ]");
        }
        if(!success) {
            upperBridge.append("| ").append(" ").append(" ]");
            lowerBridge.append("| ").append("X").append(" ]");
        }
    }

    private void bridgeLastCharRemove(StringBuilder upperBridge, StringBuilder lowerBridge) {
        upperBridge.deleteCharAt(upperBridge.length()-1);
        lowerBridge.deleteCharAt(lowerBridge.length()-1);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int tryCount) {
        if(success) {
            System.out.println(SUCCESS_OR_FAIL + SUCCESS);
        }else if(!success) {
            System.out.println(SUCCESS_OR_FAIL + FAIL);
        }
        System.out.println(TRY_COUNT + tryCount);
    }

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printInputBridgeLength() {
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public void printSelectMove() {
        System.out.println(MOVE_UP_OR_DOWN);
    }

    public void printSelectRetry() {
        System.out.println(RETRY_OR_QUIT);
    }

    public void printResultMessage() {
        System.out.println(GAME_RESULT);
    }
}
