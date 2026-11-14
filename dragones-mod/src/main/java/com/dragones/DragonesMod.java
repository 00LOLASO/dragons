package com.dragones;

import com.dragones.registry.ModEntities;
import com.dragones.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonesMod implements ModInitializer {
    public static final String MOD_ID = "dragones";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEntities.registrar();
        ModItems.registrar();
        LOGGER.info("Dragones cargado!");
    }
}
