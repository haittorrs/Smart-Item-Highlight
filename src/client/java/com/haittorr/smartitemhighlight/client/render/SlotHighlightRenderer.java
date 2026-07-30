package com.haittorr.smartitemhighlight.client.render;

import com.haittorr.smartitemhighlight.client.mixin.AbstractContainerScreenAccessor;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public final class SlotHighlightRenderer {

    private static final int HIGHLIGHT_COLOR = 0x6655FF55;

    private SlotHighlightRenderer() {
        // Prevent this utility class from being instantiated.
    }

    public static void render(
            AbstractContainerScreen<?> screen,
            GuiGraphicsExtractor graphics
    ) {
        ItemStack carriedStack = screen.getMenu().getCarried();

        // Do nothing unless the player is holding an item with the cursor.
        if (carriedStack.isEmpty()) {
            return;
        }

        AbstractContainerScreenAccessor accessor =
                (AbstractContainerScreenAccessor) screen;

        int guiLeft = accessor.smartItemHighlight$getLeftPos();
        int guiTop = accessor.smartItemHighlight$getTopPos();

        for (Slot slot : screen.getMenu().slots) {
            if (!slot.isActive()) {
                continue;
            }

            ItemStack slotStack = slot.getItem();

            if (slotStack.isEmpty()) {
                continue;
            }

            // Match by item type only.
            if (slotStack.getItem() != carriedStack.getItem()) {
                continue;
            }

            int slotX = guiLeft + slot.x;
            int slotY = guiTop + slot.y;

            drawOverlay(graphics, slotX, slotY);
        }
    }

    private static void drawOverlay(
            GuiGraphicsExtractor graphics,
            int x,
            int y
    ) {
        graphics.fill(
                x,
                y,
                x + 16,
                y + 16,
                HIGHLIGHT_COLOR
        );
    }

}