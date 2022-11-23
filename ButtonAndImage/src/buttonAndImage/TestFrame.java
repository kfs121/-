package buttonAndImage;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestFrame extends JFrame {
	int MAX_IMAGE_COUNT = 4;
	JButton leftBtn;
	JButton rightBtn;
	int currImgIndex = 0;
	JLabel imageLabel;
	ImageIcon[] images;
	public static void main(String[] args) {
		new TestFrame();
	}
	
	TestFrame(){
		images = new ImageIcon[MAX_IMAGE_COUNT];
		images[0] = new ImageIcon("images/girl.jpg");
		images[1] = new ImageIcon("images/cat1.jpg");
		images[2] = new ImageIcon("images/cat2.jpg");
		images[3] = new ImageIcon("images/cat3.jpg");
		
		rightBtn = new JButton(new ImageIcon("images/right_btn_normal.png"));
		rightBtn.setRolloverIcon(new ImageIcon("images/right_btn_rollover.png"));
		rightBtn.setPressedIcon(new ImageIcon("images/right_btn_pressed.png"));
		rightBtn.addActionListener(e -> buttonClick(e));
		buttonSet(rightBtn);
		
		leftBtn = new JButton(new ImageIcon("images/left_btn_normal.png"));
		leftBtn.setRolloverIcon(new ImageIcon("images/left_btn_rollover.png"));
		leftBtn.setPressedIcon(new ImageIcon("images/left_btn_pressed.png"));
		leftBtn.addActionListener(e -> buttonClick(e));
		buttonSet(leftBtn);
		
		setTitle("좌우로 이미지 넘기기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentP = new JPanel();
		contentP.setLayout(new BorderLayout());
		
		JPanel centerP = new JPanel();
		JPanel lowP = new JPanel();
		
		lowP.setLayout(new FlowLayout());
		lowP.add(leftBtn);
		lowP.add(rightBtn);

		imageLabel = new JLabel(images[currImgIndex]);
		imageLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		centerP.add(imageLabel);
		
		contentP.add(centerP, BorderLayout.CENTER);
		contentP.add(lowP, BorderLayout.SOUTH);
		
		add(contentP);
		
		setSize(250,300);
		setVisible(true);
	}
	
	void buttonSet(JButton btn) {
		btn.setBorder(BorderFactory.createEmptyBorder());
		btn.setContentAreaFilled(false);
	}
	
	void buttonClick(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == leftBtn) {
			if(currImgIndex > 0) {
				currImgIndex--;
			}
		}else {
			if(currImgIndex < images.length -1) {
				currImgIndex++;
			}
		}
		imageLabel.setIcon(images[currImgIndex]);
	}

}
