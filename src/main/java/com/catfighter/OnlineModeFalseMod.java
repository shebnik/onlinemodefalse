package com.catfighter;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnlineModeFalseMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("onlinemodefalse");

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register((MinecraftServer server) -> {
			LOGGER.info("[SERVER_STARTED] Online mode is now " + server.isOnlineMode() + "!");
			if (server.isOnlineMode()) {
				server.setOnlineMode(false);
				LOGGER.info("Online mode is set to " + server.isOnlineMode() + "!");
			}
		});
	}
}