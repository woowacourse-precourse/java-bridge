# 📒 요구사항 정리
🟩개발예정 ✅개발완료

---
### <span style = "color:skyblue" >GAME_START</span> : 게임 시작
- ✅ **`getInput`** → 사용자의 입력을 받아 온다.
- ✅ **`printGameStart`** → 맨 첫 게임 시작 시에만 출력
- ✅ **`readBridgeSize`** → 다리의 길이를 입력값으로 받으며 맨 처음 한 번만 사용한다.
- ✅ **`isCorrectLength`** → 다리의 길이가 올바른 범위인지 확인한다.
- ✅ **`makeBridge`** → 입력된 값에 따라 다리를 만든다. 
---
### <span style = "color:skyblue" >RUN_PROCESS</span> : 플레이어를 이동시킨다.
- ✅ **`readMoving`** → 라운드마다 플레이어가 이동할 칸을 입력 받는다. 위, 아래 중 하나로 이동 가능하다.
- ✅ **`PlayerMoveValidator`** → 플레이어 이동이 올바른지 확인한다.
- ✅ **`printBridge`** → 이동할 때마다 이동된 칸에 따라 다리 모양 출력
---
### <span style = "color:skyblue" >SELECT_RESTART</span> : 게임 재시작/종료 여부를 입력 받는다.
- ✅ **`readGameCommand`** → 게임 재시작/ 종료 여부를 문자로 입력 받는다.
- ✅ **`RestartDecisionValidator`** → 재시작 여부가 올바른 입력인지 확인한다.
---

# Git 커밋 메시지(temp)
```markdown
:sparkles: feat: <새로운 기능>
:truck: chore: <기타 변경사항>
:construction_worker: ci: <CI 에 관련된 빌드를 할때>
:memo: docs: <도큐멘트> 
:recycle: refactor: <리팩토링>
:test_tube: test: <테스트 코드>
:lipstick: style: <스타일>
:rewind: revert: <깃을 예전 단계로 돌려놓는다>
:zap: perf: <속도적인 측면에서 업그레이드 될때>
:bug: fix: <오류를 바꾼다>

##-------- 
#✨ feat: <새로운 기능>
#🚚 chore: 코드 의미에 영향을 주지 않는 변경사항 (형식 지정, 세미콜론 누락, gitignore 등)
#👷 ci: CI, 자동화 기능
#📝 docs: 문서의 추가, 수정, 삭제
#♻️ refactor: 코드 리팩토링
#🧪 test: 테스트 추가, 수정, 삭제 (비즈니스 로직에 변경 없음)
#💄 style: 코드 스타일 혹은 포맷 등에 관한 커밋
#⏪ revert: 깃 revert
#⚡️ perf: 퍼포먼스 상향
#🐛 fix: 버그
```

# ♻️ 리팩토링 필요
- [ ] 위, 아래 문자를 Enum이나 상수로 대체하기
- [x] 다리 출력시 코드가 너무 김
- [x] RUNPROCESS의 기능 함수 추출 필요