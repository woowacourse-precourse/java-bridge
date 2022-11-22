package bridge;

import bridge.bridgemaker.BridgeMaker;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PlayerValidation playerValidation = new PlayerValidation();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private int count = 1;
    private int playerLocate = 0;
    private static List<String> bridge;

    public static List<String> getBridge() {
        return bridge;
    }

    public void startGame(){
        bridge = makeBridge();
        System.out.println(bridge);
        for (int i = 0; i < bridge.size(); i++) {
            if (bridge.get(i).equals(move())){
                outputView.printResult(playerLocate, move(), count);
                playerLocate ++;
            }
            if (!bridge.get(i).equals(move())){
                boolean umm = retry();
                if (!umm){
                    break;
                }
                playerLocate = 0;
                outputView.printResult(playerLocate, move(), count);
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        String moving = playerValidation.moveValidation(inputView.readMoving());
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String command = playerValidation.endValidation(inputView.readGameCommand());
        if (command.equals("R")){
            count++;
            return true;
        }
        return false;
    }
    public List<String> makeBridge(){
        int size = playerValidation.checkBridgeSize(playerValidation.checkNum(inputView.readBridgeSize()));
        bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
}
