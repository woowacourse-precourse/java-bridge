package bridge.engine.state;

import bridge.engine.reporter.BridgeResult;

/**
 * 브릿지 게임의 상태(START, MOVE, RETRY, END)별로 행동을 정의한 인터페이스
 * */
public interface BridgeState {

    void start(int size);
    boolean move(String direction);
    boolean retry(String command);
    BridgeResult end();
}
