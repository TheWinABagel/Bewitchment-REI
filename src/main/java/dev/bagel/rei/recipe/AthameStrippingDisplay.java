package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.recipe.AthameStrippingRecipe;

import java.util.List;

public record AthameStrippingDisplay(AthameStrippingRecipe recipe) implements BWDisplay<AthameStrippingRecipe> {

    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(recipe.log, recipe.strippedLog);
    }

    @Override
    public List<EntryIngredient> addOutput() {
        return BWREIPlugin.ingredientOf(getRecipeOutput(this.recipe));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AthameStrippingCategory.ID;
    }
}
