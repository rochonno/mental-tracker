package tracker.GuiComponents.Individual;

import com.codename1.components.ImageViewer;
import com.codename1.ui.util.Resources;

/**
 * Class to display an image on the screen.
 */
public class GuiImageViewer {

    private ImageViewer _Viewer;

    public GuiImageViewer(final String name, final Resources instanceTheme, final String image) {
        _Viewer = new ImageViewer();
        _Viewer.setName(name);
        _Viewer.setImage(instanceTheme.getImage(image));
    }

    public ImageViewer getImageViewer() {
        return _Viewer;
    }

    public String getName() {
        return _Viewer.getName();
    }
}
