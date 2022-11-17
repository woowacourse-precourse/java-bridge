# Application Workflow
- start game
- enter bridge length
- generate random bridge
- while not end of bridge
  - receive user move
  - next move if valid
  - retry or terminate if invalid
- show the final game status and other info


# Classes
### Application
### Controller
#### controls the overall game flow
- (field) bridgeGame
- constructor: initialize the bridgeGame instance
### BridgeGame
#### <em>cannot call InputView or OutputView</em>
- (field) bridge 
- move
  - receives which direction to move
- retry
### BridgeMaker
- One and only function is to generate bridge
### BridgeRandomNumberGenerator
- DO NOT MODIFY
### InputView
#### it throws the exception outwards
- read bridge size
- read string wrapper
  - read user move
  - read retry or terminate
### OutputView
### Err
- wrong bridge length
- wrong move
- wrong retry or terminate

# Interface
### BridgeNumberGenerator
- DO NOT MODIFY
