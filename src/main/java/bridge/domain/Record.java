package bridge.domain;

import static bridge.domain.MoveDirection.*;

public final class Record {
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String DELIMITER = "|";
    private static final String MATCH = "O";
    private static final String NOT_MATCH = "X";
    private static final String BLANK = " ";

    private Record() {

    }

    public static String getTopLane(UsersRoute usersRoute, Bridge bridge) {
        StringBuilder topLane = new StringBuilder(START_BRACKET);
        createTopLane(topLane, usersRoute, bridge);
        topLane.replace(topLane.length() - 1, topLane.length(), END_BRACKET);
        return topLane.toString();
    }

    public static String getBottomLane(UsersRoute usersRoute, Bridge bridge) {
        StringBuilder bottomLane = new StringBuilder();
        createBottomLane(bottomLane, usersRoute, bridge);
        bottomLane.replace(bottomLane.length() - 1, bottomLane.length(), END_BRACKET);
        return bottomLane.toString();
    }

    private static void createTopLane(StringBuilder topLane, UsersRoute usersRoute, Bridge bridge) {
        for (int index = 0; index < usersRoute.getRoute().size(); index++) {
            if (usersRoute.getRoute().get(index).equals(UP.getAlphabetCode())) {
                topLane.append(getMatchToken(index, usersRoute.getRoute().get(index), bridge));
                topLane.append(DELIMITER);
                continue;
            }
            topLane.append(BLANK);
            topLane.append(DELIMITER);
        }
    }

    private static void createBottomLane(StringBuilder bottomLane, UsersRoute usersRoute, Bridge bridge) {
        for (int index = 0; index < usersRoute.getRoute().size(); index++) {
            if (usersRoute.getRoute().get(index).equals(DOWN.getAlphabetCode())) {
                bottomLane.append(getMatchToken(index, usersRoute.getRoute().get(index), bridge));
                bottomLane.append(DELIMITER);
                continue;
            }
            bottomLane.append(BLANK);
            bottomLane.append(DELIMITER);
        }
    }

    private static String getMatchToken(int index, String direction, Bridge bridge) {
        if (bridge.matches(index, direction)) {
            return new String(MATCH);
        }
        return new String(NOT_MATCH);
    }
}
