package sia.tacocloud.data;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sia.tacocloud.tacos.IngredientUDT;
import sia.tacocloud.tacos.Ingredient;

@Component
public class StringIdToIngredientConverter implements Converter<String, IngredientUDT> {
    private IngredientRepository ingredientRepository;

    public StringIdToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> {
            return new IngredientUDT(i.getName(), i.getType());
        }).get();
    }
  
}
