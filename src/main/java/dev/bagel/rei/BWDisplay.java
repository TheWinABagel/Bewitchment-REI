package dev.bagel.rei;

import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public interface BWDisplay<T extends Recipe<?>> extends Display {
    List<EntryIngredient> addInput();
    List<EntryIngredient> addOutput();

    @Override
    default List<EntryIngredient> getInputEntries() {
        return addInput();
    }

    @Override
    default List<EntryIngredient> getOutputEntries() {
        return addOutput();
    }

    default EntryIngredient getInput(int index) {
        EntryIngredient ingredient = EntryIngredient.empty();
        if (!(index > addInput().size() - 1)) {
            ingredient = addInput().get(index);
        }
        return ingredient;
    }

    default EntryIngredient getOutput(int index) {
        EntryIngredient ingredient = EntryIngredient.empty();
        if (!(index > addOutput().size())) {
            ingredient = addOutput().get(index);
        }
        return ingredient;
    }

    default ItemStack getRecipeOutput(Recipe<?> recipe) {
        MinecraftClient client = MinecraftClient.getInstance();
        //noinspection DataFlowIssue
        return recipe.getOutput(client.world.getRegistryManager());
    }
}
