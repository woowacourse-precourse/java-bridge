package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printStart();

        InputView UserInput = new InputView();
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker newBridge = new BridgeMaker(generator);

        newBridge.makeBridge(UserInput.readBridgeSize());

    }

    // UI logic for overall process
    public static void printStart(){
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
