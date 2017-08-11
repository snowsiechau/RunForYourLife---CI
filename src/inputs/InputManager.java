package inputs;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public class InputManager {
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean mPressed;

    public boolean wPressed;
    public boolean sPressed;
    public boolean aPressed;
    public boolean dPressed;
    public boolean gPressed;

    public static final InputManager instance = new InputManager();

    private List<InputListener> inputListeners;

    public void register(InputListener inputListener) {
        inputListeners.add(inputListener);
    }

    public void unregister(InputListener inputListener) {
        inputListeners.remove(inputListener);
    }

    private InputManager() {
        inputListeners = new ArrayList<>();
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_G:
                gPressed = true;
                break;
            case KeyEvent.VK_A:
                aPressed = true;
                break;
            case KeyEvent.VK_D:
                dPressed = true;
                break;
            case KeyEvent.VK_W:
                wPressed = true;
                break;
            case KeyEvent.VK_S:
                sPressed = true;
                break;
            case KeyEvent.VK_M:
                mPressed = true;
                break;
            default: break;
        }

        for (InputListener inputListener : inputListeners){
            inputListener.onKeyPressed(keyEvent.getKeyCode());
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_G:
                gPressed = false;
                break;
            case KeyEvent.VK_A:
                aPressed = false;
                break;
            case KeyEvent.VK_D:
                dPressed = false;
                break;
            case KeyEvent.VK_W:
                wPressed = false;
                break;
            case KeyEvent.VK_S:
                sPressed = false;
                break;
            case KeyEvent.VK_M:
                mPressed = false;
                break;
            default: break;
        }

        Iterator<InputListener> iterator = inputListeners.iterator();
        while (iterator.hasNext()) {
            InputListener inputListener = iterator.next();
            if (inputListener.onKeyReleased(keyEvent.getKeyCode())) {
                iterator.remove();
            }
        }
    }
}
