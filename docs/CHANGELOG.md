#### 2022-11-22

##### Documentation Changes

* **guide:**
  *  modify the readmd.md (bb8a02c4)
  *  add readme.md and gitignore (6797597f)

##### New Features

* **BridgeException:**
  *  add exception when the bridge size exceeds the int-type range (8fbe0dcc)
  *  add selecting game command exception (900e2f20)
  *  add bridge choose exception (23536652)
  *  add bridge size exception (bb478fce)
* **OutputView:**
  *  add game result output function (ecab82e2)
  *  add function that outputs the bridge status (a59fd16d)
* **BridgeGame:**
  *  add game retry function (585ffc81)
  *  add function that manage one cycle of games (36c896e8)
  *  add game win check function (a3a0b348)
  *  add function that save bridge status (d230d81d)
* **InputView:**
  *  add retry input function (1735cb61)
  *  add function that choose a bridge to cross (c6790526)
  *  add bridge size input function (90cf78b8)
* **BridgeMaker:**  add bridge generating function (89eef443)
*  setup precourse bridge game project (f10425ea)

##### Refactors

* **BridgeGame:**
  *  modify printResultService() method parameters (07245952)
  *  transfer the execution position of the game output function (5c1a8231)
  *  simplify bridge one game method (6256a77e)
* **InputView:**  remove unnecessary static (797665e9)
*  static elimination and use of hierarchical structures (21a004c1)
* **Application:**
  *  refactoring an application structure (1f560082)
  *  simplify the main method (2d8aaacb)
* **OutputView:**
  *  reduce the parameters (1a5e71f3)
  *  reduce parameters and change the return type (bb04571f)
  *  simplify print map method (3f5f12e1)
* **controller:**  add controller package (d019308d)
* **BridgeCommand:**  remove hardcoded characters (035d23d2)

##### Tests

* **ApplicationTest:**
  *  add game final result screen output function test (2eb1a650)
  *  add a few tests (f3f78d6a)

