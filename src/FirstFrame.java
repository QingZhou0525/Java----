import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 主界面
 *
 */
@SuppressWarnings("serial")
public class FirstFrame extends JFrame {
	
	private JLabel back;//背景
//	private JLabel label01, label02, label03, label04, label05, label06;
	private JButton button01, button02, button03;
	private FirstFrame f;
	
	public FirstFrame(int i) {
		super("水果连连看");
		//设置java图标
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		
		setSize(250, 408);//设置窗体大小
		
		getContentPane().setLayout(null);//清除布局管理器
				
		showBackground();//设置背景
		
		f = this;
	}
			
	//设置背景
	private void showBackground() {
		// TODO Auto-generated method stub
		//背景图片
	 	ImageIcon background = new ImageIcon(getClass().getResource("/images/back.jpg"));
	  	//设置背景标签
        back = new JLabel(background);
        //设置背景图片位置大小
        back.setBounds(0, 0, getWidth(), getHeight());
        //面板透明
        JPanel j = (JPanel)getContentPane();
        j.setOpaque(false);
        //设置背景
        getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
	}

}
