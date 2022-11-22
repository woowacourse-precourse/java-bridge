package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    // 입력받는 View 클래스
    private InputView gameInput;
    // 출력하는 View 클래스
    private OutputView gameOutput;

    // 정답 문자열 저장하는 문자열 리스트
    private List<String> bridge;
    // 사용자 입력을 저장하는 문자열 리스트
    private List<String> userInput;
    // 사용자 try 횟수 및 다음 횟수 인덱스
    private int tries;

    public BridgeGame() {
        gameInput = new InputView();
        gameOutput = new OutputView();

        bridge = new ArrayList<>();
        userInput = new ArrayList<>();
        tries = 0;
    }
    /**
     * 사용자의 전체 게임 종료까지의 과정
     * while문으로 반복
     * 게임의 한 사이클은 한 번의 play 함수 호출로 수행
     */
    void init() {
        boolean status = true;
        while(status) {
            clear();
            status = play();
        }
    }

    // 매 게임 사이클마다 다시 시작하기 위해 갱신해 줘야 함
    void clear() {
        bridge.clear();
        userInput.clear();
        tries = 0;
    }

    /**
     *
     * @return 다음 게임을 수행할 지 아닐 지에 대한 입력 - true : 다음 게임 수행 / false : 다음 게임을 수행하지 않음
     */
    boolean play() {


        //
        return retry();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String input = gameInput.readGameCommand();
        return true;
    }

    /**
     * 특정 조건을 맞추지 못할 시 Exception을 던지기 위한 메서드
     * 각 검증 함수에서 조건에 맞지 않으면 Exception을 던지기 위함
     */
    public void catchErrors(boolean condition, String message) {
        if(condition) {
            return;
        }
        throw new IllegalArgumentException(message);
    }
}
