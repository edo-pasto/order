package smartcity.order.Order;
import smartcity.order.Order.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Optional;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Optional <Order> getOrder(Long orderId){      
            Optional <Order> order = orderRepository.findById(orderId);
            if(order == null){
                throw new NotFoundException("order not found");
            }else{
                return order;
            }
    }

    public List <Order> getOrders(){
        List <Order> orders = orderRepository.findAll();
        return orders;   
    }

    public List<Order> getOrdersByPartner(Long partnerId){
       
        List<Order> orders = orderRepository.findByPartnerId(partnerId);
        
        if(orders.isEmpty()){
            throw new NotFoundException("partner not found");
        }else{
            return orders;
        }
    }

    public List<Order> getOrdersByCustomer(Long customerId){
        
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        
        if(orders.isEmpty()){
            throw new NotFoundException("customer not found");
        }else{
            return orders;
        }
    }

    public List<Order> getOrdersByProduct(Long productId){

        List<Order> orders = orderRepository.findByProductId(productId);
        if(orders.isEmpty()){
            throw new NotFoundException("product not found");
        }else{
            return orders;
        }
    }

    public void deleteOrder(Long orderId){
         orderRepository.findById(orderId)
        .orElseThrow( () -> new NotFoundException("Order not exist"));
         orderRepository.deleteById(orderId);
    }

    public void postOrder(Order order){
        try{
            orderRepository.save(order);
        }catch(Exception e){
            throw new IllegalArgumentException("Error");
        }
    }

    @Transactional
    public void updateOrder(Long orderId, String description){
        Order order = orderRepository.findById(orderId)
                .orElseThrow( () -> new NotFoundException("Order not exist"));
            order.setDescription(description);
        
    }
}
