package StateLogic;

import javax.swing.*;
import java.beans.PropertyVetoException;

/**
 * Класс-расширение для JInternalFrame с возможностью присваивать фрэйму состояние
 * и получать состояние фрэйма
 * @version 1.1
 */
public abstract class MemorableFrame extends JInternalFrame {
    public MemorableFrame(String title,
                          boolean resizable,
                          boolean closable,
                          boolean maximizable,
                          boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
    }

    public void setState(State state) {
        try {
            if (state.isIcon())
                setIcon(true);
        }
        catch (PropertyVetoException ignored) {
        }

        setBounds(state.getCoordinates().first(),
                  state.getCoordinates().second(),
                  state.getBounds().first(),
                  state.getBounds().second());
    }

    public State getState() {
        Pair<Integer, Integer> bounds = new Pair<>(getWidth(), getHeight());
        Pair<Integer, Integer> coordinates = new Pair<>(getX(), getY());
        return new State(isVisible(), isIcon, bounds, coordinates);
    }
}
