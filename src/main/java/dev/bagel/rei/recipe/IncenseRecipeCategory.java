package dev.bagel.rei.recipe;

import dev.bagel.rei.BWCategory;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import moriyashiine.bewitchment.common.registry.BWObjects;
import moriyashiine.bewitchment.common.registry.BWRegistries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class IncenseRecipeCategory extends BWCategory<IncenseRecipeDisplay> {
    public static final CategoryIdentifier<IncenseRecipeDisplay> ID = BWREIPlugin.getId("incenses");
    @Override
    public void addWidgets(IncenseRecipeDisplay display, List<Widget> widgets, Rectangle bounds) {
        for (int i = 0; i < 4; i++) {
            EntryIngredient ingredient = display.getInput(i);
            widgets.add(slot(ingredient, point((i * 18), 0)));
        }
        widgets.add(Widgets.createLabel(centerPoint(22), display.recipe().effect.getName().copy().formatted(Formatting.DARK_GREEN)));
    }

    @Override
    public int getDisplayHeight() {
        return 38;
    }

    @Override
    public int getDisplayWidth(IncenseRecipeDisplay display) {
        return 72;
    }

    @Override
    public CategoryIdentifier<? extends IncenseRecipeDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return BWREIPlugin.getTitle("incenses");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BWObjects.BRAZIER);
    }
}
