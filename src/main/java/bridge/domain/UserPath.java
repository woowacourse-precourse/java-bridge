package bridge.domain;

import bridge.enums.Sign;

import java.util.ArrayList;
import java.util.List;

/**
 * 유저가 이동한 경로를 알려준다.
 */
public class UserPath {
    private List<String> upperPath, lowerPath;

    public UserPath(UserMovement userMovement, Bridge bridge) {
        this.upperPath = getUpperPath(userMovement, bridge);
        this.lowerPath = getLowerPath(userMovement, bridge);
    }

    /**
     * 입력(x)가 "U"인 경우에 다리 정보와 일치한다면 "O", 일치하지 않는다면, "X". 그 외의 경우엔 " ". 반환한다.
     *
     * @param cell
     * @param isSame
     * @return "O" 또는 "X" 또는 " "
     */
    private String getUpperSign(String cell, Boolean isSame) {
        if (cell.equals("U")) {
            if (isSame) {
                return Sign.CORRECT.getSign();
            }
            return Sign.WRONG.getSign();
        }
        return Sign.BLANK.getSign();
    }

    /**
     * 입력(x)가 "D"인 경우에 다리 정보와 일치한다면 "O", 일치하지 않는다면, "X". 그 외의 경우엔 " ". 반환한다.
     *
     * @param cell
     * @param isSame
     * @return "O" 또는 "X" 또는 " "
     */
    private String getLowerSign(String cell, Boolean isSame) {
        if (cell.equals("D")) {
            if (isSame) {
                return Sign.CORRECT.getSign();
            }
            return Sign.WRONG.getSign();
        }
        return Sign.BLANK.getSign();
    }

    /**
     * 유저 움직임의 위쪽 결과를 반환한다.
     *
     * @param userMovement 유저의 움직임 정보
     * @param bridge       다리 정보
     * @return 각 칸마다 "O", "X", " "의 정보를 담은 결과
     */
    private List<String> getUpperPath(UserMovement userMovement, Bridge bridge) {
        List<String> compareTarget = userMovement.getUserMovement();
        List<Boolean> compareResult = bridge.compareWithUserMovement(compareTarget);

        List<String> upperCell = new ArrayList<>();
        for (int index = 0; index < compareTarget.size(); index++) {
            upperCell.add(getUpperSign(compareTarget.get(index), compareResult.get(index)));
        }
        return upperCell;
    }

    /**
     * 유저 움직임의 아래쪽 결과를 반환한다.
     *
     * @param userMovement 유저의 움직임 정보
     * @param bridge       다리 정보
     * @return 각 칸마다 "O", "X", " "의 정보를 담은 결과
     */
    private List<String> getLowerPath(UserMovement userMovement, Bridge bridge) {
        List<String> compareTarget = userMovement.getUserMovement();
        List<Boolean> compareResult = bridge.compareWithUserMovement(compareTarget);

        List<String> lowerCell = new ArrayList<>();
        for (int index = 0; index < compareTarget.size(); index++) {
            lowerCell.add(getLowerSign(compareTarget.get(index), compareResult.get(index)));
        }
        return lowerCell;
    }

    /* toString 사용을 고려해본다 */

    public List<String> getUpperPath() {
        return upperPath;
    }

    public List<String> getLowerPath() {
        return lowerPath;
    }
}
