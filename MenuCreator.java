package gui;

import log.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 * Класс с методами для создания менюшек
 * @version 1.1
 */
public class MenuCreator {
    /**
     * главное окно, с которым будут работать методы
     */
    private final JFrame frame;

    public MenuCreator(JFrame frame) {
        this.frame = frame;
    }

    protected JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");
        Runnable schemeEvent = () -> setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        addMenu(schemeEvent, lookAndFeelMenu, "Системная схема");
        addMenu(schemeEvent, lookAndFeelMenu, "Универсальная схема");

        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription(
                "Тестовые команды");
        Runnable logEvent = () -> Logger.debug("Новая строка");
        addMenu(logEvent, testMenu, "Сообщение в лог");

        JMenu optionMenu = new JMenu("Опции");
        optionMenu.setMnemonic(KeyEvent.VK_F);
        Runnable exitEvent = () -> Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(
                new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        addMenu(exitEvent, optionMenu, "Выход");

        menuBar.add(optionMenu);
        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);

        return menuBar;
    }

    private void addMenu(Runnable e, JMenu menu, String name) {
        JMenuItem lookAndFeelItem = new JMenuItem(name, KeyEvent.VK_S);
        lookAndFeelItem.addActionListener((event) -> {
            e.run();
            frame.invalidate();
        });
        menu.add(lookAndFeelItem);
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(frame);
        }
        catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }
    }
}
