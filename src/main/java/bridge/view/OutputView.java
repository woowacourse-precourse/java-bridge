package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LINE = System.lineSeparator();
    private static final String OUTPUT_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String OUTPUT_RESULT_MESSAGE = LINE + "최종 게임 결과" ;
    private static final String OUTPUT_RESULT_IS_SUCCESS = LINE + "게임 성공 여부: " ;
    private static final String OUTPUT_RESULT_TRY_NUMBER = "총 시도한 횟수: " ;
    private static final String OPEN = "[ ";
    private static final String CLOSE = " ]";
    private static final String DIVISION = "| ";
    private static final String NONE = " ";

    private String currentStateOfBridge;
    private boolean isFirst;
    private int attempt = 0;

    public void printStart() {
        System.out.println(OUTPUT_START_MESSAGE);
    }

    public void initBridgeState(){
        this.currentStateOfBridge = NONE + "\n" + NONE;
        this.isFirst = true;
        this.attempt += 1;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String right, int upOrDown) {
        String[] splitMap = currentStateOfBridge.split("\\n");
        if(!this.isFirst) {
            splitMap = notFirstPrintMap(splitMap, right, upOrDown);
        }
        if (this.isFirst){
            splitMap = firstPrintMap(splitMap, right, upOrDown);
        }
        currentStateOfBridge = splitMap[0] + "\n" + splitMap[1];
        System.out.println(currentStateOfBridge);
    }

    private String[] firstPrintMap(String[] splitMap, String right, int upOrDown){
        this.isFirst = false;
        splitMap[upOrDown] = OPEN + right + CLOSE;
        splitMap[(upOrDown + 1) % 2] = OPEN + NONE + CLOSE;
        return splitMap;
    }

    private String[] notFirstPrintMap(String[] splitMap, String right, int upOrDown){
        splitMap[upOrDown] = splitMap[upOrDown].substring(0, splitMap[upOrDown].length() - 1) + DIVISION + right + CLOSE;
        splitMap[(upOrDown + 1) % 2] = splitMap[(upOrDown + 1) % 2].substring(0, splitMap[(upOrDown + 1) % 2].length() - 1) + DIVISION + NONE + CLOSE;
        return splitMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + LINE +  currentStateOfBridge);
        System.out.println(OUTPUT_RESULT_IS_SUCCESS + result);
        System.out.println(OUTPUT_RESULT_TRY_NUMBER + this.attempt);
        initAttempt();
    }

    void initAttempt(){
        this.attempt = 0;
    }

}
