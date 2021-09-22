package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    
}
