package com.haittorr.smartitemhighlight.client.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface AbstractContainerScreenAccessor {

    @Accessor("x")
    int smartItemHighlight$getLeftPos();

    @Accessor("y")
    int smartItemHighlight$getTopPos();
}
