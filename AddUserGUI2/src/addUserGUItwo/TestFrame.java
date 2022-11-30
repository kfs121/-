package addUserGUItwo;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestFrame extends JFrame {
	JTextField stuNumTF = new JTextField();
	JTextField nameTF = new JTextField(20);
	JTextArea addedUserTA = new JTextArea(6,20);
	JComboBox typeCombo;
	public static void main(String[] args) {
		new TestFrame();
	}
	
	TestFrame(){
		String[] comboWords = {"=선택=","교수", "직원", "학생"};
		typeCombo = new JComboBox(comboWords);
		JButton addBtn = new JButton();
		addBtn = new JButton(new ImageIcon("images/left_btn_normal.png"));
		addBtn.setRolloverIcon(new ImageIcon("images/left_btn_rollover.png"));
		addBtn.setPressedIcon(new ImageIcon("images/left_btn_pressed.png"));
		addBtn.setBorder(BorderFactory.createEmptyBorder());
		addBtn.setContentAreaFilled(false);
		
		addedUserTA.setEditable(false);
		
		setTitle("사용자 등록 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentP = new JPanel(new BorderLayout());
		
		JPanel northP = new JPanel(new GridLayout(3,2));
		JPanel centerP = new JPanel(new BorderLayout());
		JPanel southP = new JPanel(new BorderLayout());
		
		northP.add(new JLabel("학번"));
		northP.add(stuNumTF);
		northP.add(new JLabel("타입"));
		northP.add(typeCombo);
		northP.add(new JLabel("이름"));
		northP.add(nameTF);
		
		
		addBtn.addActionListener(e -> buttonClick());
		centerP.add(addBtn,BorderLayout.CENTER);
		southP.add(new JScrollPane(addedUserTA),BorderLayout.CENTER);
		
		contentP.add(northP,BorderLayout.NORTH);
		contentP.add(centerP, BorderLayout.CENTER);
		contentP.add(southP,BorderLayout.SOUTH);
		
		add(contentP);
		setSize(500,310);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void buttonClick() {
		StringBuilder stb = new StringBuilder();
		String selectedComboWord = null;
		if(typeCombo.getSelectedIndex() == 0) {
			warringMessage("콤보박스를 선택하세요.");
			return;         	
		}else if(stuNumTF.getText().isBlank()) {
			warringMessage("학번을 입력하세요.");
			return;
		}else if(nameTF.getText().isBlank()) {
			warringMessage("이름을 입력하세요.");
			return;
		}
		selectedComboWord = typeCombo.getSelectedItem().toString();
		stb.append("id:").append(stuNumTF.getText()).append(", ").append("type: ").append(selectedComboWord).append(", ").append("name: ").append(nameTF.getText()).append("\n");
		addedUserTA.append(stb.toString());
		setBlank();
	}
	
	void warringMessage(String message) {
		JOptionPane.showMessageDialog(getContentPane(), message,"ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	void setBlank() {
		typeCombo.setSelectedIndex(0);
		stuNumTF.setText("");
		nameTF.setText("");
	}
}
