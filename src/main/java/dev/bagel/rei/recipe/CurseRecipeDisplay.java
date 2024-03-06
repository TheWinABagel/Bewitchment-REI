package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.recipe.CurseRecipe;

import java.util.List;

public record CurseRecipeDisplay(CurseRecipe recipe) implements BWDisplay<CurseRecipe> {
    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(recipe.input);
    }

    @Override
    public List<EntryIngredient> addOutput() {
        return List.of(EntryIngredient.empty());
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CurseRecipeCategory.ID;
    }
}
