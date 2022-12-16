package wtf.nebula.client.utils.render.renderers.impl.three;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import wtf.nebula.client.utils.render.RenderEngine;
import wtf.nebula.client.utils.render.enums.Dimension;
import wtf.nebula.client.utils.render.renderers.Renderer;

import static org.lwjgl.opengl.GL11.*;

public class OutlinedBox extends Renderer {
    private final AxisAlignedBB box;
    private final int color;
    private final float lineWidth;

    public OutlinedBox(AxisAlignedBB box, int color, float lineWidth) {
        this.box = box;
        this.color = color;
        this.lineWidth = lineWidth;
    }

    @Override
    public void render() {
        if (dimension.equals(Dimension.THREE)) {
            glPushMatrix();
            glEnable(GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 0, 1);
            glDisable(GL_TEXTURE_2D);
            glDisable(GL_DEPTH_TEST);
            //glDisable(GL_LIGHTING);

            RenderEngine.color(color);

            glEnable(GL_LINE_SMOOTH);
            glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
            glLineWidth(lineWidth);

            Tessellator tessellator = Tessellator.instance;

            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.minX, box.minY, box.minZ);
            tessellator.addVertex(box.maxX, box.minY, box.minZ);
            tessellator.addVertex(box.maxX, box.minY, box.maxZ);
            tessellator.addVertex(box.minX, box.minY, box.maxZ);
            tessellator.draw();

            // sides
            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.minX, box.minY, box.minZ);
            tessellator.addVertex(box.minX, box.minY, box.maxZ);
            tessellator.addVertex(box.minX, box.maxY, box.maxZ);
            tessellator.addVertex(box.minX, box.maxY, box.minZ);
            tessellator.draw();

            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.maxX, box.minY, box.maxZ);
            tessellator.addVertex(box.maxX, box.minY, box.minZ);
            tessellator.addVertex(box.maxX, box.maxY, box.minZ);
            tessellator.addVertex(box.maxX, box.maxY, box.maxZ);
            tessellator.draw();

            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.maxX, box.minY, box.minZ);
            tessellator.addVertex(box.minX, box.minY, box.minZ);
            tessellator.addVertex(box.minX, box.maxY, box.minZ);
            tessellator.addVertex(box.maxX, box.maxY, box.minZ);
            tessellator.draw();

            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.minX, box.minY, box.maxZ);
            tessellator.addVertex(box.maxX, box.minY, box.maxZ);
            tessellator.addVertex(box.maxX, box.maxY, box.maxZ);
            tessellator.addVertex(box.minX, box.maxY, box.maxZ);
            tessellator.draw();

            // top
            tessellator.startDrawing(GL_LINE_STRIP);
            tessellator.addVertex(box.minX, box.maxY, box.maxZ);
            tessellator.addVertex(box.maxX, box.maxY, box.maxZ);
            tessellator.addVertex(box.maxX, box.maxY, box.minZ);
            tessellator.addVertex(box.minX, box.maxY, box.minZ);
            tessellator.draw();

            glLineWidth(1.0f);
            glDisable(GL_LINE_SMOOTH);

            //glEnable(GL_LIGHTING);
            glEnable(GL_DEPTH_TEST);
            glEnable(GL_TEXTURE_2D);
            glDisable(GL_BLEND);
            glPopMatrix();
        }
    }
}
