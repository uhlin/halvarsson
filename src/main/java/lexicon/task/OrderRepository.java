package lexicon.task;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring
//CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Order, Long> {
	;
}
