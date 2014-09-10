import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Lightning extends PApplet {

int col;
int rot;
public void setup()
{
 size(800,800);
 colorMode(HSB,360);
 background(0);
}
public void draw()
{
 fill(0,0,0,36);
 stroke(0,0,0,36);
 rect(0,0,800,800);
}
public void mousePressed()
{
 Bolt bob = new Bolt(mouseX,mouseY,col,rot);
 bob.show();
}
public void keyPressed()
{
 if (key == CODED) {
    switch (keyCode)
    {
       case UP : 
      {rot--;
       break;
      }
       case DOWN : 
      {rot++;
       break;
      }
      case LEFT : 
      {col--;
       col%=120;
       while(col<0)
       {col+=120;}
       break;
      }
       case RIGHT : 
      {col++;
       col%=120;
       while(col<0)
       {col+=120;}
       break;
      }
	}
 }
}
class Bolt {
 int x;
 int y;
 int c;
 int r;
 Bolt (int x, int y, int c, int r) {
 this.x = x;
 this.y = y;
 this.c = c;
 this.r = r;
 }
 public void show()
 {
  stroke(3*c,360,180);
  translate(x, y);
  rotate(r*PI/60);
  int startX = 0;
  int startY = 0;
  int endX;
  int endY;
  while(startX<800 && startY<400 && startY>-400)
  {
   endX = startX + (int)(Math.random()*10+1);
   endY = startY + (int)(Math.random()*11-5);
   line(startX, startY, endX, endY);
   startX = endX;
   startY = endY;
  }
 }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Lightning" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
