package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import sia.tacocloud.tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{}
