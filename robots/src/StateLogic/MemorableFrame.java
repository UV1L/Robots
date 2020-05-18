package StateLogic;

import javax.swing.*;

/**
 * Класс-расширение для JInternalFrame с возможностью присваивать фрэйму состояние
 * и получать состояние фрэйма
 * @version 1.0
 */
abstract public class MemorableFrame extends JInternalFrame {
    public MemorableFrame(String title,
                          boolean resizable,
                          boolean closable,
                          boolean maximizable,
                          boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
    }

    public void setState(State state) {
        setVisible(state.isVisible() && state.isDisplayable());

        setBounds(state.getCoordinates().first(),
                  state.getCoordinates().second(),
                  state.getPosition().first(),
                  state.getPosition().second());
    }

    public State getState() {
        var position = new Pair(getWidth(), getHeight());
        var coordinates = new Pair(getX(), getY());
        return new State(isVisible(), isDisplayable(), position, coordinates);
    }
}
