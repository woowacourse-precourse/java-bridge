package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String DELIMITER = " | ";
    public static final String JOIN_LIST_FORMAT = "[ %s ]";
    public static final String LOCATION_UP_SELECT = "U";
    public static final String LOCATION_DOWN_SELECT = "D";
    public static void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<BridgeEnum> bridgeLocations) {
        return new StringJoiner("\n")
                .add(createBridgeMap(bridgeLocations, LOCATION_UP_SELECT))
                .add(createBridgeMap(bridgeLocations, LOCATION_DOWN_SELECT)).toString();
    }

    private String createBridgeMap(List<BridgeEnum> bridgeLocations, String location) {
        StringJoiner bridge = new StringJoiner(DELIMITER);
        bridgeLocations.stream()
                .map(bridgeLocation -> bridgeLocation.getStateLocation(location))
                .forEach(bridge::add);
        return String.format(JOIN_LIST_FORMAT,bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
