package addUserGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestFrame extends JFrame {
	JTextField stuNumTF = new JTextField();
	ButtonGroup typeBtnG = new ButtonGroup();
	JTextField nameTF = new JTextField(20);
	JRadioButton[] rBtns = new JRadioButton[3];
	JTextArea addedUserTA = new JTextArea(6,20);
	
	public static void main(String[] args) {
		new TestFrame();
	}
	
	TestFrame(){
		String[] rBtnWords = {"교수", "직원", "학생"};
		JButton addBtn = new JButton();
		addBtn = new JButton(new ImageIcon("images/left_btn_normal.png"));
		addBtn.setRolloverIcon(new ImageIcon("images/left_btn_rollover.png"));
		addBtn.setPressedIcon(new ImageIcon("images/left_btn_pressed.png"));
		addBtn.setBorder(BorderFactory.createEmptyBorder());
		addBtn.setContentAreaFilled(false);
		
		setTitle("사용자 등록 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentP = new JPanel(new BorderLayout());
		
		JPanel northP = new JPanel(new GridLayout(3,2));
		JPanel centerP = new JPanel(new BorderLayout());
		JPanel southP = new JPanel(new BorderLayout());
		
		JPanel radioP = new JPanel();
		
		northP.add(new JLabel("학번"));
		northP.add(stuNumTF);
		northP.add(new JLabel("타입"));
		northP.add(radioP);
		northP.add(new JLabel("이름"));
		northP.add(nameTF);
		
		for(int i = 0; i < rBtns.length; i++) {
			rBtns[i] = new JRadioButton(rBtnWords[i]);
			typeBtnG.add(rBtns[i]);
			radioP.add(rBtns[i]);
		}
		
		addBtn.addActionListener(e -> buttonClick());
		centerP.add(addBtn,BorderLayout.CENTER);
		southP.add(new JScrollPane(addedUserTA),BorderLayout.CENTER);
		
		contentP.add(northP,BorderLayout.NORTH);
		contentP.add(centerP, BorderLayout.CENTER);
		contentP.add(southP,BorderLayout.SOUTH);
		
		add(contentP);
		setSize(500,310);
		setVisible(true);
	}
	
	void buttonClick() {
		StringBuilder stb = new StringBuilder();
		String selectedRbtnWord = null;
		for(int i = 0; i < rBtns.length; i++) {
			if (rBtns[i].isSelected()) {
				selectedRbtnWord = rBtns[i].getText();
				rBtns[i].setSelected(false);
				break;
			}
		}
		stb.append("id:").append(stuNumTF.getText()).append(", ").append("type: ").append(selectedRbtnWord).append(", ").append("name: ").append(nameTF.getText()).append("\n");
		addedUserTA.append(stb.toString());
	}
}
