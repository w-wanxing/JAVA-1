package eee;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class Information extends JFrame{
	private JPanel panel = new Jpanel();
	private JLabel lb1 = new JLabel("����");
	private JCheckBox cb1 = new JCheckBox("��ë��");
	private JCheckBox cb2 = new JCheckBox("ƹ����");
	private JCheckBox cb3 = new JCheckBox("����");
	private JLabel lb2=new JLabel("�Ա�");
	private JRadioButton rb1=new JRadioButton("��");
	private JRadioButton rb2=new JRadioButton("Ů");
	private ButtonGroup bg=new ButtonGroup();
	private JTextArea area = new JTextArea();
	private JScrollPane pane=new JScrollPane (area);
	private Set<String> hobbies =new HashSet<String>();
	private String gender="";
	private ActionListener listener1 = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			JCheckBox cb = (JCheckBox) e.getSource();
			// ѡ�еĸ�ѡ����ı���ӵ�Set������
			if (cb.isSelected()) {
				hobbies.add(cb.getText());
			//  ��֮�Ӽ������Ƴ�
			} else {
				hobbies.remove(cb.getText());
			}
			print();
		}
	};
	// JRadioButton��ѡ����¼�������
	private ActionListener listener2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JRadioButton jb = (JRadioButton) e.getSource();
			gender = jb.getText();
			print();
		}
	};
    // ��ӡ����
	private void print() {
		// ����ı���
		area.setText("");
		// ���Set��������Ԫ�أ���ӡ��Ȥ
		if (hobbies.size() > 0)
			area.append("�����Ȥ������: ");
		Iterator<String> it = hobbies.iterator();
		while (it.hasNext()) {
			area.append(it.next() + " ");
		}
		// ���gender��Ϊ���ַ�������ӡ�Ա�
		if (!"".equals(gender))
			area.append("����Ա�Ϊ�� " + gender);
	}
	public Information() {
		//��ӱ�ǩ����ѡ�͸�ѡ��ť
		panel.add(lb1);
		panel.add(cb1);
		panel.add(cb2);
		panel.add(cb3);
		panel.add(lb2);
		panel.add(rb1);
		panel.add(rb2);
		bg.add(rb1);
		bg.add(rb2);
		// Ϊ��ѡ�͸�ѡ��ť����¼�������
		cb1.addActionListener(listener1);
		cb2.addActionListener(listener1);
		cb3.addActionListener(listener1);
		rb1.addActionListener(listener2);
		rb2.addActionListener(listener2);
		// ��JPanel����JScrollPane�����ӵ�JFrame������ 
		Container container = this.getContentPane();
		container.add(panel, BorderLayout.NORTH);
		container.add(pane, BorderLayout.CENTER);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Information();
	}
}