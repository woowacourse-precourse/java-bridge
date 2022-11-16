package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String moveError = "[ERROR] 어디에도 포함되지 않는 값입니다.";
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String randomBridgeUD, String input) {
        if(randomBridgeUD == input){
            return "O";
        }
        if(randomBridgeUD != input){
            return "X";
        }
        System.out.println(moveError);
        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        if(inputView.readGameCommand().equals("R")){
            inputView.readMoving();
        }
        if(inputView.readGameCommand().equals("Q")){
            outputView.printResult();
        }
    }
}
