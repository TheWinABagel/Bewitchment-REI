package dev.bagel.rei.recipe;

import dev.bagel.rei.BWDisplay;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import moriyashiine.bewitchment.common.recipe.CauldronBrewingRecipe;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;

import java.util.Collections;
import java.util.List;

public record CauldronBrewingDisplay(CauldronBrewingRecipe recipe) implements BWDisplay<CauldronBrewingRecipe> {
    @Override
    public List<EntryIngredient> addInput() {
        return BWREIPlugin.ingredientOf(recipe.input);
    }

    @Override
    public List<EntryIngredient> addOutput() {
        List<StatusEffectInstance> effects = Collections.singletonList(new StatusEffectInstance(recipe.output, recipe.time));
        ItemStack potion = PotionUtil.setCustomPotionEffects(new ItemStack(Items.POTION), effects);
        potion.getOrCreateNbt().putInt("CustomPotionColor", PotionUtil.getColor(effects));
        potion.getOrCreateNbt().putBoolean("BewitchmentBrew", true);
        return BWREIPlugin.ingredientOf(potion);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CauldronBrewingCategory.ID;
    }
}
