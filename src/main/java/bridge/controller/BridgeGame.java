package bridge.controller;

import java.util.List;
import java.util.Objects;

import bridge.domain.BridgeMaker;
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
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<String> answer;
    private String input;
    private boolean success = true;
    private int repeat;
    private int tryCount = 1;

    public void start() {
        outputView.printStart();
        outputView.printLengthInput();
        repeat = inputView.readBridgeSize();
        answer = bridgeMaker.makeBridge(repeat);
        play();
    }

    public void play() {
        for(int i=0; i < repeat && success; i++){
            move();
            if(!Objects.equals(input, answer.get(i))) {
                retry();
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.printMoveInput();
        input = inputView.readMoving();
        outputView.printMap();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        success = false;
        outputView.printRetry();
        if(Objects.equals(inputView.readGameCommand(), "R")){
            success = true;
            repeat += 1;
            tryCount += 1;
        }
        if (Objects.equals(inputView.readGameCommand(), "Q")) {
            end();
        }
    }

    public void end() {
        outputView.printResult();
        outputView.printMap();
        outputView.printComplete(success);
        outputView.printTryCount(tryCount);
    }
}