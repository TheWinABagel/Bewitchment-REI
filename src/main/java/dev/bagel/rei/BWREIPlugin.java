package dev.bagel.rei;

import dev.bagel.BewitchmentREI;
import dev.bagel.rei.recipe.*;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import moriyashiine.bewitchment.common.recipe.*;
import moriyashiine.bewitchment.common.registry.BWObjects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class BWREIPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AthameStrippingCategory());
        registry.addWorkstations(AthameStrippingCategory.ID, EntryIngredients.of(BWObjects.ATHAME));

        registry.add(new AthameDropCategory());
        registry.addWorkstations(AthameDropCategory.ID, EntryIngredients.of(BWObjects.ATHAME));

        registry.add(new CauldronBrewingCategory());
        registry.addWorkstations(CauldronBrewingCategory.ID, EntryIngredients.of(BWObjects.WITCH_CAULDRON));

        registry.add(new CurseRecipeCategory());
        registry.addWorkstations(CurseRecipeCategory.ID, EntryIngredients.of(BWObjects.BRAZIER));

        registry.add(new IncenseRecipeCategory());
        registry.addWorkstations(IncenseRecipeCategory.ID, EntryIngredients.of(BWObjects.BRAZIER));

        registry.add(new OilRecipeCategory());
        registry.addWorkstations(OilRecipeCategory.ID, EntryIngredients.of(BWObjects.WITCH_CAULDRON));

        registry.add(new RitualRecipeCategory());
        registry.addWorkstations(RitualRecipeCategory.ID, EntryIngredients.of(BWObjects.GOLDEN_CHALK));
    }

    @Override
    public String getPluginProviderName() {
        return "Bewitchment-REI";
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(AthameStrippingRecipe.class, AthameStrippingDisplay::new);
        registry.registerFiller(AthameDropRecipe.class, AthameDropDisplay::new);
        registry.registerFiller(CauldronBrewingRecipe.class, CauldronBrewingDisplay::new);
        registry.registerFiller(CurseRecipe.class, CurseRecipeDisplay::new);
        registry.registerFiller(IncenseRecipe.class, IncenseRecipeDisplay::new);
        registry.registerFiller(OilRecipe.class, OilRecipeDisplay::new);
        registry.registerFiller(RitualRecipe.class, RitualRecipeDisplay::new);
    }

    public static List<EntryIngredient> ingredientOf(ItemStack... items) {
        List<EntryIngredient> list = new ArrayList<>();
        for (ItemStack i : items) {
            list.add(EntryIngredients.of(i));
        }
        return list;
    }

    public static List<EntryIngredient> ingredientOf(Ingredient... items) {
        List<EntryIngredient> list = new ArrayList<>();
        for (Ingredient i : items) {
            list.add(EntryIngredients.ofIngredient(i));
        }
        return list;
    }

    public static List<EntryIngredient> ingredientOf(List<Ingredient> items) {
        List<EntryIngredient> list = new ArrayList<>();
        for (Ingredient i : items) {
            list.add(EntryIngredients.ofIngredient(i));
        }
        return list;
    }

    public static List<EntryIngredient> ingredientOf(ItemConvertible... items) {
        List<EntryIngredient> list = new ArrayList<>();
        for (ItemConvertible i : items) {
            list.add(EntryIngredients.of(i));
        }
        return list;
    }

    public static <D extends Display> CategoryIdentifier<D> getId(String id) {
        return CategoryIdentifier.of(BewitchmentREI.MODID, id);
    }

    public static Text getTitle(String string) {
        return Text.translatable("emi.category.bewitchment." + string);
    }

}
