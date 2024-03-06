package dev.bagel.rei.recipe;

import dev.bagel.rei.BWCategory;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import moriyashiine.bewitchment.common.registry.BWObjects;
import moriyashiine.bewitchment.common.registry.BWRegistries;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class CurseRecipeCategory extends BWCategory<CurseRecipeDisplay> {
    public static final CategoryIdentifier<CurseRecipeDisplay> ID = BWREIPlugin.getId("curses");
    @Override
    public void addWidgets(CurseRecipeDisplay display, List<Widget> widgets, Rectangle bounds) {
        for (int i = 0; i < 4; i++) {
            EntryIngredient ingredient = display.getInput(i);
            widgets.add(slot(ingredient, point((i * 18), 0)));
        }

        MutableText curse = Text.translatable("curse." + BWRegistries.CURSE.getId(display.recipe().curse).toString().replace(":", "."));
        widgets.add(Widgets.createLabel(centerPoint(22), curse.formatted(Formatting.RED)));
    }

    @Override
    public int getDisplayHeight() {
        return 38;
    }

    @Override
    public int getDisplayWidth(CurseRecipeDisplay display) {
        return 72;
    }

    @Override
    public CategoryIdentifier<? extends CurseRecipeDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return BWREIPlugin.getTitle("curses");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BWObjects.BRAZIER);
    }
}
