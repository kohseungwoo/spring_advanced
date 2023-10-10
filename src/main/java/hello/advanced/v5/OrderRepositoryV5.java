package hello.advanced.v5;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace){
        this.template = new TraceTemplate(trace);

    }
    
    public void save(String itemId){
        template.execute("OrderRepository.save()", () -> {
            if(itemId.equals("ex")){
                try {
                    throw new IllegalAccessException("예외 발생!");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
