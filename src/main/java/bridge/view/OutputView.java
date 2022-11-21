package bridge.view;


import bridge.domain.StageResult;
import bridge.validator.Unit;

import java.util.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private Map<Unit, Stack<String>> userInputMap = Map.of(
            Unit.UP, new Stack<String>(),
            Unit.DOWN, new Stack<String>());

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String userInput, StageResult stageResult) {
        String result = decideOX(stageResult);
        Unit key = decideUpDown(userInput);
        saveUserInput(key, result);
    }

    public String decideOX(StageResult stageResult) {
        if(stageResult == StageResult.PASS || stageResult == StageResult.SUCCESS) {
            return "O";
        }
        return "X";
    }

    public Unit decideUpDown(String userInput) {
        if(userInput.equals(Unit.UP.getCommand())) {
            return Unit.UP;
        }
        return Unit.DOWN;
    }

    public void saveInput(Unit key, String result) {
        checkBrackets(key);
        userInputMap.get(key).add(result);
        addCloseBrackets(key);
    }


    public void checkBrackets(Unit key) {
        checkStackIsEmpty(key);

        if(userInputMap.get(key).peek().equals("]")) {
            userInputMap.get(key).pop();
            userInputMap.get(key).add("|");
        }
    }

    public void addCloseBrackets(Unit key) {
        userInputMap.get(key).add("]");
    }

    public void checkStackIsEmpty(Unit key) {
        if(userInputMap.get(key).empty()) {
            userInputMap.get(key).add("[");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMessage(Messages message) {
        System.out.println(message.getMessage());
    }
}
