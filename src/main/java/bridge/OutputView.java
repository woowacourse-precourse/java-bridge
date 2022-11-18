package bridge;

public class OutputView {

    static String result;

    public void printMap(String[] bridgeMap) {
        BridgeGame bridgeGame = new BridgeGame();

        System.out.println("[ " + bridgeMap[0] + " ]");
        System.out.println("[ " + bridgeMap[1] + " ]");
        result = "[ " + bridgeMap[0] + " ]\n" + "[ " + bridgeMap[1] + " ]";
        if (bridgeMap[0].contains("X") || bridgeMap[1].contains("X")) {
            bridgeGame.retry();
        }
    }

    public void printResult() {
        System.out.println("최종 게임 결과");
        System.out.println(result);
    }
}
