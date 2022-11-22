package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_PROMPT = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";
    private static final String INPUT_DIRECTION_PROMPT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_PROMPT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RESULT_PROMPT = "최종 게임 결과";
    private static final String PASS_FAIL_PROMPT = "게임 성공 여부: ";
    private static final String PASS_SIGN = "성공";
    private static final String FAIL_SIGN = "실패";
    private static final String TRY_COUNT_PROMPT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String format) {
        System.out.println(format);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, boolean passOrFail) {
        String result = getResult(passOrFail);

        System.out.println(PASS_FAIL_PROMPT + result);
        System.out.println(TRY_COUNT_PROMPT + tryCount);
    }

    public void printStartPrompt() {
        System.out.println(GAME_START_PROMPT);
    }

    public void printInputDirectionPrompt() {
        System.out.println(INPUT_DIRECTION_PROMPT);
    }

    public void printRetryPrompt() {
        System.out.println(RETRY_PROMPT);
    }

    public void printResultPrompt() {
        System.out.println(RESULT_PROMPT);
    }

    private String getResult(boolean passOrFail) {
        if (passOrFail) {
            return PASS_SIGN;
        }

        return FAIL_SIGN;
    }
}
