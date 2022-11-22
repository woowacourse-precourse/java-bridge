package bridge.view;

public class OutputView {

    public void printMap(String bridgeState) {
        System.out.println(bridgeState);
    }

    public void printResult(String result) {
        System.out.println("최종 게임 결과\n" + result);
    }

    public void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
}
