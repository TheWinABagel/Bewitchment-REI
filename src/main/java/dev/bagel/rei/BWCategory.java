package dev.bagel.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Slot;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.entry.EntryStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BWCategory<T extends BWDisplay<?>> implements DisplayCategory<T> {
    protected Rectangle bounds;
    protected T display;
    @Override
    public List<Widget> setupDisplay(T display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();
        this.bounds = bounds;
        this.display = display;
        this.addWidgets(display, widgets, bounds);
        return widgets;
    }

    public abstract void addWidgets(T display, List<Widget> widgets, Rectangle bounds);



    public Slot slot(Collection<? extends EntryStack<?>> stacks, int x, int y) {
        return Widgets.createSlot(new Point(bounds.getX() + x, bounds.getY() + y)).entries(stacks);
    }

    public Slot slot(Collection<? extends EntryStack<?>> stacks, Point point) {
        return Widgets.createSlot(point).entries(stacks);
    }

    public Point point(int x, int y) {
        return new Point(x + this.bounds.getX(), y + this.bounds.getY());
    }

    public Point centerPoint(int y) {
        return point( getDisplayWidth(display) / 2, y);
    }
}
