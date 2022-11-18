package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final StringBuilder upViewMap;
    private final StringBuilder downViewMap;

    public OutputView() {
        this.upViewMap = new StringBuilder();
        this.downViewMap = new StringBuilder();
    }

    private void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    private void askBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    //application 에서 코드 줄이기 위해 병합.
    public void printGettingStart() {
        printStartMessage();
        askBridgeSize();
    }

    public void askCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {

    }

    private void handleMap(StringBuilder builder, String result) {
        builder.replace(builder.length() - 1, builder.length(), "|");

    }
    private void handleMapIfFirst(StringBuilder builder, String result) {
        builder.append("[ ");
        builder.append(result);
        builder.append(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
