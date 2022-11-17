package bridge.controller;

import java.util.List;
import java.util.Objects;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.service.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 필드를 추가 가능
 * 패키지 변경 가능
 * 메서드 이름 변경 불가
 * 인자, 반환 타입 추가, 변경 가능
 * 메서드 추가, 변경 가능
 */
public class BridgeGame {
    private final static BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final static InputView INPUT_VIEW = new InputView();
    private final static OutputView OUTPUT_VIEW = new OutputView();
    private final static BridgeMap BRIDGE_MAP = new BridgeMap();

    private List<String> answer;
    private String input;
    private boolean success = true;
    private int bridgeSize;
    private int round = 0;
    private int tryCount = 1;

    public void start() {
        OUTPUT_VIEW.printStart();
        OUTPUT_VIEW.printLengthInput();
        bridgeSize = INPUT_VIEW.readBridgeSize();
        answer = BRIDGE_MAKER.makeBridge(bridgeSize);
        OUTPUT_VIEW.printLine();
        do {
            play();
            round+=1;
        } while (success && round < bridgeSize);
        end();
    }

    public void play() {
        OUTPUT_VIEW.printMoveInput();
        input = INPUT_VIEW.readMoving();
        move();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        BRIDGE_MAP.updateBridgeMap(answer.get(round), input);
        BRIDGE_MAP.createMessage();
        OUTPUT_VIEW.printMap(BRIDGE_MAP);
        retry();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(!Objects.equals(answer.get(round), input)) {
            OUTPUT_VIEW.printRetry();
            if("R".equals(INPUT_VIEW.readGameCommand())) {
                tryCount += 1;
                round -= 1;
                BRIDGE_MAP.undoStatus(4);
                return;
            }
            success = false;
        }
    }

    public void end() {
        OUTPUT_VIEW.printResult();
        OUTPUT_VIEW.printMap(BRIDGE_MAP);
        OUTPUT_VIEW.printComplete(success);
        OUTPUT_VIEW.printTryCount(tryCount);
    }
}