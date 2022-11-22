package bridge.type.suppoter;

import bridge.domain.Player;
import bridge.view.OutputView;

public interface RetrySupporter {

    int reset(Player player, OutputView outputView, int size);
}
