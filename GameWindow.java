package gui;

import StateLogic.MemorableFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * класс игрового окна
 * наследуется от MemorableFrame, который, в свою очередь, наследуется от JInternalFrame
 * реализует функционал сохранения и загрузки состояния
 */
public class GameWindow extends MemorableFrame {
    private final GameVisualizer m_visualizer;

    public GameWindow() {
        super("Игровое поле", true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
