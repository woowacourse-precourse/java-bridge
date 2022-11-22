package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserMap {
    private List<List<String>> userMap;

    public void buildUserMap(List<String> bridge) {
        userMap = new ArrayList<>();
        for (String icon : bridge) {
            List<String> block = new ArrayList<>(Collections.nCopies(Direction.values().length, " "));
            block.set(Direction.valueOfIcon(icon).getUserMapRow(), "O");
            userMap.add(block);
        }
    }

    public void updateUserMap (int cur, boolean moveSuccess) {
        if (!moveSuccess) {
            List<String> newBlock = new ArrayList<>();
            for (String piece : userMap.get(cur - 1)) {
                newBlock.add(piece.replace("O", "X"));
            }
            userMap.set(cur, newBlock);
        }
    }

    public List<List<String>> getUserMap() {
        return userMap;
    }
}
