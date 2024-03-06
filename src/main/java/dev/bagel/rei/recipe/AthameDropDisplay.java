package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.recipe.AthameDropRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.List;

public record AthameDropDisplay(AthameDropRecipe recipe) implements BWDisplay<AthameDropRecipe> {

    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(new ItemStack(Items.SPAWNER).setCustomName(recipe.entity_type.getName()));
    }

    @Override
    public List<EntryIngredient> addOutput() {
        return BWREIPlugin.ingredientOf(getRecipeOutput(recipe));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AthameDropCategory.ID;
    }
}
