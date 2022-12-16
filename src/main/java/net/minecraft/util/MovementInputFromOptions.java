package net.minecraft.util;

import net.minecraft.client.settings.GameSettings;
import wtf.nebula.client.core.Nebula;
import wtf.nebula.client.impl.event.impl.input.EventInputUpdate;
import wtf.nebula.client.impl.event.impl.move.EventMoveForward;

public class MovementInputFromOptions extends MovementInput
{
    private GameSettings gameSettings;
    private static final String __OBFID = "CL_00000937";

    public MovementInputFromOptions(GameSettings par1GameSettings)
    {
        this.gameSettings = par1GameSettings;
    }

    public void updatePlayerMoveState()
    {
        if (Nebula.BUS.post(new EventInputUpdate(this))) {
            return;
        }

        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindForward.getIsKeyPressed() || Nebula.BUS.post(new EventMoveForward(this)))
        {
            ++this.moveForward;
        }

        if (this.gameSettings.keyBindBack.getIsKeyPressed())
        {
            --this.moveForward;
        }

        if (this.gameSettings.keyBindLeft.getIsKeyPressed())
        {
            ++this.moveStrafe;
        }

        if (this.gameSettings.keyBindRight.getIsKeyPressed())
        {
            --this.moveStrafe;
        }

        this.jump = this.gameSettings.keyBindJump.getIsKeyPressed();
        this.sneak = this.gameSettings.keyBindSneak.getIsKeyPressed();

        if (this.sneak)
        {
            this.moveStrafe = (float)((double)this.moveStrafe * 0.3D);
            this.moveForward = (float)((double)this.moveForward * 0.3D);
        }
    }
}
