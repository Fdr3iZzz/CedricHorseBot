package de.franz.addon.modules;

import de.franz.addon.Addon;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.misc.input.Input;
import net.minecraft.client.option.KeyBinding;
import meteordevelopment.orbit.EventHandler;

public class AutoWalkInLine extends Module {
    public AutoWalkInLine() {
        super(Addon.CATEGORY, "Auto Walk in line", "Walk back and forth in a straight line");
    }
    @Override
    public void onActivate() {

    }
    @Override
    public void onDeactivate() {
        unpress();
    }
    @EventHandler
    private void onTick(TickEvent.Pre event) {
        setPressed(mc.options.forwardKey, true);
    }

    private void unpress() {
        setPressed(mc.options.forwardKey, false);
        setPressed(mc.options.backKey, false);
        setPressed(mc.options.leftKey, false);
        setPressed(mc.options.rightKey, false);
    }
    private void setPressed(KeyBinding key, boolean pressed) {
        key.setPressed(pressed);
        Input.setKeyState(key, pressed);
    }
}
