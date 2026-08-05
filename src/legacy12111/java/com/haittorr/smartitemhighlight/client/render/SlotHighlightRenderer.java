package com.haittorr.smartitemhighlight.client.render;

import com.haittorr.smartitemhighlight.client.mixin.AbstractContainerScreenAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public final class SlotHighlightRenderer {

    private static final int HIGHLIGHT_COLOR = 0x6655FF55;

    private SlotHighlightRenderer() {
    }

    public static void render(HandledScreen<?> screen, DrawContext graphics) {
        ItemStack carriedStack = screen.getScreenHandler().getCursorStack();
        if (carriedStack.isEmpty()) {
            return;
        }

        AbstractContainerScreenAccessor accessor =
                (AbstractContainerScreenAccessor) screen;
        int guiLeft = accessor.smartItemHighlight$getLeftPos();
        int guiTop = accessor.smartItemHighlight$getTopPos();

        for (Slot slot : screen.getScreenHandler().slots) {
            if (!slot.isEnabled()) {
                continue;
            }

            ItemStack slotStack = slot.getStack();
            if (slotStack.isEmpty() || slotStack.getItem() != carriedStack.getItem()) {
                continue;
            }

            graphics.fill(
                    guiLeft + slot.x,
                    guiTop + slot.y,
                    guiLeft + slot.x + 16,
                    guiTop + slot.y + 16,
                    HIGHLIGHT_COLOR
            );
        }
    }
}
