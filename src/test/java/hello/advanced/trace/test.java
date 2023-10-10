package hello.advanced.trace;

import org.junit.jupiter.api.Test;

public class test {
    
    private void overloading(){
        System.out.println("오버로딩1");
    }

    private String overloading(String str){
        return str;
    }

    private String overloading(int i){
        return "오버로딩테스트 숫자는 : "+ i;
    }


    @Test
    void overloadingTest(){

        overloading();
        System.out.println(overloading("오버로딩테스트"));
        System.out.println(overloading(0));
    }

    @Test
    void personTest(){
        Person person = new Person();
        Child child = new Child();
        Senior senior = new Senior();

        person.cry();
        child.cry();
        senior.cry();
    }
}

class Person{
    void cry(){
        System.out.println("흑흑");
    }
}

class Child extends Person {

    @Override
    protected void cry(){
        System.out.println("잉잉");
    }
}

class Senior extends Person {
    @Override
    public void cry(){
        System.out.println("훌쩍");
    }
}


