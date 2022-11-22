package bridge.view;

public class PrintView {
    InputView inputView = new InputView();
    public final String START_ORDER = "다리 건너기 게임을 시작합니다.";
    public final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public final String ERROR_ORDER = "[ERROR]";
    public final String MOVE_STEP = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final String EXIT_OR_CONTINUE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public final String THE_GAME_RESULT = "최종 게임 결과";
    public final String SUCCESS_OR_FAIL = "게임 성공 여부:";
    public final String TOTAL_COUNT = "총 시도한 횟수:";
    public final String FAIL = "실패";
    public final String SUCCESS = "성공";
    public void lineSkip(){
        System.out.println();
    }
    public String correct() {
        return "[ O ]";
    }
    public String wrong() {
        return "[ X ]";
    }
    public String space() {
        return "[   ]";
    }

    public String continueOrExit() {
        return inputView.readGameCommand();
    }
}
