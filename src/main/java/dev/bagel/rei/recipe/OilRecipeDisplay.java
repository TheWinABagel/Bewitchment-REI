package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.recipe.OilRecipe;

import java.util.List;

public record OilRecipeDisplay(OilRecipe recipe) implements BWDisplay<OilRecipe> {
    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(recipe.input);
    }

    @Override
    public List<EntryIngredient> addOutput() {
        return BWREIPlugin.ingredientOf(getRecipeOutput(this.recipe));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return OilRecipeCategory.ID;
    }
}
