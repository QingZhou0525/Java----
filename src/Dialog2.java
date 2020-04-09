import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Dialog2 extends JDialog{
	
	private JLabel sounds, about, pass_level;
	private JButton to_main, to_next, to_new;
	private JCheckBox jcb_1, jcb_2;
	private JTextArea jta;
	private int LEVEL;//����

	public Dialog2(JFrame f,int i, int LEVEL, String s) {
		super(f, true);
		this.LEVEL = LEVEL;
		setLayout(null);//���ò��ֹ�����Ϊ��
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);//���öԻ��򲻿���
		if(i == 0)
			showSetting(f);//��ʾ���öԻ���
		else if(i == 1)
			showOver(f);
		else if(i == 2)
			showTimerOver(f,s);
		
		setVisible(true);//���öԻ�����ʾ
	}
	
	private void showTimerOver(final JFrame f, String s) {
		setTitle("��ʱģʽ");
		setBounds(f.getBounds().x+125, f.getBounds().y+150, 400, 200);//���öԻ���λ�ô�С
		//��ϲ���ر�ǩ
		pass_level = new JLabel(s);
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 40));
		pass_level.setBounds(110, 30, 200, 40);
		add(pass_level);
		
		//�������˵���ť
		to_main = new JButton("�������˵�");
		to_main.setBounds(50, 120, 100, 30);
		add(to_main);
		
		to_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				StartMain.main(null);
				StartMain.e1.setLocation(p);
			}
		});
		
		//��һ�ذ�ť
		to_new = new JButton("���¿�ʼ");
		to_new.setBounds(250, 120, 100, 30);
		add(to_new);
		
		to_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1);
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
	}

	private void showOver(final JFrame f) {
		setTitle("ʧ��");
		setBounds(f.getBounds().x+125, f.getBounds().y+150, 400, 200);//���öԻ���λ�ô�С
		
		//��ϲ���ر�ǩ
		pass_level = new JLabel("��սʧ��");
		pass_level.setFont(new Font("acefont-family", Font.BOLD, 40));
		pass_level.setBounds(110, 30, 200, 40);
		add(pass_level);
		
		//�������˵���ť
		to_main = new JButton("�������˵�");
		to_main.setBounds(50, 120, 100, 30);
		add(to_main);
		
		to_main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				StartMain.main(null);
				StartMain.e1.setLocation(p);
			}
		});
		
		//��һ�ذ�ť
		to_next = new JButton("��һ��");
		to_next.setBounds(250, 120, 100, 30);
		if(LEVEL == 20)
			to_next.setEnabled(false);
		add(to_next);
		
		to_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = f.getLocation();
				f.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(LEVEL>2?8:(int) Math.pow(2, LEVEL+1),LEVEL+1);
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
	}

	private void showSetting(JFrame f) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("����");
		setBounds(f.getBounds().x+75, f.getBounds().y+75, 500, 350);//���öԻ���λ�ô�С
		
		//��Ч��ǩ
		sounds = new JLabel("��Ч:");
		sounds.setFont(new Font("acefont-family", Font.BOLD, 15));
		sounds.setBounds(10, 10, 50, 20);
		add(sounds);
		
		//�������߱�ǩ
		about = new JLabel("��������:");
		about.setFont(new Font("acefont-family", Font.BOLD, 15));
		about.setBounds(10, 75, 100, 20);
		add(about);
		
		//��Чѡ���ѡ��ť
		jcb_1 = new JCheckBox("��������");
		jcb_1.setBounds(20, 40, 80, 20);
		if(PlaySound.b[0])
			jcb_1.setSelected(true);
		add(jcb_1);
		jcb_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				PlaySound.b[0] = !PlaySound.b[0];
				if(!PlaySound.b[0])
				{
					StartMain.p.stop();
				}
				else
					StartMain.p.start();			
				}
		});
		
		jcb_2 = new JCheckBox("������");
		jcb_2.setBounds(120, 40, 80, 20);
		if(PlaySound.b[1])
			jcb_2.setSelected(true);
		add(jcb_2);
		jcb_2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				PlaySound.b[1] = !PlaySound.b[1];
			}
		});
		
	}

}