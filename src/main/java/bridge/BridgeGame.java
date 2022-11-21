package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    boolean retryOrNot;
    private String failSuccess;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridgeList, String upDownUserInput, int order) {
        if (bridgeList.get(order).equals(upDownUserInput)){
            /** get을 사용하지 않는다?
             *
             */
            //그러면 맞은 것을 나타낸다.

            return true;
        }
        //그러면 안맞은 것을 출력한다.
        return false;


    }




    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retryUserInput = inputView.readGameCommand();
        if (retryUserInput.equals("R")){
            return true;
        }
        return false;
    }
}
