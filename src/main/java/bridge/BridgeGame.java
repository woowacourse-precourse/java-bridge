package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    // 입력받는 View 클래스
    private InputView gameInput;
    // 출력하는 View 클래스
    private OutputView gameOutput;

    // 정답 문자열 저장하는 문자열 리스트
    private List<String> bridge;
    // 사용자 입력을 저장하는 문자열 리스트
    private List<String> userInput;
    // 사용자 try 횟수 및 다음 횟수 인덱스
    private int tries; // 사용자의 총 시도
    private int bridgeLen; // 다리의 길이

    // 하나의 게임 도중 3개 상황 가능, PLAYING이라도 다 하면 CORRECT
    private static int PLAYING = 0;
    private static int WRONG = 1;
    private static int CORRECT = 2;

    private int userStatus;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        gameInput = new InputView();
        gameOutput = new OutputView();

        bridge = new ArrayList<>();
        userInput = new ArrayList<>();
    }
    /**
     * 사용자의 전체 게임 종료까지의 과정
     * while문으로 반복
     * 게임의 한 사이클은 한 번의 play 함수 호출로 수행
     */

    // 매 게임 사이클마다 다시 시작하기 위해 갱신해 줘야 함
    void clear() {
        bridge.clear();
        userInput.clear();
        tries = 0;
        userStatus = PLAYING;
    }

    void init() {
        // 정답은 한 번만 구하기
        setAnswer();
        // 하나의 정답을 가지고 여러 번 틀려서 여러 번 play할 수 있음
        while(userStatus == PLAYING) {
            play();
        }

        gameOutput.printResult(bridge, userInput, userStatus, tries);
    }

    /**
     *
     * @return 다음 게임을 수행할 지 아닐 지에 대한 입력 - true : 다음 게임 수행 / false : 다음 게임을 수행하지 않음
     */
    void play() {
        clear();
        while(userStatus == PLAYING) {
            userStatus = move();
        }
        if(userStatus == CORRECT) {
            return;
        }
        if(userStatus == WRONG) {
            userStatus = retry();
        }
    }

    /**
     * 초기 시작 알림 출력과 함께
     * 다리의 길이 입력받기 및 다리 추가하기
     */
    void setAnswer() {
        String input = gameInput.readBridgeSize();
        this.bridgeLen = checkBridgeLenCommand(input);
        this.bridge = bridgeMaker.makeBridge(this.bridgeLen);
    }

    int checkBridgeLenCommand(String input) {
        int len = input.length();
        catchErrors(len >= 1 && len <= 2, ErrorCodes.ANSWER_ILLEGAL_LENGTH.getMessage());

        int ans = 0;
        char c;
        for(int i = 0; i < len; ++i) {
            ans *= 10;
            c = input.charAt(i);
            catchErrors(c >= '0' && c <= '9', ErrorCodes.ANSWER_ILLEGAL_INPUT.getMessage());
            if(i == 0) {
                catchErrors(c >= '1' && c <= '9', ErrorCodes.ANSWER_ILLEGAL_INPUT.getMessage());
            }
            ans += (c - '0');
        }
        catchErrors(ans >= 3 && ans <= 20, ErrorCodes.ANSWER_ILLEGAL_RANGE.getMessage());
        return ans;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    int move() {
        // 매 시행마다 사용자 입력받고
        String read = gameInput.readMoving();
        // 정답 체크 및 사용자 입력에 추가
        int ans = checkUserInput(read);
        // 중간중간마다 결과 출력해줘야 함
        gameOutput.printMap(this.bridge, this.userInput, this.tries);

        return ans;
    }

    /**
     * 무조건 "U" 혹은 "D만 들어와야 한다.
     * @param input : 입력된 이동할 칸 문자열
     */
    int checkUserInput(String input) {
        // 입력된 문자열이 "U"인지 "D"인지 비교
        String errorMessage = ErrorCodes.USER_ILLEGAL_INPUT.getMessage();
        catchErrors(input.equals("U") || input.equals("D"), errorMessage);
        // 사용자 입력에 넣기
        userInput.add(input);

        // 총 입력받은 횟수가 1 증가
        // 넣은 해당 인덱스가 bridge의 해당 인덱스와 같은지 비교
        boolean status = input.equals(bridge.get(this.tries++));

        // 만약 다르면 재시작해야 함
        if(status == false) {
            return WRONG;
        }
        // 만약 같아도 모두 수행했으면 더 수행할 필요 없음
        if(status == true && tries == bridgeLen) {
            return CORRECT;
        }
        // 맞았고, 더 수행해야 한다면 더 수행한다.
        return PLAYING;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry() {
        String input = gameInput.readGameCommand();
        return checkGameCommand(input);
    }

    /**
     * check whether_next_game input
     * @param input : String - 무조건 "Q"(종료) 혹은 "R"(재시도)만 들어와야 한다
     * @return true : 재시도, false: 종료
     */
    public int checkGameCommand(String input) {
        String errorMessage = ErrorCodes.RETRY_ILLEGAL_INPUT.getMessage();
        // Q와 R 둘 중 어디에도 해당하지 않으면 에러
        catchErrors(input.equals("R") || input.equals("Q"), errorMessage);

        // 둘 중 R에 해당하면 true -> 재시작, Q일 경우 false 반환, 종료하기
        if(input.equals("R")) {
            clear();
            return PLAYING;
        }
        return WRONG;
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
