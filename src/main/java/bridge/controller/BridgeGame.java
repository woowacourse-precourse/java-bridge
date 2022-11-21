package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.User;
import bridge.service.BridgeGameService;
import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private GameStatus gameStatus = new GameStatus();
    private User user = new User();
    private Bridge bridge = new Bridge();
    private BridgeGameService bridgeGameService = new BridgeGameService();

    public void startGame(int size){
        bridge.setBridgeSize(size);
        bridge.setBridgeLoad(bridgeMaker.makeBridge(size));
        gameStatus.addGameCount();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        user.addNext(moving);
    }

    public String getMergeBridge(){
        BridgeGameService bridgeGameService = new BridgeGameService();
        bridgeGameService.setMergeBridge();
        return bridgeGameService.getMergeBridge();
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.clearLog();
        gameStatus.addGameCount();
    }

    public String endGame() {
        bridgeGameService.setEndMessage();
        return bridgeGameService.getEndMessage();
    }

    public boolean setMatch(){
        bridgeGameService.setMatch();
        return gameStatus.getMatchCorrect();
    }

    public boolean getMatchCorrect(){
        return gameStatus.getMatchCorrect();
    }

    public boolean checkAllCorrect(){ // 따로 다시 마들기
        return bridgeGameService.checkAllCorrect();
    }
}
