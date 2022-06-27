import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName;
    String fileAddress;

    public Function_File(GUI gui){

        this.gui = gui;
    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open(){
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null){//파일이 있으면
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);//파일의 제목 받아오기
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            //파일을 읽어올 주소 + 이름 예를들어 c드라의브 어쩌구 하는 주소 + 파일이름 -> 파일의 위치와 이름

            gui.textArea.setText("");

            String line = null;//한 줄씩 읽어오겠다

            while((line = br.readLine()) != null){
                gui.textArea.append(line + "\n"); //줄 마지막에 줄바꿈 추가
            }
            br.close();
        }
        catch(Exception e){
            System.out.println("File open failed");
        }
    }

    public  void save(){
        if(fileName==null){//보통 처음으로 저장하는 파일
            saveAs();
        }
        else{
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch(Exception e){
                System.out.println("error");
            }
        }
    }

    public void saveAs(){
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            }catch (Exception e){
                System.out.println("error");
            }
        }
    }

    public void exit(){
        System.exit(0);
    }
}