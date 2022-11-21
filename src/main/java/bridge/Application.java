package bridge;

public class Application {

    public static void main(String[] args) {

        System.out.print("다리 건너기 게임을 시작합니다.");

        // 다리 길이 입력 -> inputView 클래스의 readBridgeSize()
        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();

        // 다리 길이만큼 다리 생성 -> BridgeMaker 클래스의 makeBridge(int size)
        // 이동할 칸 입력받기 -> InputView 클래스의 readMoving()
        // 입력받은 값에 따라 이동 -> BridgeGame 클래스의 move()
        // 이동한 후 다리 출력 -> OutputView 클래스의 printMap()
        // 성공 시 -> OutputView 클래스의 printResult() -> 종료
        // 실패 시 재시작 여부 입력 받음-> InputView 클래스의 readGameCommand()
        // 종료 시 -> OutputView 클래스의 printResult() -> 종료
        // 재시작 시 -> BridgeGame 클래스의 retry()
    }
}
