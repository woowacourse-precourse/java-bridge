package bridge.service;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBridgeDrawer {
    static List<String> directionTypeUP = new ArrayList<>();
    static List<String> directionTypeDOWN = new ArrayList<>();
    public static List<List<String>> directionTypeLists = new ArrayList<>();
    ResultServiceImpl resultService = new ResultServiceImpl();
}
