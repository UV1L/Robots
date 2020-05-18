package gui;

import StateLogic.MemorableFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Изменено наследование
 */
public class GameWindow extends MemorableFrame
{
    private final GameVisualizer m_visualizer;
    public GameWindow() 
    {
        super("Игровое поле", true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
