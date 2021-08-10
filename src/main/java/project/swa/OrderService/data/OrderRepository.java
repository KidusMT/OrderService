package project.swa.OrderService.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.swa.OrderService.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
