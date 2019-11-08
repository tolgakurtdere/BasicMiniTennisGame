
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Oyun extends JPanel implements ActionListener,KeyListener{
    Timer t = new Timer(2, this);
    private int tahtaX = 125;
    private int tahtaY = 410;
    private int topX = 5;
    private int topY = 5;
    private int aX = 1;
    private int aY = 1;
    private int skor = 0;

    public Oyun() {
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.black);
        g.fillRect(tahtaX, tahtaY, 75, 10);
        g.fillOval(topX, topY, 25, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        carpismaKontrol();
        topHareket();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int a = e.getKeyCode();
        
        if(a == KeyEvent.VK_RIGHT){
            if(tahtaX+75 >= 350){
                tahtaX = 350-75;
            }
            else{
                tahtaX += 25;
            }
        }
        else if(a == KeyEvent.VK_LEFT){
            if(tahtaX <= 0){
                tahtaX = 0;
            }
            else{
                tahtaX -= 25;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void topHareket(){
        if(topX >= getWidth()-25){
            aX *= -1;
        }
        if(topX <= 0){
            aX *= -1;
        }
        if(topY >= getHeight()-25){
            aY *= -1;
        }
        if(topY <= 0){
            aY *= -1;
        }
        topX += aX;
        topY += aY;   
    }
    
    public void carpismaKontrol(){
        if(topY+25 == tahtaY && (topX >= tahtaX && topX <= tahtaX+75)){
            aY *= -1;
            skor += 1;
        }
        else if(topY+25 == getHeight()){
            String message = "Game Over! Skor: " + skor;
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }
    }
    
}
