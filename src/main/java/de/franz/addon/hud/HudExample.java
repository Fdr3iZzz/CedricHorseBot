package de.franz.addon.hud;

import de.franz.addon.Addon;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class HudExample extends HudElement {
    public static final HudElementInfo<HudExample> INFO = new HudElementInfo<>(Addon.HUD_GROUP, "Cedric's Stuff", "Cedric's Stuff (HUD) by Franz3", HudExample::new);

    public HudExample() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("Auto Walk back and forth", true), renderer.textHeight(true));

        renderer.text("Auto Walk back and forth", x, y, Color.WHITE, true);
    }
}
