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
* **play()**
    * simulates play bridge game
* **result()**
    * simulates finish and show result

### Function.java

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
* **printMapLine()**
    * print current bridge state about one line
* **printStart()**
    * print start message
* **printGetLength()**
    * print message for getting length of bridge
* **printGetMoving()**
    * print message for getting next move
* **printRetry()**
    * print message for retrying
* **printError()**
    * print error message