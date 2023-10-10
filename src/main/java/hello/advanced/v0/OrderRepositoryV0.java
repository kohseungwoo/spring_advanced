package hello.advanced.v0;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {
    
    public void save(String itemId) throws IllegalAccessException{
        if(itemId.equals("ex")){
            throw new IllegalAccessException("예외 발생!");
        }

        sleep(1000);
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
