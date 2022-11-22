package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String PRINT_START_GAME_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String PRINT_INPUT_BRIDGE_SIZE_NOTICE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_INPUT_MOVE_DIRECTION_NOTICE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PRINT_RESTART_GAME_NOTICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String PRINT_RESULT_NOTICE = "최종 게임 결과";
    private static final String INIT = "";
    private static final String FIRST_BRACKET = "[";
    private static final String LAST_BRACKET = "]";
    private static final String STICK = "|";
    private static final String SPACE = " ";
    private static String upMap;
    private static String downMap;

    public void printStartGameNotice() {
        System.out.println(PRINT_START_GAME_NOTICE);
        printNewLine();
    }

    public void printInputBridgeSizeNotice() {
        System.out.println(PRINT_INPUT_BRIDGE_SIZE_NOTICE);
    }

    public void printInputMoveDirectionNotice(){
        System.out.println(PRINT_INPUT_MOVE_DIRECTION_NOTICE);
    }

    public void printReStartGameNotice(){
        System.out.println(PRINT_RESTART_GAME_NOTICE);
    }

    public void printResultNotice(){
        System.out.println(PRINT_RESULT_NOTICE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> checkUpCross, List<String> checkDownCross) {
        initMap();
        addFirstBracket();
        for(int i=0;i<checkUpCross.size();i++){
            if(i>0){
                addStick();
            }
            addPossibility(checkUpCross,checkDownCross,i);
        }
        addLastBracket();
        printUpDownMap();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        printResultNotice();
        printUpDownMap();
    }

    private void initMap(){
        upMap = INIT;
        downMap = INIT;
    }
    private void addFirstBracket(){
        upMap += FIRST_BRACKET;
        downMap += FIRST_BRACKET;
    }

    private void addStick(){
        upMap += STICK;
        downMap += STICK;
    }

    private void addPossibility(List<String> checkUpCross, List<String> checkDownCross, int index){
        upMap += SPACE + checkUpCross.get(index) + SPACE;
        downMap += SPACE + checkDownCross.get(index) + SPACE;
    }

    private void addLastBracket(){
        upMap += LAST_BRACKET;
        downMap += LAST_BRACKET;
    }

    private void printUpDownMap(){
        System.out.println(upMap);
        System.out.println(downMap);
    }

    public void printNewLine() {
        System.out.println();
    }
}
