package bridge.handler;

import bridge.view.OrderView;

public class InputMoveStepHandler {

    private String moveStep;

    public String checkValidator(String moveStep) {
        checkNonInput(moveStep);
        checkIsUpDown(moveStep);
        this.moveStep = moveStep;

        return moveStep;
    }

    private void checkIsUpDown(String moveStep) {
        OrderView orderView = new OrderView();
        if(!moveStep.equals("U") && !moveStep.equals("D")){
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 잘못된 이동 입력입니다. 다시 입력해주세요.");
        }
    }

    private void checkNonInput(String moveStep){
        OrderView orderView = new OrderView();

        if(moveStep.length() == 0) {
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 다리 길이의 값이 입력되지 않았습니다.");
        }
    }
    
    
}
