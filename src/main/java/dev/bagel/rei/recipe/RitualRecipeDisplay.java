package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.Bewitchment;
import moriyashiine.bewitchment.common.recipe.RitualRecipe;
import moriyashiine.bewitchment.common.registry.BWObjects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.List;

public record RitualRecipeDisplay(RitualRecipe recipe) implements BWDisplay<RitualRecipe> {
    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(recipe.input);
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public List<EntryIngredient> addOutput() {
        ItemStack chalk = new ItemStack(BWObjects.GOLDEN_CHALK).setCustomName(Text.translatable("ritual." + recipe.getId().toString().replaceAll("[:./]", ".")));
        chalk.getOrCreateNbt().putString("InnerCircle", "chalk." + Bewitchment.MOD_ID + "." + recipe.inner);
        if (!recipe.outer.isEmpty()) {
            chalk.getNbt().putString("OuterCircle", "chalk." + Bewitchment.MOD_ID + "." + recipe.outer);
        }
        chalk.getNbt().putInt("Cost", recipe.cost);
        if (recipe.runningTime > 0) {
            chalk.getNbt().putInt("RunningTime", recipe.runningTime);
        }
        return BWREIPlugin.ingredientOf(chalk);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RitualRecipeCategory.ID;
    }
}
