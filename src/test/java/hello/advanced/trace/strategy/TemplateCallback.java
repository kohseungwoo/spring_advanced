package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.template.Callback;
import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallback {
    
    /* 템플릿 콜백 패턴 - 익명 내부 클래스 */
    @Test
    void callbackV1(){
        TimeLogTemplate template1 = new TimeLogTemplate();
        template1.execute(new Callback() {
            @Override
            public void call(){
               log.info("비즈니스 로직1 실행"); 
            }
        });

        TimeLogTemplate template2 = new TimeLogTemplate();
        template2.execute(new Callback() {
            @Override
            public void call(){
               log.info("비즈니스 로직2 실행"); 
            }
        });
    }

    @Test
    void callbackV2(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직1 실행"));
        template.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
