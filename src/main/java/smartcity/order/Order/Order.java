package smartcity.order.Order;
import javax.persistence.*;
// import java.time.LocalDate;
// import java.time.Period;
import java.sql.Timestamp;
@Entity
@Table(name = "order_table"
// , uniqueConstraints = {
//     @UniqueConstraint()
// }
)
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
        name = "id",
        unique = true,
        updatable = false,
        nullable = false
    )
    private Long id;

    @Column(
        name = "partner_id",
        unique = false,
        nullable = false

    )
    private Long partnerId;

    @Column(
        name = "customer_id",
        unique = false,
        nullable = false

    )
    private Long customerId;

    @Column(
        name = "product_id",
        unique = false,
        nullable = false

    )
    private Long productId;

    @Column(
        name = "placed_on",
        unique = false,
        nullable = true,
        updatable = true,
        columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"

    )
    private Timestamp placedOn;

    @Column(
        name = "description",
        unique = false,
        nullable = true,
        updatable = true,
        columnDefinition = "varchar(255)"

    )
    private String description;

    public Order(Long partnerId, Long customerId, Long productId, java.sql.Timestamp timestamp, String description){
        this.partnerId=partnerId;
        this.customerId=customerId;
        this.productId=productId;
        this.placedOn=timestamp;
        this.description=description;     
    }
    //   public Order(Long partnerId, Long customerId, Long productId, String description){
    //     this.partnerId=partnerId;
    //     this.customerId=customerId;
    //     this.productId=productId;
    //     this.placedOn=null;
    //     this.description=description;     
    // }
    public Order(){

    }

    public Long getId(){
        return id;
    } 
    // public void setId(Long id){
    //     this.id = id;
    // } 

    public Long getIdPartner(){
        return partnerId;
    } 
    public void setIdPartner(Long partnerId){
        this.partnerId = partnerId;
    } 

    public Long getIdCustomer(){
        return customerId;
    } 
    public void setIdCustomer(Long customerId){
        this.customerId = customerId;
    } 

    public Long getIdProduct(){
        return productId;
    } 
    public void setIdProduct(Long productId){
        this.productId = productId;
    } 

    public Timestamp getDoneAt(){
        return placedOn;
    }
    public void setDoneAt(Timestamp placedOn){
        this.placedOn = placedOn;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", partnerId='" + partnerId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productId=" + productId +
                ", doneAt=" + placedOn +
                ", description=" + description +
                '}';
    }


}
