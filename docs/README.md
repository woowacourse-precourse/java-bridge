# 🛤 다리 건너기 

## 구현할 컴포넌트 및 메서드 목록


### Application.class
* [ ] init
  * 필요한 클래스 인스턴스들 생성
  * 다리 길이 입력 받고 해당 길이의 다리 생성
  * 게임 시작 시 필요한 문구 출력

* [ ] main
  * 순서에 따라 게임 수행(추후에 메서드 분리 예정)

---

### BridgeGame.class
* [ ] move
  * 사용자의 이동 결과를 생성한 다리와 비교하여 참/거짓 으로 리턴

* [ ] retry
  * 사용자의 현위치를 초기화하고, 시도 횟수를 1증가시킴

---

### BridgeMaker.class

* [ ] makeBridge
  * 지정한 길이 만큼의 다리를 생성

---

### BridgeRandomNumberGenerator.class

* [ ] generate
  * 1혹은 0중 랜덤한 값 리턴

---

### InputView.class

* [ ] readBridgeSize
  * 길이 입력 요구 안내문 출력
  * 다리의 길이를 입력받고 유효성 검증

* [ ] readMoving
  * 이동값 입력 요구 안내문 출력
  * 이동값을 입력받고 유효성 검증

* [ ] readGameCommand
  * 게임 재시도 여부 입력 요구 안내문 출력
  * 재시도 여부를 입력받고 유효성 검증

* [ ] validate
  * 검증할 값 유형에 따라 유효성 검증
  * 유효하지 않을 시 에러 메세지를 담은 예외 발생

---

### OutputView.lass

* [ ] printMap
  * 현재 플레이어의 움직임에 따른 다리 현황을 출력

* [ ] printResult
  * 게임이 끝났을 경우 결과에 따른 다리 현황을 출력
  * 게임 성공 여부와 시도한 횟수 출력