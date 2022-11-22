package bridge.service;

import bridge.service.itf.CheckService;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBridgeGame {
    static final BridgeDrawer bridgeDrawer = new BridgeDrawer();
    static final CheckService checkService = new CheckServiceImpl();
    public static final List<String> userDirection = new ArrayList<>();
}
