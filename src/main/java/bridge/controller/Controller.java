package bridge.controller;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputException;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

/***
 * UI 로직과 비즈니스 로직을 연결해주는 클래스
 */
public class Controller {
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private InputException inputException = new InputException();
    private BridgeGame bridgeGame;

    /**
     * 게임을 시작하는 메인 메서드
     */
    public void startGame(){
        output.printStart();
        int size = bridgeSize();
        List<String> bridge = bridgeMaker(size);
        bridgeGame(bridge);

    }

    /**
     * 다리의 길이를 입력받는 메서드
     */
    public int bridgeSize() {
        while (true) {
            try {
                int size = inputException.checkLengthBridge(input.readBridgeSize());
                return size;
            } catch (IllegalArgumentException exception) {
                System.out.printf(exception.getMessage());
            }
        }
    }

    /**
     * 다리의 길이만큼 랜덤 리스트를 만드는 메서드
     */
    public List<String> bridgeMaker(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }

    /***
     * 게임을 실행하는 메서드
     *
     */
    public void bridgeGame(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
        while (bridgeGame.stateGame()) {
            if (!checkMoveSucess()) {
                break;
            }
        }
        output.printResult(bridgeGame.getGameCount(), bridgeGame.stateGame());
    }

    /**
     * 게임중 사용자의 입력값을 받는 메서드
     */
    public String inputUpDown() {
        while (true) {
            try {
                String upDown = inputException.checkUpDown(input.readMoving());
                return upDown;
            } catch (IllegalArgumentException exception) {
                System.out.printf(exception.getMessage());
            }
        }
    }

    /**
     * 사용자가 선택한 다리가 맞는지 확인하는 메서드
     */
    public boolean checkMoveSucess() {
        String upDown = inputUpDown();
        boolean sucess = bridgeGame.move(upDown);
        output.setUpDrawMap(bridgeGame.getUser(), upDown);
        output.printMap();
        if (!sucess) {
            if (!checkRetry()) return false;
        }
        return true;
    }


    /**
     * 재시작 여부를 입력하는 메서드
     */
    public String inputRetry() {
        while (true) {
            try {
                String retryQuick = inputException.checkRetry(input.readGameCommand());
                return retryQuick;
            } catch (IllegalArgumentException exception) {
                System.out.printf(exception.getMessage());
            }
        }
    }

    /**
     * 재시작 여부를 확인하는 메서드
     */
    public boolean checkRetry() {
        String retryQuick = inputRetry();
        if (bridgeGame.retry(retryQuick)) {
            bridgeGame.setup();
            output.clearDrawMap();
            return true;
        }
        return false;
    }
}
