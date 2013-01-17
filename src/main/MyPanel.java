package main;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{   
	private Image image = null;     
    public MyPanel(Image image) {  
    	this.image = image;
    }
    //固定背景图片，允许这个JPanel可以在图片上添加其他组件
    protected void paintComponent(Graphics   g) {   
    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); 
    }   
}


