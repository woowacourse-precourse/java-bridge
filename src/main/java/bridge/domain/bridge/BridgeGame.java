package bridge.domain.bridge;

import bridge.domain.GameResultType;
import bridge.domain.player.Player;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge = new Bridge();
    private final Player player = new Player();
    private final InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Result result;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int index) {
        result = new Result(bridge.getBridgeNumber(index).numberTypeCheck(index),player.getMoveCommand().getMoveCommandType());
        outputView.plusResult(result.getResultType(),index);
        outputView.printMap();
        return result.getResultType().getWinLose();
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (result.getResultType()== GameResultType.LOSE_DOWN || result.getResultType()== GameResultType.LOSE_UP){
            outputView.printRetry();
            player.setPlayerCommand(inputView.readGameCommand());
            if(player.getPlayerCommand().getPlayerCommandType()){
                outputView = new OutputView();
                return true;
            }
            return false;
        }
        return false;
    }
    public int makeBridge(int size){
        bridge.inputBridgeSize(size);
        bridge.inputBridgeNumber();
        return bridge.getBridgeSize().getSize();
    }
    public void setPlayer(String command){
        player.setInputMoving(command);
    }
    public void endGame(){
        outputView.printResult(result.getResultType());
    }
}
