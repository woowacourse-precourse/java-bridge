package bridge.boundary;

import bridge.logger.Logger;

public interface Console {

    static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (IllegalStateException e) {
            Logger.error("this scanner is closed");
            throw new IllegalArgumentException(e);
        }
    }
}
