#  기능 요구사항

---


## _UI 셋팅_

---

### Inputview

- [ ] 다리의 길이를 입력받기
- [ ] 이동할 방향 입력
- [ ] 게임 재시작 여부 입력

- [ ] **[예외사항]**
    - [ ] **[예외]** 다리의 길이는 null이 들어올 경우 IllegalArgumentException이 발생해야 한다
    - [ ] **[예외]** 다리의 길이는 숫자가 아닐 경우 IllegalArgumentException이 발생해야 한다
    - [ ] **[예외]** 다리의 길이는 3 이상 20 이하가 아닐 경우 IllegalArgumentException이 발생해야 한다

  
### OutputView

- [ ] 게임 시작 안내
- [ ] 다리 이동 내역 출력
- [ ] 최종 게임 결과 출력

---

## _Controller 셋팅_

---


### BridgeController
- [ ] 다리 생성 요청
- [ ] 다리 이동 요청
- [ ] 게임 종료

---
## _Domain 세팅_

---
### BridgeGame
- [ ] 한 턴 이동 후 내역 반환
- [ ] 재시작 여부
- [ ] 종료 여부 확인
- [ ] 게임 성공 메시지 반환
- [ ] 이동 내역 반환
- [ ] 총 시도한 횟수 반환

### BridgeCalculate
- [ ] 이동 성공 여부 계산
- [ ] 게임 성공 여부 계산

### BridgeMonitor
- [ ] 한턴의 이동 후 현황 기록
- [ ] 이동 현황 반환