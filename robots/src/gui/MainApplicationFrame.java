package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import StateLogic.MemorableFrame;
import StateLogic.Pair;
import StateLogic.SaveNLoad;
import StateLogic.State;
import log.Logger;

public class MainApplicationFrame extends JFrame
{

    private final JDesktopPane desktopPane = new JDesktopPane();
    private final ArrayList<String> allStates = new SaveNLoad().loadStates();
    private final HashMap<String, State> states = new HashMap<>();
    private final LogWindow logWindow;
    private final GameWindow gameWindow;

    protected MainApplicationFrame() {
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
            screenSize.width  - inset*2,
            screenSize.height - inset*2);

        setContentPane(desktopPane);


        logWindow = createLogWindow();
        setPrefixState("log", logWindow);
        addWindow(logWindow);

        gameWindow = new GameWindow();
        setPrefixState("game", gameWindow);
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
        frame.setVisible(true);
    }

    /**
     * метод вызывает диалоговое окно закрытия приложения
     * при нажатии на "yes" все состояния сохранятся в файл
     */
    private void close() {
        int choice = JOptionPane.showConfirmDialog(this,
                                                    "Вы точно хотите выйти?",
                                                    "Окно подтверждения",
                                                    JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            states.put("log", logWindow.getState());
            states.put("game", gameWindow.getState());
            new SaveNLoad().saveStates(states);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    /**
     * устанавливает состояние переданному фрэйму
     * @param prefix для парсинга нужного состояния
     * @param window фрэйм
     */
    private void setPrefixState(String prefix, MemorableFrame window) {
        for (var str:
             allStates) {
            if (str.contains(prefix)) {
                var params = str.split(" ");
                var width = Integer.parseInt(params[1]);
                var height = Integer.parseInt(params[2]);
                var x = Integer.parseInt(params[3]);
                var y = Integer.parseInt(params[4]);
                try {
                    var position = new Pair(width, height);
                    var coordinates = new Pair(x, y);
                    var isVisible = params[5].equals("true");
                    var isIcon = params[6].equals("true");

                    State prefixState = new State(isVisible, isIcon, position, coordinates);
                    window.setState(prefixState);
                }
                catch (NumberFormatException ignored) {
                    System.out.println(ignored);
                }
            }
        }
    }
}

