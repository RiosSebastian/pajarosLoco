import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Pajaro extends JPanel implements ActionListener  {
  int boardWidth = 360;
  int boardHeight= 640;

//imagenes
  Image BackgroundImg;
  Image birdImg;
  Image topPipeImg;
  Image bottomPipeImg;

 
 //bird
 int birdx = boardWidth / 16;
 int birdy = boardHeight / 2;
 int bridWidth = 34;
 int bridHeight = 24;

 class Bird{
  int x = birdx;
  int y = birdy;
  int width = bridWidth;
  int height = bridHeight;
  Image img;

  Bird(Image img){
    this.img = img;
  }

 }
 

    //logica del juego
    Bird bird;
    int velocity = -6;
    Timer gameloop;

  Pajaro (){
    setPreferredSize(new DimensionUIResource(boardWidth, boardHeight));
    
    //carga de imagenes
    BackgroundImg = new ImageIcon(getClass().getResource("/img/BG.png")).getImage();
    topPipeImg = new ImageIcon(getClass().getResource("/img/toppipe.png")).getImage();
    bottomPipeImg = new ImageIcon(getClass().getResource("/img/bottompipe.png")).getImage();
    birdImg = new ImageIcon(getClass().getResource("/img/CrowV2_fly_01.png")).getImage();

    bird = new Bird(birdImg);

    //tiempo de juego
    gameloop = new Timer(1000/60, this);
    gameloop.start();
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
  }

  public void draw(Graphics g){
    System.out.println("draw");

    //background
    g.drawImage(BackgroundImg, 0, 0, boardWidth, boardHeight, null);

    //bird
    g.drawImage(birdImg, birdx, birdy, bridWidth, bridHeight,  null);
  }

  public void move(){
    bird.y += velocity; 
    bird.y = Math.max(bird.y, 0);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    repaint();
  }
}
