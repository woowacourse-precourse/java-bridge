package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridgeList) {
        // 몇개 만들지 숫자 받기
        // 랜덤 다리 만들기
        // 어디 건널지 입력 받기 (여기까지는 application에 만들어도 될듯?)
        // 맞는지 틀린지 확인

        for (int i = 0; i<bridgeList.size();i++) {
            String upDownUserInput = inputView.readMoving();

            if (Compare(bridgeList,upDownUserInput,i)){
                continue;
            }
            break;
        }
    }

    private boolean Compare(List<String> bridgeList, String s,int number) {
        return true;

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
