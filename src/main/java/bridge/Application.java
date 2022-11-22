package bridge;


import java.util.List;
import java.util.Objects;

public class Application {

    static final String START_GAME = "다리 건너기 게임을 시작합니다. \n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_GAME);
        int bridgeSize = InputView.readBridgeSize();
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridgeshape =  bridgeMaker.makeBridge(bridgeSize);

        int i = 0;
        while (i < bridgeSize) {
            String selectMove = InputView.readMoving();
            String aliveOrDie = BridgeGame.move(selectMove, bridgeshape);
            System.out.println(aliveOrDie);
            if (Objects.equals(aliveOrDie, "END")){
                UpDown.BridgeGameState(selectMove, "FAIL");
                break;
            }
            UpDown.BridgeGameState(selectMove, "PASS");
            i++;
        }
        System.out.println(UpDown.upBridges);
        System.out.println(UpDown.downBridges);
    }
}
