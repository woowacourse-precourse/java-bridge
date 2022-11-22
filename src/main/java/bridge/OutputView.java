package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String MOVE_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String RETRY_SELECT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String GAME_WINNING_MESSAGE = "게임 성공 여부: ";
    private final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private final static String UP = "U";
    private final static String DOWN = "D";
    private final static String O = " O ";
    private final static String X = " X ";

    public void printStartMessage(){
        System.out.println(START_MESSAGE + '\n');
    }
    public void printBridgeSizeInputMessage(){
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
    }
    public void printMoveSelectMessage(){
        System.out.println(MOVE_SELECT_MESSAGE);
    }
    public void printRetrySelectMessage(){
        System.out.println(RETRY_SELECT_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapDTO map) {
        List<String> upBridge = new ArrayList<>();
        List<String> downBridge = new ArrayList<>();
        changeForPrint(map, upBridge, downBridge);
        printBridge(upBridge);
        printBridge(downBridge);
        System.out.println();
    }

    private void changeForPrint(MapDTO map, List<String> upBridge, List<String> downBridge) {
        List<String> currentBridge = map.getCurrentBridge();
        boolean flag = map.getFlag();
        for (int i = 0; i < currentBridge.size(); i++) {
            String current = currentBridge.get(i);
            String OX = makeOX(currentBridge, flag, i);
            setUpsideBridge(upBridge, current, OX);
            setDownSideBridge(upBridge, current, OX);
        }
    }

    private String makeOX(List<String> currentBridge, boolean flag, int i) {
        String correctCheck = O;
        if (!flag && i == currentBridge.size() - 1) {
            correctCheck = X;
        }
        return correctCheck;
    }

    public void printEmptyLine(){
        System.out.println();
    }

    private void setUpsideBridge(List<String> upBridge, String current, String correctCheck) {
        if (current.equals(UP)) {
            upBridge.add(correctCheck);

        }
        upBridge.add("   ");
    }
    private void setDownSideBridge(List<String> downBridge, String current, String correctCheck) {
        if (current.equals(DOWN)) {
            downBridge.add(correctCheck);
            return;
        }
        downBridge.add("   ");
    }

    private void printBridge(List<String> upOrDownBridge) {
        System.out.print("[");
        for (int i = 0; i < upOrDownBridge.size() - 1; i++) {
            System.out.print(upOrDownBridge.get(i) + "|");
        }
        System.out.print(upOrDownBridge.get(upOrDownBridge.size() - 1));
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MapDTO map, boolean winning, int playerTry) {
        System.out.println(FINAL_GAME_RESULT_MESSAGE);
        printMap(map);

        System.out.println(makeSuccessOrFailureMessage(winning));
        System.out.print(TOTAL_TRY_COUNT_MESSAGE + playerTry);
        
    }

    private String makeSuccessOrFailureMessage(boolean winning) {
        String winningMessage = "";
        if(winning){
            winningMessage = "성공";
        }
        if(!winning){
            winningMessage = "실패";
        }
        return GAME_WINNING_MESSAGE + winningMessage;
    }
}
