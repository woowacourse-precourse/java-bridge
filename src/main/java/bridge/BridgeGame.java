package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> tryAnswer = new ArrayList<>();
    static int count = 1;
    public void move(List<String> makeBridge) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        for(int i = 0;i< makeBridge.size();i++) {
            String pInput = inputView.readMoving();

            tryAnswer.add(i,pInput);
            outputView.printMap(tryAnswer,makeBridge);

        }
        outputView.printResult(count,0,tryAnswer,makeBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> makeBridge) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String retry = inputView.readGameCommand();

        if(retry == "R") {
            count++;
            tryAnswer.clear();
            move(makeBridge);
        }
        if(retry == "Q") outputView.printResult(count,1,tryAnswer,makeBridge);
    }
}
