package sia.tacocloud.tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class Taco {
    
    
    @NotNull
    @Size(min=3, message="Name must be at least 5 characters long")
    private String name;
    
    private Date createdAt = new Date();
    // taco can have many Ingredient objects and an Ingredient can be a part of many Taco s.
    
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
      
}

