package smartcity.order.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartcity.order.Order.NotFoundException;
// import java.time.LocalDate;
// import java.time.Month;
// import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List <Order> getOrders(){
        List <Order> orders = orderService.getOrders(); 
        return orders;
		
	}

    @GetMapping("{orderId}")
    public Optional <Order> getOrder(@PathVariable("orderId") Long orderId){
        try{
        Optional <Order> order = orderService.getOrder(orderId); 
        return order;
        }catch(NotFoundException e){
            throw new NotFoundException("order not found");
        }
		
	}

    @GetMapping("partner/{partnerId}")
    public List<Order> getOrdersByPartner(@PathVariable("partnerId") Long partnerId){
        try{
            List<Order> orders = orderService.getOrdersByPartner(partnerId);
            return orders;
        }catch(NotFoundException e){
          throw new NotFoundException("partner not found");
        }
		
	}
    
    @GetMapping("customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable("customerId") Long customerId){
        try{
            List<Order> orders =  orderService.getOrdersByCustomer(customerId);
            return orders;
        }catch(NotFoundException e){
            throw new NotFoundException("customer not found");
        }
  
	}
    
    @GetMapping("product/{productId}")
    public List<Order> getOrdersByProduct(@PathVariable("productId") Long productId){
        try{
            List<Order> orders =orderService.getOrdersByProduct(productId);
            return orders;
        }catch(NotFoundException e){
            throw new NotFoundException("product not found");
        }
		
	}
    
    @PostMapping
    public void postOrder(@RequestBody Order order){
        try{
        order.setDoneAt(new Timestamp(System.currentTimeMillis()));
        orderService.postOrder(order);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Errore nel pssaggio dei dati");
        }
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long id){
        orderService.deleteOrder(id);
    }

    @PutMapping(path = "{orderId}")
    public void updateOrder(@PathVariable("orderId") Long orderId, @RequestBody Order order){
        orderService.updateOrder(orderId, order.getDescription());
    }

}
