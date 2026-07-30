package com.haittorr.smartitemhighlight.client;

import com.haittorr.smartitemhighlight.client.render.SlotHighlightRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public final class SmartItemHighlightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenEvents.BEFORE_INIT.register((minecraft, screen, width, height) -> {
            if (!(screen instanceof AbstractContainerScreen<?> containerScreen)) {
                return;
            }

            ScreenEvents.afterExtract(screen).register(
                    (currentScreen, graphics, mouseX, mouseY, tickProgress) ->
                            SlotHighlightRenderer.render(containerScreen, graphics)
            );
        });
    }
}