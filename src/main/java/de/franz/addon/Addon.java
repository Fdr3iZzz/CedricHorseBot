package de.franz.addon;

import de.franz.addon.commands.CommandExample;
import de.franz.addon.hud.HudExample;
import de.franz.addon.modules.AutoWalkInLine;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Cedric's Stuff");
    public static final HudGroup HUD_GROUP = new HudGroup("Auto Walk");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Addon for Cedric3");

        // Modules
        Modules.get().add(new AutoWalkInLine());

        // Commands
        Commands.add(new CommandExample());

        // HUD
        Hud.get().register(HudExample.INFO);

    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "de.franz.addon";
    }
}
