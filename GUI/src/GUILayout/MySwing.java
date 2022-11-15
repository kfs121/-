package GUILayout;

import java.awt.*;
import javax.swing.*;

public class MySwing extends JFrame{

	public static void main(String[] args) {
		new MySwing();
	}
	
	MySwing(){
		setTitle("Multiple Layout Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentP = new JPanel();
		contentP.setLayout(new BorderLayout());
		
		JPanel upBgP = new JPanel();
		JPanel lowP = new JPanel();
		
		JButton okB = new JButton("OK");
		okB.setPreferredSize(new Dimension(100,30));
		lowP.add(okB);
		
		contentP.add(lowP, BorderLayout.SOUTH);
		
		upBgP.setLayout(new GridLayout(1,2));
		
		JPanel upLeftP = new JPanel();
		upLeftP.setLayout(new GridLayout(4,1));
		upLeftP.setBackground(Color.yellow);
		upLeftP.add(new JLabel("Type ID", SwingConstants.CENTER));
		upLeftP.add(new JTextField(""));
		upLeftP.add(new JLabel("Type Password", SwingConstants.CENTER));
		upLeftP.add(new JTextField(""));
		
		JPanel upRightP = new JPanel();
		upRightP.setLayout(new GridLayout(3,1));
		upRightP.setBackground(Color.green);
		upRightP.add(new JLabel("Please check!!", SwingConstants.CENTER));
		upRightP.add(new JLabel("C# JCheckBox", SwingConstants.CENTER));
		upRightP.add(new JLabel("C++ JCheckBox", SwingConstants.CENTER));
		
		upBgP.add(upLeftP);
		upBgP.add(upRightP);
		
		contentP.add(upBgP);
		
		add(contentP);
		setSize(300,150);
		setVisible(true);
	}

}
