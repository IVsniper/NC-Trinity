package trinity.render;
import java.util.ArrayList;

import trinity.render.Tessellator;
import trinity.render.Face;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GroupObject
{
    public String name;
    public ArrayList<Face> faces = new ArrayList<Face>();
    public int glDrawingMode;

    public GroupObject()
    {
        this("");
    }

    public GroupObject(String name)
    {
        this(name, -1);
    }

    public GroupObject(String name, int glDrawingMode)
    {
        this.name = name;
        this.glDrawingMode = glDrawingMode;
    }

    @SideOnly(Side.CLIENT)
    public void render()
    {
        if (faces.size() > 0)
        {
        	
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawing(glDrawingMode);
            render(tessellator);
            tessellator.draw();
        }
    }

    @SideOnly(Side.CLIENT)
    public void render(Tessellator tessellator)
    {
        if (faces.size() > 0)
        {
            for (Face face : faces)
            {
                face.addFaceForRender(tessellator);
            }
        }
    }
}