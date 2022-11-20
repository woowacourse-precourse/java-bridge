package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String COMMENT_START = "다리 건너기 게임을 시작합니다.";
    private final String COMMENT_INPUT_SIZE = "다리의 길이를 입력해주세요.";
    private final String COMMENT_INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String COMMENT_CHOICE_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    public void printStart() {
        System.out.println(COMMENT_START);
    }

    public void printInputSize() {
        System.out.println(COMMENT_INPUT_SIZE);
    }

    public void printInputMove() {
        System.out.println(COMMENT_INPUT_MOVE);
    }

    public void printChoiceRestart() {
        System.out.println(COMMENT_CHOICE_RESTART);
    }

}
