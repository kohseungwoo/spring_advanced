package hello.advanced.v2;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;
    
    public void save(TraceId traceId,String itemId) throws IllegalAccessException{

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "OrderRepository.save()");
            if(itemId.equals("ex")){
                throw new IllegalAccessException("예외 발생!");
            }
            sleep(1000);
            
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
        
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
