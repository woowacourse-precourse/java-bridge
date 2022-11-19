package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String TEXT_GAME_START = "다리 건너기 게임을 시작합니다.";

    private final InputView inputView;
    private final BridgeLengthValidator bridgeLengthValidator;

    public BridgeGame() {
        this.inputView = new InputView();
        this.bridgeLengthValidator = new BridgeLengthValidator();
    }

    public void runGame() {
        // TODO: Implement the method.
        System.out.println(TEXT_GAME_START);
        System.out.println();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getBridgeLength() {
        this.inputView.printPromptForBridgeLength();
        String input = inputView.readBridgeLength();

        return Integer.parseInt(input);
    }
}
