## Bridge Game

### Application.java

* **main()**
    * do a bridge game

### BridgeGame.java

* **BridgeGame class**
    * **move()**
        * move steps on bridge
    * **retry()**
        * check game command to restart or exit game
    * **check()**
        * check whether reached to end of the bridge
    * **getBridge()**
        * return bridge
    * **getLocate()**
        * return locate
    * **getTrial()**
        * return trial

### BridgeMaker.java

* **makeBridge()**
    * make bridge size of input by random choose

### BridgeRandomNumberGenerator.java

* **generate()**
    * generate random number within RANDOM_LOWER_INCLUSIVE to RANDOM_UPPER_INCLUSIVE

### Controller.java

* **start()**
    * simulates start and initialization
* **movement()**
    * simulates one move forward
* **play()**
    * simulates play bridge game
* **finish()**
    * simulates retry or finish game
* **result()**
    * simulates finish and show result
* **getBridgeLength()**
    * return bridge length if it is valid
* **getMoving()**
    * return moving sign if it is valid
* **getCommand()**
    * return game command if it is valid

### Function.java

* **validCastingBridgeSize()**
    * check whether input is integer or not
* **validBridgeSize()**
    * check whether bridge size is valid or not
* **validMoving()**
    * check whether moving command is valid or not
* **validGameCommand()**
    * check whether game command is valid or not

### view.InputView.java

* **readBridgeSize()**
    * read bridge size from user
* **readMoving()**
    * read moving command from user
* **readGameCommand()**
    * read game command from user

### view.OutputView.java

* **printMap()**
    * print current bridge state
* **printResult()**
    * print result of the game
* **printStart()**
    * print start message
* **printMapLine()**
    * print current bridge state about one line
* **printMapContent()**
    * print map content for one line
* **printMapSuffix()**
    * print map suffix for one line
* **printGetLength()**
    * print message for getting length of bridge
* **printGetMoving()**
    * print message for getting next move
* **printRetry()**
    * print message for retrying
* **printError()**
    * print error message