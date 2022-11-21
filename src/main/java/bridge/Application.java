package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int idx = 0;
    private static int gameCnt = 1;
    private static int CURRENT_LOCATION;
    private static int BRIDGE_LENGTH;
    private static final int INITIALIZE = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 시작
        Message.start();

        // 다리 길이 입력 받기
        BRIDGE_LENGTH = InputView.readBridgeSize();
        CURRENT_LOCATION = BRIDGE_LENGTH;

        // 다리 길이만큼 다리 생성
        List<String> bridge = makeBridge(BRIDGE_LENGTH);
        System.out.print("현재 다리 : ");
        for(int i=0; i<bridge.size(); i++){
            System.out.print(bridge.get(i) + " ");
        }

        while(CURRENT_LOCATION-->0) {
            // 이동할 칸 선택
            String nextMove = BridgeGame.move();

            // 다리 그리기
            boolean successOrFail = OutputView.printMap(idx, bridge, nextMove);
            idx++;
            System.out.println("idx : " + idx);

            // 재도전 여부
            canYouRetry(successOrFail);
            System.out.println("CURRENT_LOCATION3 : " + CURRENT_LOCATION);
        }
    }

    public static int canYouRetry(boolean successOrFail) {
        if(!successOrFail){
            CURRENT_LOCATION = InputView.readGameCommand(gameCnt, BRIDGE_LENGTH);
            System.out.println("CURRENT_LOCATION : " + CURRENT_LOCATION);
            idx = INITIALIZE;
            OutputView.bridgeInitialize();
            OutputView.getSuccessOrFail();;

            return CURRENT_LOCATION;
        }

        System.out.println("CURRENT_LOCATION2 : " + CURRENT_LOCATION);
        return CURRENT_LOCATION;
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