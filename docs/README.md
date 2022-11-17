
프로그램 순서도

1. 다리 건너기 게임 시작 및 출력

2. 다리의 길이 입력
---
3. 이동할 칸 선택 입력

4. 이동한 칸에 대한 출력

5. 3번과 4번 반복
---

6. 성공 시 최종 게임 결과 출력 (재시도 불가)

7. 실패 시 게임 재시도 여부 출력

8. 게임 종료 출력 (게임 성공 여부, 총 시도 횟수 출력)

# 객체 지향적

다리 건너기 게임에서의 다리 객체 Bridge
다리 건너기 게임에 대한 객체 BridgeGame
다리 건너기 게임의 다리 만들기에 대한 객체 BridgeMaker
다리 건너기 게임의 다리 만들기에서 사용자가 관여하지 않는 생성 객체 Generator
다리 건너기 게임에서 사용할 입출력 관련 객체 View

# 궁금증

BridgeGame 클래스 이외의 객체들은 하위 추상화 단계의 객체들인가?
BridgeGame과 BridgeMaker를 같은 추상화 계층으로 봐야하는가?
1. BridgeGame 하위계층에 Maker를 넣는다.
   BridgeGame 클래스가 생성, 상태, 관리의 역할을 모두 가지게 된다.
2. BridgeGame 과 BridgeMaker를 같은 계층으로 본다.
   생성을 나누고 상태,관리를 따로한다.
   생성에 랜덤한 값이 들어간다 즉, 그때그때 달라지는 값이 있다.


# 추상화 단계 생각하기

맨위  Application

- BridgeGameModule
    - BridgeGame
    - BridgeMaker
    - BridgeNumberGenerator & impl
    - InputView
    - OutputView

# 구현
- [x] 다리 건너기 게임 Module 생성
- [ ] 게임 시작 문구 출력
- [ ] 다리 길이 입력 요청 문구 출력
- [ ] 다리 길이 입력 요청
    - [ ] (유효성) 숫자
- [ ] 다리 생성
    - [ ] BridgeRandomNumber 구현체를 이용한 BridgeMaker 생성
    - [ ] 다리 길이 입력(size)만큼의 block 만들기
        - [ ] (유효성) 3 이상 20 이하
    - [ ] 랜덤값에 따른 블럭 채우기
        - [ ] (유효성) 0 또는 1
    - [ ] 생성된 다리 반환
- [ ] 이동할 칸 입력 요청 문구 출력
- [ ] 이동할 칸 입력 요청
    - [ ] (유효성) 1자리 문자
- [ ] 칸 이동