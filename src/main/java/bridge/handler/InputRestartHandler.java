package bridge.handler;

import bridge.view.PrintView;

public class InputRestartHandler {

    private String restart;

    public String checkValidator(String restart) {
        checkNonInput(restart);
        checkQuitOrRestart(restart);
        this.restart = restart;

        return restart;
    }

    public void checkQuitOrRestart(String restart) {
        PrintView printView = new PrintView();

        if(!restart.equals("Q") && !restart.equals("R")){
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 잘못된 재시작 여부의 입력입니다. 다시 입력해주세요.");
        }
    }

    public void checkNonInput(String restart){
        PrintView printView = new PrintView();

        if(restart.length() == 0) {
            throw new IllegalArgumentException(printView.ERROR_ORDER+" 재시작 여부의 입력이 되지 않았습니다.");
        }
    }
}
