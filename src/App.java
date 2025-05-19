
/**
 * The App class serves as the entry point for the application.
 * It initializes and displays the main application window using SwingUtilities
 * to ensure thread safety in the Swing UI.
 */
import javax.swing.SwingUtilities;

import com.ripadbisor.views.MainFrame;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
