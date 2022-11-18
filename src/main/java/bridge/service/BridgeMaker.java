package bridge.service;

import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public interface BridgeMaker {

    List<String> makeBridge(int size);
}
