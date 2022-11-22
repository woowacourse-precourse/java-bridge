package bridge;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        int size = getBridgeSize();
        InputView inputView = new InputView();
        inputView.readBridgeSize(size);

        BridgeRandomNumberGenerator gen = new BridgeRandomNumberGenerator();
        BridgeMaker bm = new BridgeMaker(gen);
        System.out.println(bm.makeBridge(size));

    }

    public static void printStartMessage(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }
    public static int getBridgeSize(){
        printStartMessage();
        int size = Integer.valueOf(Console.readLine());
        return size;
    }
}
