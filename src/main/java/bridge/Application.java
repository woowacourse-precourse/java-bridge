package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        printStartMessage();
        InputView inputView = new InputView();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        System.out.println(bm.makeBridge(inputView.bridge_size));

        String mv = inputView.readMoving();

    }

    public static void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }
}
