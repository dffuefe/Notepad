import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    GUI gui;

    //생성자
   public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //컨트롤+S를 누르면 저장
       if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
           gui.file.save();
       }
       if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
           gui.edit.undo();
       }
       //보다 복잡한 입력은 getExtendedKeyCodeForChar을 활용
       if(e.isControlDown() && e.getKeyCode()==KeyEvent.getExtendedKeyCodeForChar(KeyEvent.VK_Y)){
           gui.edit.redo();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
