package de.franz.addon.modules;

import de.franz.addon.Addon;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.misc.input.Input;
import net.minecraft.client.option.KeyBinding;
import meteordevelopment.orbit.EventHandler;

public class AutoWalkInLine extends Module {
    private int tickCounter = 0;

    public AutoWalkInLine() {
        super(Addon.CATEGORY, "Auto Walk in line", "Walk back and forth in a straight line");
    }

    @Override
    public void onActivate() {
        // correct looking direction
        setYawAngle(getNormedYawDirection());
        setPitchAngle(0f);
    }

    @Override
    public void onDeactivate() {
        unpress();
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        // correct looking direction
        setYawAngle(getNormedYawDirection());
        setPitchAngle(0f);

        // walk
        setPressed(mc.options.forwardKey, true);
        // time or block threshold
        tickCounter++;
        if (tickCounter % 320 == 0) {
            if (tickCounter == 320*500) {
                tickCounter = 0;
            }
            turnAround();
        }
    }

    /**
     * helper class to press a key
     *
     * @param key
     * @param pressed
     */
    private void setPressed(KeyBinding key, boolean pressed) {
        key.setPressed(pressed);
        Input.setKeyState(key, pressed);
    }

    /**
     * get yaw as float to align straight
     *
     * @return
     */
    private float getNormedYawDirection() {
        assert mc.player != null;
        return Math.round((mc.player.getYaw() + 1f) / 90f) * 90f;
    }
    private void setPitchAngle(float pitchAngle) {
        assert mc.player != null;
        mc.player.setPitch(pitchAngle);
    }
    private void setYawAngle(float yawAngle) {
        assert mc.player != null;
        mc.player.setYaw(yawAngle);
        mc.player.headYaw = yawAngle;
        mc.player.bodyYaw = yawAngle;
    }
    /**
     * make 1 180 turn
     */
    private void turnAround() {
        assert mc.player != null;
        float yawAngle = mc.player.getYaw();
        setYawAngle((yawAngle + 180) % 360);
    }
    /**
     * stop walking
     */
    private void unpress() {
        setPressed(mc.options.forwardKey, false);
        setPressed(mc.options.backKey, false);
        setPressed(mc.options.leftKey, false);
        setPressed(mc.options.rightKey, false);
        tickCounter = 0;
    }
}
