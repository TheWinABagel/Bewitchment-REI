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
import net.minecraft.text.Text;

import java.util.List;

public class RitualRecipeCategory extends BWCategory<RitualRecipeDisplay> {
    public static final CategoryIdentifier<RitualRecipeDisplay> ID = BWREIPlugin.getId("rituals");
    @Override
    public void addWidgets(RitualRecipeDisplay display, List<Widget> widgets, Rectangle bounds) {
        for (int i = 0; i < 6; i++) {
            EntryIngredient ingredient = display.getInput(i);
            widgets.add(slot(ingredient, point((i * 18), 0)));
        }
        widgets.add(Widgets.createArrow(point((6 * 18) + 8, 0)));
        widgets.add(slot(display.getOutput(0), (6 * 18) + 40,0));
        Text text = Text.translatable("ritual." + display.recipe().getId().toString().replaceAll("[:/]", "."));
        widgets.add(Widgets.createLabel(centerPoint(22), text));
    }

    @Override
    public CategoryIdentifier<? extends RitualRecipeDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return BWREIPlugin.getTitle("rituals");
    }

    @Override
    public int getDisplayHeight() {
        return 38;
    }

    @Override
    public int getDisplayWidth(RitualRecipeDisplay display) {
        return 148;
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BWObjects.GOLDEN_CHALK);
    }
}
