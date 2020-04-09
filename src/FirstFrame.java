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
 * ������
 *
 */
@SuppressWarnings("serial")
public class FirstFrame extends JFrame {
	
	private JLabel back;//����
//	private JLabel label01, label02, label03, label04, label05, label06;
	private JButton button01, button02, button03;
	private FirstFrame f;
	
	public FirstFrame(int i) {
		super("ˮ��������");
		//����javaͼ��
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		
		setSize(250, 408);//���ô����С
		
		getContentPane().setLayout(null);//������ֹ�����
				
		showBackground();//���ñ���
		
		f = this;
	}
			
	//���ñ���
	private void showBackground() {
		// TODO Auto-generated method stub
		//����ͼƬ
	 	ImageIcon background = new ImageIcon(getClass().getResource("/images/back.jpg"));
	  	//���ñ�����ǩ
        back = new JLabel(background);
        //���ñ���ͼƬλ�ô�С
        back.setBounds(0, 0, getWidth(), getHeight());
        //���͸��
        JPanel j = (JPanel)getContentPane();
        j.setOpaque(false);
        //���ñ���
        getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
	}

}
