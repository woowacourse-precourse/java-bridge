package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;


    public BridgeGame(InputView inputView ,OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void start(){
        outputView.printGameStart();
        Player player = new Player();
        int bridgeSize = inputView.readBridgeSize();
        player.makeRightBridge(bridgeSize);
        play(player);
        outputView.printResult(player);
    }

    private void play(Player player) {
        while(true){
            player.useCoin();
            player.makeNewPlayerBridge();
            move(player);
            if(retry(player)){
                continue;
            }
            break;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(Player player) {
        player.moving(inputView, outputView);

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Player player) {
        if(player.fail()){
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) return true;
            if (gameCommand.equals("Q")) return false;
        }
        return false;
    }

}