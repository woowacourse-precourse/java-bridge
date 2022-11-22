#### 2022-11-21

##### Chores

* **view:**  change field names(messages) (27e31d3e)

##### Documentation Changes

* **bridge:**
  * update feature list according to refactored class (e6cae13b)
  * make the first feature list (f858692e)

##### New Features

* **bridge:**
  * revise inputView methods where user can make input read after error occured. (9e270775)
  * create run method in BridgeGameController, where it control methods along game. (34103e33)
  * create enum which has information on messages and output view feature (5a076054)
  * create BridgeGameController class (3d4fb830)
  * create BridgeMaker class, makeBridge method (0a6c2cc3)
  * create bridgeGame feature, move method (29a36727)
  * create feature which can get length of bridge from user and validate if it is in range. (19b78332)
* **view:**
  * create printResult method in OutputView Class, print result of game (470b2c38)
  * create printMap method in OutputView Class where it can print out map. (80405f91)
  * create readGameCommand method where it gets restart command and validates. (896720e7)
  * create readMoving method which can get user input to move (10a73b30)
  * create enum GameMessages holding message information (af69bd36)
*  setup precourse bridge game project (f10425ea)

##### Bug Fixes

* **bridge:** run method bug fix (9d32782d)

##### Other Changes

* **bridge:** delete unneccesary javadocs. (d367cd64)

##### Refactors

* **view:** refactor printResult method in OutputView (dc78b368)
* **bridge:**
  * delete private bridge index field (be234d32)
  * refactor run method into crossBridge and other private methods (6f14533a)
  * delete unnecessary method and refactor. (a7c398a9)
  * refactor showResult method in BridgeGameController Class. (a2e3094b)
  * refactor BridgeGameController methods into private methods. (deb0f41b)

##### Code Style Changes

* **bridge:** style code with CheckStyle (271d4c6b)

##### Tests

* **bridge:**
  * create generateBridge method test in BridgeGameController Class (c841a963)
  * create unit test for InputView Class (a044c063)
  * create unit test for makeMove method in BridgeGameProcessor class (93dccad4)
  * create unit test for bridgeGameController Class (1a559ec2)
  * create unit test for BridgeMaker Class (de16653e)
  * create unit test for BridgeGame class (e6e2b9dc)
  * create new tests for quit and retry game. (9fea08e7)

