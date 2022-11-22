#### 1.0.0 (2022-11-22)

##### Documentation Changes

* **README:**
  *  add exception docs content (5e3a9d63)
  *  supplement 기능 구현 목록 (433722cd)
  *  supplement 기능 구현 목록 (550fd988)
  *  make 기능 구현 목록 (b127ab74)

##### New Features

* **VaildatorRetryQuit:**  seperate Validator Retry Quit User input (63f40389)
* **VaildatorUpDown:**  seperate validator Up Down user input (3a3b0d86)
* **UserInput:**  seperate method and class for OOB (269698d3)
* **ValidatorBridgeSize:**  implement validate bridge size user input (a9dec4c1)
* **OutputView:**
  *  add final comment message (b7e9afb4)
  *  implement map 2 dimension and test (1cfad483)
  *  implement map create and print test on second input (073f9376)
  *  implement printmap (f61aff67)
* **BridgeGame:**
  *  implement 2 dimension test at wrong case (c4eb3b06)
  *  add print map (f3ab016c)
  *  implement bridge game all function (519a0b77)
  *  implement retry or not judment (35dfabcb)
  *  implement bridge correct or wrong judgement (045ccaef)
* **BridgeMake:**  implement makeBridge method (3831d1a8)
* **InputView:**  implement input method (8e61bdde)
*  setup precourse bridge game project (f10425ea)

##### Bug Fixes

* **BridgeGameTest:**  fix error to avoid overlap effect (3194c6d8)
* **BridgeGame:**
  *  제약상황 지키기와 에러 수정 (8333e2de)
  *  change reset map method (d383d6cd)
* **OutputView:**  fix final result print error (6d091390)
* **OutputViewTest:**  fix override list (74f0947e)

##### Refactors

* **BridgeGame:**
  *  change list to stringbuilder to less memory (c6a0e0bf)
  *  sum bridgeGame and GameJudge class (d438ce5d)
  *  change method parameter (4f64fe10)
  *  add origin to use enum class simplely (752aa849)
* **OutputView:**  delete enum class and style (64c190ae)
* **GameJudge:**  create new class which make judgement (e2206652)
* **Application:**
  *  change method (66503abd)
  *  refactor application class (64e95358)

##### Code Style Changes

*  check code convention (0c0ff3c3)
*  style and rename (729ca836)
* **Constant:**  make constant class and change constant (8dda50c5)
* **InputView:**  remove exception in InputView to seperate class (4ee0bb21)
* **BridgeGame:**  remove duplication method (50781de8)
* **JudgeGame:**  delete the class (e562a885)
* **GameJudge:**  change method parameter (450f88f2)
* **BridgeGameTest:**  comment BridgeGameTest to change (6a559d78)

##### Tests

* **VaildatorUpDownTest:**  test vaildator up down (463e23b4)
*  test vaildator user input bridge size, R&Q (9abb6995)
*  test Bridge Game and Bridge Maker class (798447ab)
* **BridgeGameTest:**
  *  implement 2 dimension test (541d3020)
  *  test bridge game when user was wrong (02e2083b)
  *  test bridge game (a5f27b05)
* **OutputViewTest:**  implement map create and print test at first input (f1ed1db7)
* **BridgeMakerTest:**  implement random number list size test (0dacff78)

#### 1.0.0 (2022-11-18)

##### New Features

*  setup precourse bridge game project (f10425ea)

