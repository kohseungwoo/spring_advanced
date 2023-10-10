package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
    
    @Test
    void strategyV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직실행
        log.info("비즈니스 로직 실행1");
        //비즈니스 로직종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직 실행2");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }

    /* 전략패턴 */
    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 =new StrategyLogic1();
        
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 =new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2(){
        Strategy strategyLogic1 =new Strategy(){
            @Override
            public void call(){
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 Context1 = new ContextV1(strategyLogic1);
        log.info("Context1 : {}", strategyLogic1.getClass());
        Context1.execute();

        Strategy strategyLogic2 =new Strategy(){
            @Override
            public void call(){
                log.info("비즈니스 로직2 실행");
            }
        };

        ContextV1 Context2 = new ContextV1(strategyLogic2);
        log.info("Context2 : {}", strategyLogic2.getClass());
        Context2.execute();
    }

    @Test
    void strategyV3(){
        ContextV1 Context1 = new ContextV1(new Strategy(){
            @Override
            public void call(){
                log.info("비즈니스 로직1 실행");
            }
        });

        log.info("Context1 : {}", Context1.getClass());
        Context1.execute();

        ContextV1 Context2 = new ContextV1(new Strategy(){
            @Override
            public void call(){
                log.info("비즈니스 로직2 실행");
            }
        });
        log.info("Context2 : {}", Context2.getClass());
        Context2.execute();
    }

    @Test
    void strategyV4(){
        ContextV1 Context1 = new ContextV1(()-> log.info("비즈니스 로직1 실행"));
        Context1.execute();

        ContextV1 Context2 = new ContextV1(()-> log.info("비즈니스 로직2 실행"));
        Context2.execute();
    }

}