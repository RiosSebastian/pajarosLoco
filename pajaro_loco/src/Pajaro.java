import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Pajaro extends JPanel implements ActionListener,KeyListener  {
  int boardWidth = 360;
  int boardHeight= 640;

//imagenes
  Image BackgroundImg;
  Image birdImg;
  Image topPipeImg;
  Image bottomPipeImg;

 
 //bird
 int birdx = boardWidth / 8;
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
 

    //topes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class Pipe {
      int x = pipeX;
      int y = pipeY;
      int width = pipeWidth;
      int height = pipeHeight;
      Image img;
      boolean passed = false;
      
      Pipe( Image img){
        this.img = img;
      }
    }

    //logica del juego
    Bird bird;
    int velocityX= -4;
    int velocityY = 0;
    int gravity = 1;

    ArrayList<Pipe> pipes;

    Timer gameloop;
    Timer placePipesTimer; 

  Pajaro (){
    setPreferredSize(new DimensionUIResource(boardWidth, boardHeight));
    setFocusable(true);
    addKeyListener(this);
    //carga de imagenes
    BackgroundImg = new ImageIcon(getClass().getResource("/img/BG.png")).getImage();
    topPipeImg = new ImageIcon(getClass().getResource("/img/toppipe.png")).getImage();
    bottomPipeImg = new ImageIcon(getClass().getResource("/img/bottompipe.png")).getImage();
    birdImg = new ImageIcon(getClass().getResource("/img/Crow_01.png")).getImage();

    bird = new Bird(birdImg);
    pipes = new ArrayList<Pipe>();

    placePipesTimer = new Timer(1500, new ActionListener() {
      
        @Override
        public void actionPerformed(ActionEvent e) {
          placePipes();
        }
    });

    placePipesTimer.start();

    //tiempo de juego
    gameloop = new Timer(1000/60, this);
    gameloop.start();
  }

  public void placePipes(){
    Pipe topPipe = new Pipe(topPipeImg);
    pipes.add(topPipe);
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
    g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height,  null);

    for(int i = 0; i < pipes.size(); i++){
      Pipe pipe = pipes.get(i);
      g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
    }
  }

  public void move(){
    velocityY += gravity;
    bird.y += velocityY; 
    bird.y = Math.max(bird.y, 0);

      for(int i = 0; i < pipes.size(); i++){
      Pipe pipe = pipes.get(i);
     pipe.x += velocityX;
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    repaint();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      velocityY = -9;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
 
  }

  @Override
  public void keyReleased(KeyEvent e) {
   
  } 

}
