import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.nio.channels.OverlappingFileLockException;

import javax.management.openmbean.OpenDataException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Font;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;


public class StartMain {
	static FirstFrame e1;
	static PlaySound p;//声音对象
	
	public static void main(String agrs[]) {	      
	    e1 = new FirstFrame(0);
		//监听关闭窗体按钮
		e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置可视
		e1.setVisible(true);
		//设置不可拉伸
		e1.setResizable(false);
		
		
				
		JButton btnNewButton = new JButton("\u7B80\u5355\u96BE\u5EA6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		btnNewButton.setBounds(65, 106, 111, 23);
		e1.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6B63\u5E38\u96BE\u5EA6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame2 gameFrame;
				gameFrame = new GameFrame2(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		btnNewButton_1.setBounds(65, 139, 111, 23);
		e1.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u56F0\u96BE\u96BE\u5EA6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame3 gameFrame;
				gameFrame = new GameFrame3(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		btnNewButton_2.setBounds(65, 172, 111, 23);
		e1.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5730\u72F1\u96BE\u5EA6");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame4 gameFrame;
				gameFrame = new GameFrame4(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		btnNewButton_3.setBounds(65, 205, 111, 23);
		e1.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5173\u4E8E");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.show();
			}
		});
		btnNewButton_4.setBounds(65, 271, 111, 23);
		e1.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u9000\u51FA");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5.setBounds(65, 304, 111, 23);
		e1.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u89C4\u5219&\u8BBE\u7F6E");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rule rule=new Rule();
				rule.show();
			}
		});
		btnNewButton_6.setBounds(65, 238, 111, 23);
		e1.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel(" \u6C34\u679C\u8FDE\u8FDE\u770B");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 23));
		lblNewLabel.setBounds(49, 43, 140, 42);
		e1.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 244, 35);
		e1.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5F00\u59CB");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7B80\u5355\u96BE\u5EA6");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6B63\u5E38\u96BE\u5EA6");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame2 gameFrame;
				gameFrame = new GameFrame2(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56F0\u96BE\u96BE\u5EA6");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame3 gameFrame;
				gameFrame = new GameFrame3(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5730\u72F1\u96BE\u5EA6");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = StartMain.e1.getLocation();
				StartMain.e1.dispose();
				GameFrame4 gameFrame;
				gameFrame = new GameFrame4(8,-1);
				//监听关闭窗体按钮
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.getContentPane().setLayout(null);//清除布局管理器
				
				//设置不可拉伸
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u4E86\u89E3");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u89C4\u5219&\u8BBE\u7F6E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rule rule=new Rule();
				rule.show();
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5173\u4E8E");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.show();
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		
		
		
		
		if(p == null) {
			//声音设置
			p = new PlaySound();
				p.open("sounds/background.wav");
				p.play();
				p.loop();
				p.start();
		}
		
		
   }
}
