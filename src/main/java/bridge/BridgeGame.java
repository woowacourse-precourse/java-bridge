package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    // 이 클래스에 필드(인스턴스 변수)를 추가할 수 있다.
    // 이 클래스의 패키지는 변경할 수 있다.
    // 이 클래스의 메서드 이름은 변경할 수 없고!! 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    // 게임 진행을 위해 필요한 메서드를 추가하거나 변경할 수 있다.
    // 이 클래스에서 InputView, OutputView 사용하지 않는다!

    private static final String UP = "U";
    private static final String QUIT = "Q";

    private BridgeMap bridgeMap;

    public BridgeGame() {
        this.bridgeMap = new BridgeMap();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeBlock) {
        boolean isUpSide = moving.equals(UP);
        boolean isRight = moving.equals(bridgeBlock);

        this.bridgeMap.add(isUpSide, isRight);

        return isRight;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(QUIT)) {
            return false;
        }

        this.bridgeMap = new BridgeMap();
        return true;
    }

    public String bridgeMapToString() {
        return bridgeMap.toString();
    }

    public String gameResultToString(boolean isSuccess, int tryCount) {
        return "최종 게임 결과\n" + bridgeMap.toString() +
                "\n" +
                successOrNotToString(isSuccess) +
                "총 시도한 횟수: " +
                tryCount;
    }

    private String successOrNotToString(boolean isSuccess) {
        if (isSuccess) {
            return "\n게임 성공 여부: 성공\n";
        }

        return "\n게임 성공 여부: 실패\n";
    }
}
