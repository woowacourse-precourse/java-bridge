package bridge.view;


import bridge.domain.BridgeStage;
import bridge.domain.StageResult;
import bridge.validator.Unit;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private Map<Unit, Stack<String>> userInputMap = Map.of(
            Unit.UP, new Stack<>(),
            Unit.DOWN, new Stack<>());

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String userInput, StageResult stageResult) {
        makeMap(userInput, stageResult);

        String result = convertMapToString();

        System.out.println(result);
    }

    public void makeMap(String userInput, StageResult stageResult) {
        String result = decideOX(stageResult);
        Unit key = decideUpDown(userInput);

        saveUserInput(key, result);
        saveOppositeSide(key);
    }

    public String decideOX(StageResult stageResult) {
        if(stageResult == StageResult.PASS || stageResult == StageResult.SUCCESS) {
            return Unit.O.getCommand();
        }
        return Unit.X.getCommand();
    }

    public Unit decideUpDown(String userInput) {
        if(userInput.equals(Unit.UP.getCommand())) {
            return Unit.UP;
        }
        return Unit.DOWN;
    }


    public void saveUserInput(Unit key, String result) {
        save(key, result);
    }

    public void saveOppositeSide(Unit key) {
        Unit oppositeKey = findOppositeKey(key);

        save(oppositeKey, Unit.BLANK.getCommand());
    }

    public void save(Unit key, String result) {
        checkBrackets(key);
        userInputMap.get(key).add(result);
        addCloseBrackets(key);
    }

    public Unit findOppositeKey(Unit key) {
        if(key == (Unit.UP)) {
            return Unit.DOWN;
        }

        return Unit.UP;
    }

    public void checkBrackets(Unit key) {
        checkStackIsEmpty(key);

        Stack<String> inputRecord = userInputMap.get(key);
        if(inputRecord.peek().equals(Unit.RIGHT_BRACKET.getCommand())) {
            inputRecord.pop();
            inputRecord.add(Unit.VERTICAL_BAR.getCommand());
        }
    }

    public void addCloseBrackets(Unit key) {
        userInputMap.get(key).add(Unit.RIGHT_BRACKET.getCommand());
    }

    public void checkStackIsEmpty(Unit key) {
        Stack<String> inputRecord = userInputMap.get(key);

        if(inputRecord.isEmpty()) {
            inputRecord.add(Unit.LEFT_BRACKET.getCommand());
        }
    }

    public String stackToString(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();

        List<String> userInput =  new ArrayList<>(stack);

        for(String input : userInput) {
            sb.append(input);
        }

        return sb.toString();
    }

    public String convertMapToString() {
        StringBuilder sb = new StringBuilder();

        String upSide = stackToString(userInputMap.get(Unit.UP));
        String downSide = stackToString(userInputMap.get(Unit.DOWN));

        sb.append(upSide).append(Unit.LINE_BREAK.getCommand()).append(downSide).append(Unit.LINE_BREAK.getCommand());

        return sb.toString();
    }

    public void resetMap() {
        userInputMap.get(Unit.UP).clear();
        userInputMap.get(Unit.DOWN).clear();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(StageResult stageResult) {
        printMessage(Messages.VIEW_END);
        print(convertMapToString());

        printSuccessOrFail(stageResult);
        printMessageWithValue(Messages.VIEW_END_TRY_COUNT, String.valueOf(BridgeStage.getRetry()));
    }

    public void printSuccessOrFail(StageResult result) {
        if(result == StageResult.FAIL) {
            printMessageWithValue(Messages.VIEW_END_WIN_OR_LOSE, Unit.FAIL.getCommand());
        }

        if(result == StageResult.SUCCESS) {
            printMessageWithValue(Messages.VIEW_END_WIN_OR_LOSE, Unit.SUCCESS.getCommand());
        }
    }


    public void printMessage(Messages message) {
        System.out.println(message.getMessage());
    }

    public void printMessageWithValue(Messages messages, String value) {
        System.out.println(messages.getMessage() + value);
    }

    public void print(String input) {
        System.out.println(input);
    }
}
