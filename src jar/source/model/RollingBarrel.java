package source.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class RollingBarrel extends Barrel{
	private BufferedImage bufferedImage1;
	private BufferedImage bufferedImage2;
	private BufferedImage bufferedImage3;
	private BufferedImage bufferedImage4;
	private BufferedImage bufferedImage5;
	private BufferedImage bufferedImage6;
	private Image imageRoll1;
	private Image imageRoll2;
	private Image imageRoll3;
	private Image imageRoll4;
	private Image imageFall1;
	private Image imageFall2;
	private Image img;

	public RollingBarrel(int x, int y){
		super(x, y);
		super.setEnemyType(EnemyType.ROLLING_BARREL);
		
		try {
			bufferedImage1 = ImageIO.read(getClass().getResource("/image/19.png"));
			
			bufferedImage2 = ImageIO.read(getClass().getResource("/image/20.png"));
			
			bufferedImage3 = ImageIO.read(getClass().getResource("/image/21.png"));
			
			bufferedImage4 = ImageIO.read(getClass().getResource("/image/22.png"));
			
			bufferedImage5 = ImageIO.read(getClass().getResource("/image/23.png"));
			
			bufferedImage6 = ImageIO.read(getClass().getResource("/image/24.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageRoll1 =  new ImageIcon(bufferedImage1).getImage();
		imageRoll2 =  new ImageIcon(bufferedImage2).getImage();
		imageRoll3 =  new ImageIcon(bufferedImage3).getImage();
		imageRoll4 =  new ImageIcon(bufferedImage4).getImage();
		imageFall1 =  new ImageIcon(bufferedImage5).getImage();
		imageFall2 =  new ImageIcon(bufferedImage6).getImage();
		
		img= imageRoll1;
	}

	public void animation(){
		if(isFalling()==true){
			if(getY()%40<20) img=imageFall1;
			else if(getY()%40>19) img=imageFall2;
		}
		else if(isFalling()==false){
			if(getX()%100<25) img=imageRoll1;
			else if(getX()%120>24 && getX()%75<50) img=imageRoll2;
			else if(getX()%120>49 && getX()%75<75) img=imageRoll3;
			else if(getX()%40>74) img=imageRoll4;
		}
	}
	
	@Override
	public Image getImage() {
		animation();
		return img;
	}

	@Override
	public boolean continueFalling() {
		return false;
	}
}