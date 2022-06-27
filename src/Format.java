import java.awt.*;

public class Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String usingFont;

    public Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){

        if(gui.wordWrapOn==false){
            gui.wordWrapOn=true;
            gui.textArea.setLineWrap(true);//자동 줄바꿈
            gui.textArea.setWrapStyleWord(true);//단어가 줄바꿈에의해 나뉘지 않게
            gui.iWrap.setText("Word Wrap: On");
        }
        else if(gui.wordWrapOn==true){
            gui.wordWrapOn=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: off");
        }
    }

    public void createFont(int fontSize){//폰트 사이즈도 유지해야하니까 폰트사이즈도 받자
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("comic San MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("times New Roman", Font.PLAIN, fontSize);

        setFont(usingFont);
    }

    public void setFont(String font){
        usingFont = font;

        switch (usingFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
