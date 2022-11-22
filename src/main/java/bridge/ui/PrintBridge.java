package bridge.ui;

import bridge.ui.resource.GameResource;

import java.util.List;

public class PrintBridge {
    //OutputView.printMap()을 도와주는 클래스
    //입력에 따라 출력해야 되는 문자 행을 계산
    public static String createRow(String UorD, List<String> user, List<String> ans) {
        String row = GameResource.ROW_OPEN.content();

        for (int index = 0; index < user.size(); index++) {
            row += getSign(UorD, user.get(index), ans.get(index));
            row += GameResource.ROW_MID.content();
        }

        row = row.substring(0, row.length() - 1);
        row += GameResource.ROW_CLOSE.content();
        return row;
    }

    private static String getSign(String UorD, String user, String ans) {
        if (user.equals(UorD)) {
            if (user.equals(ans))
                return GameResource.GUESS_RIGHT.content();
            return GameResource.GUESS_WRONG.content();
        }
        return GameResource.GUESS_NOTHING.content();
    }
}
