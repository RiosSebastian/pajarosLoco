import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Pajaro extends JPanel  {
  int boardWidth = 360;
  int boardHeight= 640;

  Pajaro (){
    setPreferredSize(new DimensionUIResource(boardWidth, boardHeight));
    setBackground(Color.BLUE);
  }
}
