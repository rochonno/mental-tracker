package tracker.GuiComponents;

import com.codename1.ui.Component;

public class GuiComponent extends Component {

    public void setLocation(final int x, final int y) {
        this.setX(x);
        this.setY(y);
    }

    public void centerAllign(final boolean center) {
        if (center) {
            this.setInlineAllStyles("alignment:center");
        }
    }

    public void setRefLocation(
            final int refX,
            final int refY,
            final int x,
            final int y) {

        setLocation(refX + x, refY + y);
    }

    public void setTraverseIndex(final int index) {
        this.setTraversable(true);
        this.setPreferredTabIndex(index);
    }

    public void setSmoothScroll(final boolean smooth) {
        this.setSmoothScrolling(smooth);
    }

    public void setSizeStr(final String size) {
        this.setPreferredSizeStr(size);
    }

    public int getCenterX() {
        return this.getX();
    }

    public int getCenterY() {
        return this.getY();
    }

    public int getTotalWidth() {
        return this.getWidth();
    }

    public int getTotalHeight() {
        return this.getHeight();
    }
}
