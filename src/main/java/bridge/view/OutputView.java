package bridge.view;

import bridge.service.constants.Error;

import static bridge.service.constants.Error.ERROR_MESSAGE;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String START_GAME ="다리 건너기 게임을 시작합니다.";
    private final String REQUEST_SIZE = "다리의 길이를 입력해주세요.";
    private final String REQUEST_BRIDGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String RESULT = "최종 게임 결과";
    private final String SUCESS_WHETHER = "게임 성공 여부: ";
    private final String TRY_COUNT = "총 시도한 횟수: ";
    private final String SUCESS = "성공";
    private final String FAIL = "실패";
    private final String EMPTY = "";

    public void printStart(){
        System.out.println(START_GAME);
        emptyLine();
    }

    public void printRequestBridgeSize(){
        System.out.println(REQUEST_SIZE);
        emptyLine();
    }

    public void printRequestMove(){
        System.out.println(REQUEST_BRIDGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printBridge(StringBuilder upBridge, StringBuilder downBridge) {
        System.out.println(upBridge);
        System.out.println(downBridge);
        emptyLine();
    }

    public void printRequestRetry(){
        System.out.println(REQUEST_RETRY);
    }

    public void printFinalGame(){
        System.out.println(RESULT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean sucess, int cnt) {
        System.out.println(SUCESS_WHETHER + printSucessWheter(sucess));
        System.out.println(TRY_COUNT + cnt);
    }

    private String printSucessWheter(boolean sucessGame){
        if(sucessGame){
            return SUCESS;
        }
        return FAIL;
    }

    public void printErrorMessage(String message){
        System.out.println(ERROR_MESSAGE+ message);
    }

    public void emptyLine(){
        System.out.println(EMPTY);

    }


}
