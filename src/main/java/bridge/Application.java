package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int idx = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 시작
        Message.start();

        // 다리 길이 입력 받기
        int bridgeLength = InputView.readBridgeSize();

        // 다리 길이만큼 다리 생성
        List<String> bridge = makeBridge(bridgeLength);
        System.out.print("현재 다리 : ");
        for(int i=0; i<bridge.size(); i++){
            System.out.print(bridge.get(i) + " ");
        }

        // 이동할 칸 선택
        String nextMove = BridgeGame.move();

        // 다리 그리기
        OutputView.printMap(idx, bridge, nextMove);
    }

    public static List<String> makeBridge(int bridgeLength) {
        List<String> bridge = new ArrayList<>();
        for(int i=0; i<bridgeLength; i++) {
            bridge.add(getUpOrDown());
        }
        return bridge;
    }

    public static String getUpOrDown() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        if(bridgeRandomNumberGenerator.generate() == 1) {
            return "U";
        }
        return "D";
    }
}