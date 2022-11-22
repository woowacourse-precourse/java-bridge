package bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final InputView inputview = new InputView();
    private static final OutputView outputview = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String moving = "";
        String command = "";
        int cnt = 1;
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        List<String> bridge = bridgeMaker.makeBridge(inputview.readBridgeSize());
        List<Integer> position_map = new ArrayList<>(Collections.nCopies(bridge.size() + 1, 0));
        position_map.set(0, 1);

        while (position_map.get(position_map.size() - 1) != 1) {
            System.out.println(bridge);
            System.out.println(position_map);
            System.out.println("이동할 칸을 선택해주세요.");
            moving = inputview.readMoving();
            outputview.printMap(bridge, position_map, moving);
            position_map = bridgeGame.move(bridge, position_map, moving);
            if(!position_map.contains(1)) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                position_map = bridgeGame.retry(position_map, inputview.readGameCommand());
                cnt ++;
            }
            if(!position_map.contains(1)) {
                break;
            }
        }
        System.out.println("최종 게임 결과");
        outputview.printResult(bridge, position_map, cnt);
    }
}
