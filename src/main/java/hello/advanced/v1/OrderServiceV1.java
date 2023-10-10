package hello.advanced.v1;

import org.springframework.stereotype.Service;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV0;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) throws IllegalAccessException{

        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV0.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
