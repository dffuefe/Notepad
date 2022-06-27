import java.awt.*;

public class Function_Color {
    GUI gui;

    public Function_Color(GUI gui){
        this.gui = gui;
    }

    public void changeColor(String color){
        switch (color){
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);//글자부분
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(new Color(28,186,186));//RGB값으로 설정하는 예시
                gui.textArea.setBackground(new Color(28,186,186));
                gui.textArea.setForeground(new Color(255,255,255));
                break;


        }
    }
}
