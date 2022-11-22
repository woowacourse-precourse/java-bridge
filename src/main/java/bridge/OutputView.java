package bridge;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요.";
    public static final String CHOOSE_BRIDGE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String CHOOSE_REPLAY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: ";
    private static final String TRIAL_NUMBER_MESSAGE = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Player player, int size) {
        System.out.println(bridgeForPrint(player.bridges.upBridge,size));
        System.out.println(bridgeForPrint(player.bridges.downBridge,size));
    }
    public static void printStart(){
        System.out.println(START_MESSAGE);
    }
    public static void printMoving(){
        System.out.println(CHOOSE_BRIDGE_MESSAGE);
    }
    public static void printRetry(){
        System.out.println(CHOOSE_REPLAY_MESSAGE);
    }
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
