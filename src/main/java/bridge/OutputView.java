package bridge;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";
    public static final String CHOOSE_BRIDGE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String CHOOSE_REPLAY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: ";
    private static final String TRIAL_NUMBER_MESSAGE = "총 시도한 횟수: ";
    private static final String PRINT_ENTER = "\n";
    private static final String LEFT_SQUARE = "[ ";
    private static final String RIGHT_SQUARE = " ]";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String PIPE_CHARACTER = " | ";


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
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printFinalResult(Bridges bridges, Boolean successOrNot,int trialNumber) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(bridgeForPrint(bridges.upBridge,bridges.bridgesSize-1));
        System.out.println(bridgeForPrint(bridges.downBridge,bridges.bridgesSize-1) + PRINT_ENTER);
        System.out.println(SUCCESS_OR_NOT_MESSAGE + printSuccessOrNot(successOrNot));
        System.out.println(TRIAL_NUMBER_MESSAGE + trialNumber);
    }
    public static String printSuccessOrNot(boolean successOrNot){
        if(successOrNot == true) return SUCCESS_MESSAGE;
        return FAIL_MESSAGE;
    }

    public static String bridgeForPrint(List<String> bridge, int size){
        String bridgeResult = LEFT_SQUARE;
        for(int index=0;index<=size;index++) {
            if(size ==0){
                bridgeResult = bridgeResult + bridge.get(0) + RIGHT_SQUARE;
                return bridgeResult;
            }
            else if( size != 0 && index != size) bridgeResult = bridgeResult + bridge.get(index) + PIPE_CHARACTER;
            else if( size != 0 && (index == size)) bridgeResult = bridgeResult + bridge.get(index) + RIGHT_SQUARE;
        }
        return bridgeResult;
    }

}
