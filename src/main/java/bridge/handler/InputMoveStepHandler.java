package bridge.handler;

import bridge.view.PrintView;

public class InputMoveStepHandler {
    private String moveStep;

    public String checkValidator(String moveStep) {
        checkNonInput(moveStep);
        checkIsUpDown(moveStep);

        return moveStep;
    }

    public void checkIsUpDown(String moveStep) {
        PrintView printView = new PrintView();
        if(!moveStep.equals("U") && !moveStep.equals("D")){
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 잘못된 이동 입력입니다. 다시 입력해주세요.");
        }
    }

    public void checkNonInput(String moveStep){
        PrintView printView = new PrintView();

        if(moveStep.length() == 0) {
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 다리 길이의 값이 입력되지 않았습니다.");
        }
    }
}
