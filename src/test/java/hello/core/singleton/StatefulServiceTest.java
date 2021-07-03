package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    
    @Test
    void statefulServceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
        
        //ThreadA : A사용자 10000원 주문
        //statefulService1.order("userA",10000);
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB : B사용자 20000원 주문
        //statefulService2.order("userA",20000);
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
        //int price = statefulService1.getPrice();
        //System.out.println("price = " + price);

        System.out.println("priceA = " + userAPrice);
        System.out.println("priceB = " + userBPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }
    
    static class TestConfig {
        
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
