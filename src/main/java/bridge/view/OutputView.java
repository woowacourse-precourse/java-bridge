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
    private static final String PRINT_SUCCESS_OR_FAILURE_NOTICE = "게임 성공 여부: ";
    private static final String PRINT_TRY_COUNT_NOTICE = "총 시도한 횟수: ";

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
        printNewLine();
    }

    public void printResult(int tryCount, String successOrFailure) {
        printResultNotice();
        printUpDownMap();
        printNewLine();
        printSuccessOrFailure(successOrFailure);
        printTryCount(tryCount);
    }

    private void printSuccessOrFailure(String successOrFailure){
        String successOrFailureNotice = PRINT_SUCCESS_OR_FAILURE_NOTICE + successOrFailure;
        System.out.println(successOrFailureNotice);
    }

    private void printTryCount(int tryCount){
        String tryCountNotice = PRINT_TRY_COUNT_NOTICE + tryCount;
        System.out.println(tryCountNotice);
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
