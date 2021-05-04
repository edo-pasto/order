package smartcity.order.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o FROM Order o WHERE o.partnerId = ?1")
    List<Order> findByPartnerId(Long partnerId);

    @Query(value = "SELECT o FROM Order o WHERE o.customerId = ?1")
    List<Order> findByCustomerId(Long customerId);

    @Query(value = "SELECT o FROM Order o WHERE o.productId = ?1")
    List<Order> findByProductId(Long productId);
   
}
