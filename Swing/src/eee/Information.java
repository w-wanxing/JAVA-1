package eee;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class Information extends JFrame{
	private JPanel panel = new Jpanel();
	private JLabel lb1 = new JLabel("爱好");
	private JCheckBox cb1 = new JCheckBox("羽毛球");
	private JCheckBox cb2 = new JCheckBox("乒乓球");
	private JCheckBox cb3 = new JCheckBox("唱歌");
	private JLabel lb2=new JLabel("性别");
	private JRadioButton rb1=new JRadioButton("男");
	private JRadioButton rb2=new JRadioButton("女");
	private ButtonGroup bg=new ButtonGroup();
	private JTextArea area = new JTextArea();
	private JScrollPane pane=new JScrollPane (area);
	private Set<String> hobbies =new HashSet<String>();
	private String gender="";
	private ActionListener listener1 = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			JCheckBox cb = (JCheckBox) e.getSource();
			// 选中的复选框把文本添加到Set集合中
			if (cb.isSelected()) {
				hobbies.add(cb.getText());
			//  反之从集合中移除
			} else {
				hobbies.remove(cb.getText());
			}
			print();
		}
	};
	// JRadioButton单选框的事件监听器
	private ActionListener listener2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JRadioButton jb = (JRadioButton) e.getSource();
			gender = jb.getText();
			print();
		}
	};
    // 打印方法
	private void print() {
		// 清空文本域
		area.setText("");
		// 如果Set集合中有元素，打印兴趣
		if (hobbies.size() > 0)
			area.append("你的兴趣爱好有: ");
		Iterator<String> it = hobbies.iterator();
		while (it.hasNext()) {
			area.append(it.next() + " ");
		}
		// 如果gender不为空字符串，打印性别
		if (!"".equals(gender))
			area.append("你的性别为： " + gender);
	}
	public Information() {
		//添加标签、单选和复选按钮
		panel.add(lb1);
		panel.add(cb1);
		panel.add(cb2);
		panel.add(cb3);
		panel.add(lb2);
		panel.add(rb1);
		panel.add(rb2);
		bg.add(rb1);
		bg.add(rb2);
		// 为单选和复选按钮添加事件监听器
		cb1.addActionListener(listener1);
		cb2.addActionListener(listener1);
		cb3.addActionListener(listener1);
		rb1.addActionListener(listener2);
		rb2.addActionListener(listener2);
		// 将JPanel面板和JScrollPane面板添加到JFrame容器中 
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