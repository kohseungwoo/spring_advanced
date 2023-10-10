package hello.advanced.v4;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;
    
    public void save(String itemId){

         AbstractTemplate<Void> template = new AbstractTemplate<>(trace){
            @Override
            protected Void call(){
                if(itemId.equals("ex")){
                    try {
                        throw new IllegalAccessException("예외 발생!");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
