package dev.bagel.rei.recipe;

import dev.bagel.rei.BWCategory;
import dev.bagel.rei.BWREIPlugin;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import moriyashiine.bewitchment.common.registry.BWObjects;
import net.minecraft.text.Text;

import java.util.List;

public class AthameDropCategory extends BWCategory<AthameDropDisplay> {
    public static final CategoryIdentifier<AthameDropDisplay> ID = BWREIPlugin.getId("athame_drops");
    @Override
    public void addWidgets(AthameDropDisplay display, List<Widget> widgets, Rectangle bounds) {
        widgets.add(Widgets.createArrow(point(26, 0)));
        widgets.add(slot(display.getInput(0), 0, 0));
        widgets.add(slot(display.getOutput(0), 58, 0));
    }

    @Override
    public CategoryIdentifier<? extends AthameDropDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return BWREIPlugin.getTitle("athame_drops");
    }

    @Override
    public int getDisplayWidth(AthameDropDisplay display) {
        return 76;
    }

    @Override
    public int getDisplayHeight() {
        return 22;
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BWObjects.ATHAME);
    }
}
