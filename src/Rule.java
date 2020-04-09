import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.lang.model.type.NullType;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rule extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Rule dialog = new Rule();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Rule() {
		setResizable(false);
		setTitle("\u89C4\u5219&\u8BBE\u7F6E");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
		setBounds(100, 100, 349, 285);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u89C4\u5219\u8BF4\u660E\uFF1A");
			lblNewLabel.setBounds(10, 10, 155, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("1.\u9009\u62E9\u4EFB\u610F\u96BE\u5EA6\u5373\u53EF\u8FDB\u5165\u6E38\u620F\u3002");
			lblNewLabel_1.setBounds(30, 35, 217, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("2.\u76F8\u540C\u7684\u4E24\u5F20\u724C\u7528\u4E09\u6839\u4EE5\u5185\u7684\u76F4\u7EBF\u8FDE\u5728\u4E00\u8D77\u6D88\u9664\u5373\u53EF\u3002");
			lblNewLabel_2.setBounds(30, 60, 322, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("3.\u8FDB\u5EA6\u6761\u7ED3\u675F\u524D\uFF0C\u6D88\u9664\u5168\u90E8\u5361\u7247\u5373\u4E3A\u83B7\u80DC\u3002");
			lblNewLabel_3.setBounds(30, 85, 266, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("4.\u6E38\u620F\u4E2D\u53EF\u968F\u65F6\u8FD4\u56DE\u4E3B\u83DC\u5355\u6216\u5237\u65B0\u6E38\u620F\u3002");
			lblNewLabel_4.setBounds(30, 110, 266, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JButton btnNewButton = new JButton("\u97F3\u4E50\u5173");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StartMain startMain=new StartMain();
					startMain.p.stop();
					startMain.p=null;
				}
			});
			btnNewButton.setBounds(172, 171, 93, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\u97F3\u4E50\u5F00");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StartMain startMain=new StartMain();
					if(startMain.p == null) {
						startMain.p = new PlaySound();
						startMain.p.open("sounds/background.wav");	
						startMain.p.play();
						startMain.p.loop();
						startMain.p.start();
					}
				}
			});
			btnNewButton_1.setBounds(55, 171, 93, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("\u97F3\u4E50\u5F00\u5173\uFF1A");
			lblNewLabel_5.setBounds(10, 146, 112, 15);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u597D\u7684");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
