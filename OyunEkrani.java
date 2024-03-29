
import java.awt.HeadlessException;
import javax.swing.JFrame;


public class OyunEkrani extends JFrame{

    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }
    
    public static void main(String[] args) {
        
        OyunEkrani oyun_ekrani = new OyunEkrani("Mini Tenis");
        
        oyun_ekrani.setResizable(false);
        oyun_ekrani.setFocusable(false);
        
        oyun_ekrani.setSize(350, 450);
        oyun_ekrani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyun_ekrani.setLocationRelativeTo(null); //locate screen at the middle
        Oyun oyun = new Oyun();
        
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        
        oyun_ekrani.add(oyun);
        
        oyun_ekrani.setVisible(true);
        
    }
    
}
