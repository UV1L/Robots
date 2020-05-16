package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.*;
import StateLogic.MemorableFrame;
import StateLogic.SaveNLoad;
import StateLogic.State;
import log.Logger;
import StateLogic.State;

public class MainApplicationFrame extends JFrame
{
    private final JDesktopPane desktopPane = new JDesktopPane();
    private final HashMap<String, State> allStates = new SaveNLoad().loadStates();
    private final HashMap<String, State> states = new HashMap<String, State>();

    protected MainApplicationFrame() {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
            screenSize.width  - inset*2,
            screenSize.height - inset*2);

        setContentPane(desktopPane);


        LogWindow logWindow = createLogWindow();
        setPrefixState("log", logWindow);
        states.put("log", logWindow.getState());
        addWindow(logWindow);

        GameWindow gameWindow = new GameWindow();
        setPrefixState("game", gameWindow);
        states.put("game", gameWindow.getState());
        addWindow(gameWindow);

        var menuCreator = new MenuCreator(this);
        setJMenuBar(menuCreator.generateMenuBar());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });

    }

    private LogWindow createLogWindow()
    {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10,10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол работает");
        return logWindow;
    }

    /**
     * убрал setVisible
     */
    private void addWindow(JInternalFrame frame)
    {
        desktopPane.add(frame);
    }

    private void close() {
        int choice = JOptionPane.showConfirmDialog(this,
                                                    "Вы точно хотите выйти?",
                                                    "Окно подтверждения",
                                                    JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            new SaveNLoad().saveStates(states);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    private void setPrefixState(String prefix, MemorableFrame window) {
        try {
            var prefixState = allStates.get(prefix);
            if (prefixState != null)
                window.setState(prefixState);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

