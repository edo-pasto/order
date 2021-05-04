package smartcity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;
// import java.security.Timestamp;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
@Configuration
public class OrderConfig {

  OrderRepository orderRepository;

    @Autowired
    public OrderConfig(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // @Bean
    // CommandLineRunner commandLineRunner(OrderRepository repository){
    //     // return args -> {
    //     //     Order test = new Order(
    //     //         10L,
    //     //         100L,
    //     //         1000L,
    //     //         new Timestamp(System.currentTimeMillis()),
    //     //         "prodotto bello e carino"
    //     // );
          

    //     //     repository.save(test);

    //     // };
    // }



}
