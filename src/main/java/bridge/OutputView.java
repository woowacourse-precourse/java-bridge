package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

enum outputMessage {

    OUTPUT_BRIDGE_HEAD("[\n["),
    OUTPUT_BRIDGE_TAIL("]\n]"),
    OUTPUT_BRIDGE_MIDDLE("|\n|"),

    OUTPUT_MOVING_CORRECT(" O "),
    OUTPUT_MOVING_INCORRECT(" X "),
    OUTPUT_WITHOUT_MOVING("   "),

    OUTPUT_SUCCESS("성공"),
    OUTPUT_FAILURE("실패"),

    OUTPUT_TOTAL("\n최종 게임 결과"),
    OUTPUT_RESULT("\n게임 성공 여부: "),
    OUTPUT_TRIAL("총 시도한 횟수: ");

    private final String message;

    outputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}