package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    static final String START_GAME = "다리 건너기 게임을 시작합니다. \n";

    public static void main(String[] args) {
        // 게임 시작
        System.out.println(START_GAME);

        // 다리 길이 입력 받기
        int bridgeSize = InputView.readBridgeSize();

        // 랜덤으로 건널 수 있는 다리 생성
        List<String> bridgeShape = getRandomBridge(bridgeSize);
        List<String> bridgeCopy = new ArrayList<>(bridgeShape);

        // 이동 할 다리를 선택하여 다리 건너기
        new CrossBridge(bridgeSize, bridgeShape);

        // 게임 재시작 or 게임 종료 선택
        int count = selectRetryOrEnd(bridgeSize, bridgeCopy);

        // 게임 종료
        String gameState = checkGameState(bridgeShape);
        OutputView.printResult(gameState, count);
    }

    private static List<String> getRandomBridge(int bridgeSize){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static int selectRetryOrEnd(int bridgeSize, List<String> bridgeCopy){
        int count = 1;
        Boolean flag = true;
        while (flag) {
            String selectRestart = InputView.readGameCommand();
            System.out.println(selectRestart);
            if (Objects.equals(selectRestart, "R")) {
                BridgeGame.retry(bridgeSize, bridgeCopy);
                count++;
            }
            flag = false;
        }
        return count;
    }

    private static String checkGameState(List<String> bridgeShape){
        if (bridgeShape.isEmpty()){
            return "성공";
        }
        return "실패";
    }
}
