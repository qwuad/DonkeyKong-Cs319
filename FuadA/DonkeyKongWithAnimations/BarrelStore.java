package source;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BarrelStore extends Nonmovable{
	private Image image =  new ImageIcon("src/image/18.png").getImage();
	
	private final boolean PASS_THROUGH = false;
	
	public BarrelStore(int x, int y){
		super(x, y);
	}

	@Override
	public boolean getPassThrough(){
		// TODO Auto-generated method stub
		return PASS_THROUGH;
	}

	public Image getImage() {
		return image;
	}
}