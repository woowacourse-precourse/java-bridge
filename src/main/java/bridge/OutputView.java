package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final StringBuilder upViewBuilder;
    private final StringBuilder downViewBuilder;
    private boolean checkIsCalled;

    public OutputView() {
        this.upViewBuilder = new StringBuilder();
        this.downViewBuilder = new StringBuilder();
        this.checkIsCalled = Boolean.FALSE;
    }

    //application 에서 코드 줄이기 위해 병합.
    public void printGettingStart() {
        printStartMessage();
        askBridgeSize();
    }

    public void askCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapViewDto viewDto) {
        final String notSelectedResult = " ";
        MapViewModel selectedModel = createModel(selectBuilderUpOrDown(viewDto),
                getResultToPrint(viewDto));
        StringBuilder notSelectedBuilder = getNotSelectedBuilder(selectedModel.getViewBuilder());
        MapViewModel notSelectedModel = createModel(notSelectedBuilder, notSelectedResult);
        handleBuilderByModel(selectedModel, notSelectedModel);
        printEachBuilder();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean result, int attemptCount) {
        System.out.println("최종 게임 결과");
        printEachBuilder();
        System.out.println("게임 성공 여부: " + mapToStringResult(result));
        System.out.println("총 시도한 횟수: " + attemptCount);
    }

    public void askReplay() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    //printResult
    private String mapToStringResult(boolean result) {
        if (result) {
            return "성공";
        }
        return "실패";
    }

    //printGettingStart
    private void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    //printGettingStart
    private void askBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    //printMap
    private void handleBuilderByModel(MapViewModel selectedModel,
                                      MapViewModel notSelectedModel) {
        if (checkIsCalled) {
            makeStringIfCalled(selectedModel.getViewBuilder(), selectedModel.getViewResult());
            makeStringIfCalled(notSelectedModel.getViewBuilder(), notSelectedModel.getViewResult());
            return;
        }
        makeStringIfNotCalled(selectedModel.getViewBuilder(), selectedModel.getViewResult());
        makeStringIfNotCalled(notSelectedModel.getViewBuilder(), notSelectedModel.getViewResult());
    }

    //printMap
    private MapViewModel createModel(StringBuilder builder, String result) {
        return new MapViewModel(builder, result);
    }

    //printMap
    private void printEachBuilder() {
        System.out.println(upViewBuilder);
        System.out.println(downViewBuilder);
    }

    //printMap
    private StringBuilder getNotSelectedBuilder(StringBuilder selectedBuilder) {
        if (selectedBuilder.equals(upViewBuilder)) {
            return downViewBuilder;
        }
        return upViewBuilder;
    }

    //printMap
    private String getResultToPrint(MapViewDto viewModel) {
        if (viewModel.getResult()) {
            return "O";
        }
        return "X";
    }

    //printMap
    private StringBuilder selectBuilderUpOrDown(MapViewDto viewModel) {
        if (viewModel.getSelectedBridge().equals("UP")) {
            return upViewBuilder;
        } else if (viewModel.getSelectedBridge().equals("DOWN")) {
            return downViewBuilder;
        }
        //지워도 될거 같지만 일단 남겨둠.
        throw new IllegalArgumentException("UP or DOWN 만 가능합니다.");
    }

    //printMap
    private void makeStringIfCalled(StringBuilder builder, String result) {
        builder.replace(builder.length() - 1, builder.length(), "| ");
        builder.append(result);
        builder.append(" ]");
    }

    //printMap
    private void makeStringIfNotCalled(StringBuilder builder, String result) {
        builder.append("[ ");
        builder.append(result);
        builder.append(" ]");
        this.checkIsCalled = Boolean.TRUE;
    }

}
