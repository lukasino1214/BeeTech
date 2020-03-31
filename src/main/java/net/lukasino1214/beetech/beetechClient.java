package net.lukasino1214.beetech;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;

public class beetechClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.<StorageBoxContainer>registerFactory(beetech.STORAGE_BOX, (container) -> new StorageBoxScreen(container, MinecraftClient.getInstance().player.inventory, new TranslatableText(beetech.STORAGE_BOX_TRANSLATION_KEY)));
    }
}
