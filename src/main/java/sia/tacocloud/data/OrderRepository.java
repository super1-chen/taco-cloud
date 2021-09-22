package sia.tacocloud.data;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    
    TacoOrder save(TacoOrder tacoOrder);
    
}
