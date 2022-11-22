# *미션 - 다리 건너기!!* 🌉

---

## 구현 제약 사항 정리 
1. BridgeGame 클래스에서 InputView, OutView 클래스를 사용할 수 없다! 
   &rarr; 외부 파라미터로 전달해서 IO를 진행해야 한다. 그렇다면 BridgeGame을 돌리는 기능을 외부에 구현해야한다.
2. BridgeMaker 클래스는 메서드만 추가할 수 있고 다른 건 수정하면 안된다. 
   &rarr; makeBridge 메서드의 return 타입은 List<String>이다. U와 D를 반환하며 이걸 비교해가면서 게임을 진행하면 된다.
3. BridgeRandomNumberGenerator 클래스는 수정할 수 없다.

---
## 구현 사항 중 고민거리들 ⚒️️
1. BridgeMaker 클래스로 만든 다리 데이터를 어디에 저장해야할까?
2. BridgeGame 클래스에 retry라는 기능이 있는데 이를 어떻게 활용해야 할까?
3. BridgeGame 클래스에 게임이 돌아가는 로직을 짤 수 없다... 게임 루프던 state에 따라 게임을 진행시킬 로직이 필요한데 application 클래스에 구현해야할까?

---

## 기능 구현 목록 🚀
1. [x] inputView 구현
   1. [x] validator 클래스를 만들어서 input 값에 대한 유효성을 검증한다. 
      1. [x] 다리 길이에 대한 검증.
      2. [x] 이동할 칸 입력에 대한 검증.
      3. [x] 다시 시도할지 여부에 대한 입력 검증.
   2. [x] inputView의 메서드 같은 경우는 static으로 만드는 것이 좋을 것 같다. 
   3. [x] input 받은 값의 return 타입은 enum에 저장되어 있는 값으로 하는 것이 좋을 것 같다.
2. [x] bridgeGame 구현.
   1. [x] move 메서드 구현.
      1. ENUM 값의 value를 업데이트 함으로써 전역적인 index값을 관리한다.
      2. ENUM 타입의 결과를 반환함으로써 게임 상태를 체크한다.
   2. [x] retry 메서드 구현.
      1. 전역 index 값을 초기화 시키면서 게임을 초기화 시킨다.
3. [] GameRunner 구현.
   1. [ ] 게임 실행 루프를 제작한다.
   2. [ ] 각 단계별로의 상태에 따라 메서드를 실행시킨다.
4. [ ] outputView 구현.
   1. [ ] printMap 메서드의 경우 생성한 bridge의 값과 index를 파라미터로 받아서 출력한다.
   2. [ ] printResult 메서드의 경우 printing하는 메서드를 제사용해서 작성한다. 
