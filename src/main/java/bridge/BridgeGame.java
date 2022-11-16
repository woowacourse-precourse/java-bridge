package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(int bridgeLength) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return input.readMoving();
    }

    
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        if (command == "R") {
            return;
        } else if (command == "Q") {
            return;
        }
        //예외처리: R & Q가 아닌 값 들어왔을시
    }
}
