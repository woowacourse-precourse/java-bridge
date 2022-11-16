package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView output = new OutputView();
        BridgeGame gameStart = new BridgeGame();
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        System.out.println("다리의 길이를 입력해주세요.");
        gameStart.move(BridgeNumberGenerator.bridgeLength); // 이동할 칸 선택

        output.printMap(BridgeNumberGenerator.bridgeLength); // Map 출력

    }
}
