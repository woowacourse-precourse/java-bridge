package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*  - 1. 자동으로 생성할 다리 길이를 입력 받는다.
                - 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
            - 2. 다리를 생성한다.
            - 3. 플레이어가 이동할 칸을 입력 받는다.
                - U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
                - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
                - 현재까지 건넌 다리를 모두 출력한다.
            - 4. 다리를 건너다 실패하면 게임 재시작/종료 여부를 입력 받는다.
                - R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
                - 재시작해도 처음에 만든 다리로 재사용한다.
            - 5. 다리를 끝까지 건너면 게임이 종료된다.
                - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
            - 6. 예외 발생 시 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.*/

        System.out.println("다리 건너기 게임을 시작합니다.");
        int cnt = 0;

        // 1.
        int bridgeSize = inputView.readBridgeSize();

        // 2.
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        // 3.
        BridgeGame bridgeGame = new BridgeGame();
        List<String> result = new ArrayList<>();
        String gameStatus = tryGame(bridgeGame, bridge, result);
        cnt += 1;

        // 4.
        String regameStatus = "";
        while (gameStatus.equals("실패") && !regameStatus.equals("Q")) {
            regameStatus = inputView.readGameCommand();
            if (regameStatus.equals("R")) {
                result = new ArrayList<>();
                gameStatus = tryGame(bridgeGame, bridge, result);
                cnt += 1;
            }
        }

        // 5.
        outputView.printResult(gameStatus, cnt, result, bridge);
    }

    private static String tryGame(BridgeGame bridgeGame, List<String> bridge, List<String> result) {
        for (int i = 0; i < bridge.size(); i++) {
            String movingValue = inputView.readMoving();
            String movingResult = bridgeGame.move(movingValue, bridge.get(i));
            result.add(movingResult);
            outputView.printMap(result, bridge);
            if (result.contains("X")) {
                return "실패";
            }
        }
        return "성공";
    }
}
