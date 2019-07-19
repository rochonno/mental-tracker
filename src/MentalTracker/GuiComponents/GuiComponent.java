package MentalTracker.GuiComponents;

import com.codename1.ui.Component;

public class GuiComponent extends Component{

    public void SetLocation(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public void CenterAllign (boolean center)
    {
        if (center) { this.setInlineAllStyles("alignment:center"); }
    }

    public void SetRefLocation (int refX, int refY, int x, int y)
    {
        SetLocation(refX + x, refY + y);
    }

    public void SetTraverseIndex (int index)
    {
        this.setTraversable(true);
        this.setPreferredTabIndex(index);
    }

    public void SetSmoothScroll (boolean smooth)
    {
        this.setSmoothScrolling(smooth);
    }


    public void SetSize (String size) { this.setPreferredSizeStr(size); }

    public int GetCenterX () { return this.getX(); }
    public int GetCenterY () { return this.getY(); }
    public int GetWidth () { return this.getWidth(); }
    public int GetHeight () { return this.getHeight(); }
}
