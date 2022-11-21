package bridge.domain;

import bridge.domain.Bridge;
import bridge.utils.constants.Comments;
import bridge.utils.constants.Commons;
import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<List<String>> result;
    int attempts;

    public GameResult() {
        resetResult();
    }

    public List<List<String>> getResult() {
        return result;
    }

    public int getAttempts() {
        return attempts;
    }

    public int calculateTurn(int index) {
        return result.get(index).size();
    }

    public void resetResult() {
        result = new ArrayList<>(Commons.BRIDGE_HEIGHT.getNumber());
        for (int i = Commons.INDEX_ZERO.getNumber(); i < Commons.BRIDGE_HEIGHT.getNumber(); i++) {
            result.add(new ArrayList<>());
        }
        attempts++;
    }

    public boolean isNotGameEnd(int bridgeSize) {
        return !(isGameSuccess(bridgeSize) || isGameFail());
    }

    public boolean isGameSuccess(int bridgeSize) {
        return !isGameFail() && result.get(Commons.INDEX_ZERO.getNumber()).size() == bridgeSize;
    }

    public boolean isGameFail() {
        return result.stream().anyMatch((result) -> result.contains(Comments.UNAVAILABLE.getComment()));
    }

    public void addResult(Bridge bridge, Comments place) {
        result.get(Commons.INDEX_ZERO.getNumber())
                .add(getPlace(Commons.INDEX_ZERO.getNumber(), bridge, place));

        result.get(Commons.INDEX_ONE.getNumber())
                .add(getPlace(Commons.INDEX_ONE.getNumber(), bridge, place));
    }

    private String getPlace(int index, Bridge bridge, Comments place) {
        int turn = calculateTurn(index);
        String bridgePlace = bridge.getBridge().get(turn);
        if (checkAnotherPlace(index, place.getComment())) {
            return Comments.BLANK.getComment();
        }
        return checkEquals(place, bridgePlace);
    }

    /**
     * 위치가 다른지 체크하는 메서드
     * @return 다를 경우 true, 같을 경우 false
     */
    private boolean checkAnotherPlace(int index, String selectedPlace) {
        if (selectedPlace.equals(Comments.UP.getComment()) && index == Commons.INDEX_ONE.getNumber()) {
            return true;
        }
        return selectedPlace.equals(Comments.DOWN.getComment()) && index == Commons.INDEX_ZERO.getNumber();
    }

    /**
     * 위치가 같을 경우, 답인지 아닌지 체크하는 메서드
     */
    private String checkEquals(Comments place, String bridgePlace) {
        if (bridgePlace.equals(place.getComment())) {
            return Comments.AVAILABLE.getComment();
        }
        return Comments.UNAVAILABLE.getComment();
    }
}
