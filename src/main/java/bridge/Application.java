package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 시작
        Message.start();

        // 다리 길이 입력 받기
        int bridgeLength = InputView.readBridgeSize();

        // 다리 길이만큼 다리 생성
        List<Integer> bridge = makeBridge(bridgeLength);
        System.out.print("현재 다리 : ");
        for(int i=0; i<bridge.size(); i++){
            System.out.print(bridge.get(i) + " ");
        }

        // 이동할 칸 선택
        String nextMove = BridgeGame.move();
    }

    public static List<Integer> makeBridge(int bridgeLength) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> bridge = new ArrayList<>();

        for(int i=0; i<bridgeLength; i++) {
            bridge.add(bridgeRandomNumberGenerator.generate());
        }

        return bridge;
    }
}