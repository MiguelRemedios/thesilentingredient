package group43.thesilentingredient.recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path= "api/v1/recipe")

public class RecipeController {

	private final RecipeService recipeService;
	
	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping
	public List<Recipe> getRecipes() {
		return recipeService.getRecipes();		
	}
	
	@PostMapping
	public void registerRecipe(@RequestBody Recipe recipe) {
		recipeService.addNewRecipe(recipe);
	}

	@DeleteMapping(path = "{recipeId}")
	public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
		recipeService.deleteRecipe(recipeId);
	}
	
}