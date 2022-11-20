package bridge.service;

import bridge.domain.BridgeGameService;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements BridgeGameService {



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * 필드(인스턴스 변수) 추가 가능
     * 메서드 이름 변경 불가
     * 인자, 반환 타입 추가, 변경 가능
     * 메서드 추가/ 변경 가능
     * 해당 클래스 내에서 View 사용 불가능
     */


    @Override
    public void move(String step) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void retry(String command) {
    }

}
