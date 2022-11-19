package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    // OutputView의 패키지는 변경할 수 있다.
    // OutputView의 메서드의 이름은 변경할 수 없고!! 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
    // 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result) {
        System.out.println(result);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
