package wtf.nebula.impl.gui.ui;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import wtf.nebula.util.feature.ToggleableFeature;

import java.util.ArrayList;
import java.util.List;

public abstract class Component extends ToggleableFeature {
    public double x, y, width, height;

    public final List<Component> children = new ArrayList<>();

    public Component(String name) {
        super(name);
    }

    public abstract void drawComponent(int mouseX, int mouseY, float partialTicks);
    public abstract void mouseClick(int mouseX, int mouseY, int button);
    public abstract void mouseRelease(int mouseX, int mouseY, int state);
    public abstract void keyTyped(char typedChar, int keyCode);

    public boolean isInBounds(int mouseX, int mouseY) {
        return isMouseWithinBounds(mouseX, mouseY, x, y, width, height);
    }

    public static boolean isMouseWithinBounds(int mouseX, int mouseY, double x, double y, double w, double h) {
        return mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h;
    }

    public static void playClickSound() {
        mc.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("minecraft:gui.button.press"), 1.0f));
    }
}
