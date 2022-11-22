package bridge.service;

import static bridge.domain.ReGameInfo.RE_GAME;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.Commands;
import bridge.domain.DrawBridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private final DrawBridge drawBridge;
    private final Commands commands;

    public BridgeGame() {
        drawBridge = new DrawBridge();
        commands = new Commands();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String nextMove) {
        this.commands.insertCommand(nextMove);
    }

    public void drawBridge(String nextMove) {
        this.drawBridge.draw(nextMove, bridge.isCorrectLastPosition(commands.lastIndex(), nextMove));
    }

    public String printBridge() {
        return this.drawBridge.printBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(RE_GAME.getReGameCommand())) {
            this.commands.retryCountPlus();
            this.commands.reset();
            this.drawBridge.reset();
            return true;
        }
        return false;
    }

    public void createBridge(BridgeSize bridgeSize) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(maker.makeBridge(bridgeSize.getLength()));
    }

    public boolean isCorrect(String nextMove) {
        return bridge.isCorrectLastPosition(commands.lastIndex(), nextMove);
    }

    public boolean isClear() {
        return bridge.size() == commands.size();
    }

    public int getRetryCount() {
        return commands.getRetryCount();
    }
}
