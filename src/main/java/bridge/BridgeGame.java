package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private int counter;
    private List<String> bridges;
    private List<String> userMoves;
    private boolean finished;
    private boolean aborted;
    private OutputView outputView;
    private InputView inputView;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        userMoves.add(moving);
        processGame();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String cmd) {
        if (cmd.equals("Q")) return;
        this.aborted = false;
        this.finished = false;
        this.counter += 1;
        userMoves.remove(userMoves.size() - 1);
    }

    /**
     * 생성시 필요한 정보들을 init() 한다.
     */
    public void init() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.userMoves = new LinkedList<>();
        this.counter = 1;
        this.finished = false;
        this.aborted = false;
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void setBridgeSize(int n) {
        this.bridges = bridgeMaker.makeBridge(n);
    }

    /**
     * 게임이 종료되었는 지 확인합니다.
     * @return 종료된 경우 true, 진행 중인 경우 false
     */
    public boolean isFinished() {
        return this.finished;
    }

    /**
     * 게임이 오답 등의 사유로 비정상종료 되었는 지 확인합니다,
     * @return 비정상종료
     */
    public boolean aborted() {
        return this.aborted;
    }

    /**
     * 게임 최종 결과가 성공/실패로 끝났는 지 값을 돌려줍니다.
     * @return 성공시 true, 실패시 false
     */
    public boolean succeed() {
        return this.finished && !this.aborted;
    }

    /**
     * 게임 중 이동 횟수를 돌려준다.
     * @return 이동 횟수
     */
    public int getTries() {
        return this.counter;
    }

    /**
     * 사용자가 입력한 값을 기반으로 게임을 진행한다.
     *  - finished : 게임이 종료 되었는지 체크
     *  - aborted  : 게임이 비정상 종료 되었는지 체크
     *  변수의 값이 변경된다.
     */
    private void processGame() {
        for (int order = 0; order < userMoves.size(); order++) {
            if (!isValidMove(userMoves.get(order), bridges.get(order))) {
                aborted = true;
                finished = true;
                return ;
            }
        }
        aborted = false;
        finished = (userMoves.size() == bridges.size());
    }

    public List<String> getBridges() {
        return bridges;
    }

    public List<String> getUserMoves() {
        return userMoves;
    }

    /**
     * 유저가 이동한 공간이 유효한지 확인한다
     * @param userMove 유저의 선택
     * @param bridge 사다리 위치
     * @return 유저의 선택에 사다리 위치가 있는가?
     */
    private boolean isValidMove(String userMove, String bridge) {
        return userMove.equals(bridge);
    }

    /**
     * 게임 시작
     */
    public void start() {
        init();
        outputView.printGameStart();
        outputView.printReadBridgeLength();
        setBridgeSize(inputView.readBridgeSize());
    }

    /**
     * 게임을 진행하는 핵심 루프
     */
    public void loop() {
        while (!this.isFinished()) {
            outputView.printReadNextBridgeStep();
            this.move(inputView.readMoving());
            outputView.printMap(this);
            if (this.aborted()) {
                outputView.printRestart();
                this.retry(inputView.readGameCommand());
            }
        }
    }

    /**
     * 게임을 마무리 짓고 결과를 출력하는 루프
     */
    public void finish() {
        outputView.printTotalMap(this);
        outputView.printResult(this.succeed(), this.getTries());
    }
}
