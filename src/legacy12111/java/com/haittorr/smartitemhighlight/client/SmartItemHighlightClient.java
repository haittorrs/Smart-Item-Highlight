package com.haittorr.smartitemhighlight.client;

import com.haittorr.smartitemhighlight.client.render.SlotHighlightRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreen;

public final class SmartItemHighlightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenEvents.BEFORE_INIT.register((client, screen, width, height) -> {
            if (!(screen instanceof HandledScreen<?> handledScreen)) {
                return;
            }

            ScreenEvents.afterRender(screen).register(
                    (currentScreen, context, mouseX, mouseY, tickDelta) ->
                            SlotHighlightRenderer.render(handledScreen, context)
            );
        });
    }
}
