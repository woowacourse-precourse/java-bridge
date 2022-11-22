package bridge.handler;

import bridge.view.OrderView;

public class InputRestartHandler {

    private String restart;
    public String checkValidator(String restart) {
        checkNonInput(restart);
        checkIsUpDown(restart);

        return restart;
    }

    private void checkIsUpDown(String restart) {
        OrderView orderView = new OrderView();

        if(!restart.equals("Q") && !restart.equals("R")){
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 잘못된 재시작 여부의 입력입니다. 다시 입력해주세요.");
        }
    }

    private void checkNonInput(String restart){
        OrderView orderView = new OrderView();

        if(restart.length() == 0) {
            throw new IllegalArgumentException(orderView.ERROR_ORDER+" 재시작 여부의 입력이 되지 않았습니다.");
        }
    }
}
