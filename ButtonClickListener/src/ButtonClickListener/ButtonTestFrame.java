package ButtonClickListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonTestFrame extends JFrame{
	JLabel pressedBtnLabel;
	public static void main(String[] args) {
		new ButtonTestFrame();
	}
	
	ButtonTestFrame(){
		setTitle("버튼 눌러 텍스트 보여주기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentP = new JPanel();
		contentP.setLayout(new GridLayout(2,1));
		
		JPanel upP = new JPanel();
		JPanel lowP = new JPanel();
		
		upP.setLayout(new GridLayout(1,3));
		lowP.setLayout(new BorderLayout());
		
		JButton hannamBtn = new JButton("Hannam");
		hannamBtn.addActionListener( e -> buttonClick(e));
		upP.add(hannamBtn);
		
		JButton UniversityBtn = new JButton("University");
		UniversityBtn.addActionListener( e -> buttonClick(e));
		upP.add(UniversityBtn);
		
		JButton StudentBtn = new JButton("Student");
		StudentBtn.addActionListener( e -> buttonClick(e));
		upP.add(StudentBtn);
		
		pressedBtnLabel = new JLabel("PressButton", SwingConstants.CENTER);
		lowP.add(pressedBtnLabel,BorderLayout.CENTER);
		
		contentP.add(upP);
		contentP.add(lowP);
		
		add(contentP);
		setSize(300,150);
		setVisible(true);
	}
	
	public void buttonClick(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		pressedBtnLabel.setText(btn.getText());
	}
}
