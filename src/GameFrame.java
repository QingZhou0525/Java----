import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


/**
 * 
 * ��ģʽ
 *
 */


@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	private JLabel back;
	private GameFrame g;
	private JButton cancel, restart;//���ذ�ť
	private int LEVEL;//����
	private int GameSize;//���ִ�С��������
	private JProgressBar jpb;//ʱ�������
	private Timer timer; //��ʱ��

	public GameFrame(int GameSize,int t) {
		super(t==-1?"��ʱģʽ":"��"+t+"��");
		//����javaͼ��
		setIconImage(Toolkit.getDefaultToolkit ().getImage(getClass().getResource("/images/icon.png")));
		LEVEL = t;
		this.GameSize = GameSize+2;
		setSize(700, 600);//���ô����С
		ImageIcon background = new ImageIcon(getClass().getResource("/images/background.png"));
	  	 //���ñ�����ǩ
		back = new JLabel(background);
        //���ñ���ͼƬλ�ô�С
		back.setBounds(0, 0, getWidth(), getHeight());
        //���͸��
		JPanel j = (JPanel)getContentPane();
		j.setOpaque(false);
        //���ñ���
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		setVisible(true);
		
		showMenu();
		if(t == -1)
			showTime();
		//�����Ϸ���
		GamePanel jpanel = new GamePanel();
		add(jpanel);
		
		g = this;
		
	}
	
	/*
	 * ��Ӷ�ʱ����
	 */
	private void showTime() {
		jpb = new JProgressBar();
		jpb.setOrientation(JProgressBar.HORIZONTAL);
		jpb.setMinimum(0);//���ý�������Сֵ
		jpb.setMaximum(120);//���ý��������ֵ
		jpb.setValue(0);//���ý�������ǰֵ
		jpb.setBackground(new Color(238,226,29));
		jpb.setBounds(175, 25, 350, 12);
		add(jpb);
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				jpb.setValue(jpb.getValue()+1);
				if(jpb.getValue() > 80)
					jpb.setForeground(Color.RED);
				if(jpb.getValue() == 100) {
					timer.cancel();
					new Dialog(g, 2, LEVEL,"����ʧ��");
				}
			}
		}, 0, 900);
		
	}
	
	/*
	 * ��ӷ��ذ�ť
	 */
	private void showMenu() {
		//LEVEL==-1?"�������˵�":"����ѡ��"
		cancel = new JButton();
		cancel.setBounds(10, 10, 60, 40);
		cancel.setIcon(new ImageIcon(getClass().getResource("/images/home.png")));
		add(cancel);
		
		restart = new JButton();
		restart.setBounds(10, 60, 60, 40);
		restart.setIcon(new ImageIcon(getClass().getResource("/images/restart.png")));
		add(restart);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = g.getLocation();
				g.dispose();
				StartMain.main(null);
				StartMain.e1.setLocation(p);

			}
		});
		
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p = g.getLocation();
				g.dispose();
				GameFrame gameFrame;
				gameFrame = new GameFrame(GameSize-2,LEVEL);
				//�����رմ��尴ť
				gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameFrame.setLayout(null);//������ֹ�����
				
				//���ò�������
				gameFrame.setResizable(false);
				gameFrame.setLocation(p);
				if(timer != null)
					timer.cancel();
			}
		});
	}
	
	class GamePanel extends JPanel implements MouseListener {
		
		private int W = 50;                  //���﷽��ͼ���Ŀ��
	    
	    private Icon icon[];         //ˮ��ͼƬ����
	    private Icon icon_line[];     //����ͼƬ����
	    @SuppressWarnings("rawtypes")
		private ArrayList images_t;        //ˮ��ͼƬ���ɵ�ͼ
	    @SuppressWarnings("rawtypes")
		private ArrayList label_arr;     //label����
	    private int[] path_line;		//����·����ӦͼƬ����
	    
	    private int index=-1;			//��¼�б߿��label
	    @SuppressWarnings("unused")
		private Point p_index;			//��¼�б߿��label
	    private int k;                  //��¼�ڶ������з���
	    
	    private int sum;               //��¼ʣ�µķ���
	    @SuppressWarnings("rawtypes")
		private ArrayList path;      //��¼����·��
	    
	    private int can;            //�Ƿ�������־λ
	    
		public GamePanel() {
			// TODO Auto-generated constructor stub
			setLayout(new GridLayout(GameSize, GameSize));//���񲼾�
			setBounds((700-GameSize*W)/2,(600-GameSize*W)/2,GameSize*W,GameSize*W);
			setOpaque(false);
			initMap();//��ʼ����ͼ
			showGame();//��ʾ��Ϸ���
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private void showGame() {
			// TODO Auto-generated method stub
			label_arr = new ArrayList();
			
			//��ʾˮ��ͼƬ
			for(int i=0;i<GameSize*GameSize;i++) {
				if(i%GameSize==0 || i%GameSize==GameSize-1 || i/GameSize==0 || i/GameSize==GameSize-1) {
					JLabel j = new JLabel();
					j.setIcon(null);
					label_arr.add(j);
					add(j);
					continue;
				}
				int nIndex = new Random().nextInt(images_t.size());
				
				JLabel j = new JLabel(icon[(int) images_t.get(nIndex)]);
				label_arr.add(j);
				j.addMouseListener(this);
				add(j);
				
				images_t.remove(nIndex);
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private void initMap() {
			// TODO Auto-generated method stub
			images_t = new ArrayList();
			path = new ArrayList();
			icon = new Icon[10];
			icon_line = new Icon[6];
			path_line = new int[GameSize*GameSize];
			
			for(int i=0;i<icon.length;i++) {
				icon[i] = new ImageIcon(getClass().getResource("/images/"+"fruit_"+(i+1)+".jpg"));
			}
			for(int i=0;i<icon_line.length;i++) {
				icon_line[i] = new ImageIcon(getClass().getResource("/images/"+"line_"+(i+1)+".png"));
			}
			for(int i=0;images_t.size()<(GameSize-2)*(GameSize-2);i++) {
				images_t.add(i%10);
				if(images_t.size()==(GameSize-2)*(GameSize-2)) {
					continue;
				}
				images_t.add(i%10);
			}
			sum = images_t.size();
			
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private boolean isOK(Point p) {
			
			k = p.x/W+p.y/W*GameSize;
			
			if(index == k)
				return false;
			if(((JLabel)label_arr.get(index)).getIcon()!=((JLabel)label_arr.get(k)).getIcon())
				return false;
			
			//�����ж�
			int index_top=index, index_left=index, index_right=index, index_bottum=index;//��һ�������ĸ����������
			int k_top=k, k_left=k, k_right=k, k_bottum=k;//�ڶ��������ĸ����������
			
			for(int i=index-GameSize;i>0;i-=GameSize) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					index_top = i+GameSize;
					break;
				}
				if(i < GameSize)
					index_top = i;
			}
			for(int i=index-1;i>index/GameSize*GameSize-1;i--) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					index_left = i+1;
					break;
				}
				if(i == index/GameSize*GameSize)
					index_left = index/GameSize*GameSize;
			}
			for(int i=index+1;i<(index/GameSize+1)*GameSize;i++) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					index_right = i-1;
					break;
				}
				if(i == (index/GameSize+1)*GameSize-1)
					index_right = (index/GameSize+1)*GameSize-1;
			}
			for(int i=index+GameSize;i<GameSize*GameSize;i+=GameSize) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					index_bottum = i-GameSize;
					break;
				}
				if(i > GameSize*GameSize-1-GameSize)
					index_bottum = i;
			}
			for(int i=k-GameSize;i>0;i-=GameSize) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					k_top = i+GameSize;
					break;
				}
				if(i < GameSize)
					k_top = i;
			}
			for(int i=k-1;i>k/GameSize*GameSize-1;i--) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					k_left = i+1;
					break;
				}
				if(i == k/GameSize*GameSize)
					k_left = k/GameSize*GameSize;
				
			}
			for(int i=k+1;i<(k/GameSize+1)*GameSize;i++) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					k_right = i-1;
					break;
				}
				if(i == (k/GameSize+1)*GameSize-1)
					k_right = (k/GameSize+1)*GameSize-1;
			}
			for(int i=k+GameSize;i<GameSize*GameSize;i+=GameSize) {
				if(((JLabel)label_arr.get(i)).getIcon() != null) {
					k_bottum = i-GameSize;
					break;
				}
				if(i > GameSize*GameSize-1-GameSize)
					k_bottum = i;
			}
			
			//ˮƽ����
			if(index/GameSize > k/GameSize) {  //��һ���ڵڶ����·�
				int i=index, p1=index+1, f=0;
				while(true) {
					if(i<index_left && p1>index_right)
						break;
					ArrayList arr = new ArrayList();
					if(f == 0) {
						if(i>=index_left && i%GameSize>=k_left%GameSize && i%GameSize<=k_right%GameSize) {
							for(int t = i;t <= index;t++) {
								arr.add(t);
								path_line[t] = 0;
							}
							path_line[i] = 3;

							for(int j = i-GameSize;j>0;j-=GameSize) {
								System.out.println("aaal");
								arr.add(j);
								path_line[j] = 1;
								if(j/GameSize == k/GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+1;t <= k;t++) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 4;
									} else {
										for(int t = j-1;t >= k;t--) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 5;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						i--;
						f = 1;
					} else {
						if(p1<=index_right && p1%GameSize>=k_left%GameSize && p1%GameSize<=k_right%GameSize) {
							for(int t = p1;t >= index;t--) {
								arr.add(t);
								path_line[t] = 0;
							}
							path_line[p1] = 2;		  
							for(int j = p1-GameSize;j>0;j-=GameSize) {
								System.out.println("aaar");
								arr.add(j);
								path_line[j] = 1;
								if(j/GameSize == k/GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+1;t <= k;t++) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 4;
									} else {
										for(int t = j-1;t >= k;t--) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 5;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						p1++;
						f = 0;
					}
				}
			} else if(index/GameSize < k/GameSize) {	  //�ڶ����ڵ�һ���·�
				int i=index,p1=index+1,f=0;
				while(true) {
					if(i<index_left && p1>index_right)
						break;
					ArrayList arr = new ArrayList();
					if(f == 0) {
						if(i>=index_left && i%GameSize>=k_left%GameSize && i%GameSize<=k_right%GameSize) {
							for(int t = i;t <= index;t++) {
								arr.add(t);
								path_line[t] = 0;
							}
							path_line[i] = 4;
							for(int j = i+GameSize;j>0;j+=GameSize) {
								System.out.println("bbbl");
								arr.add(j);
								path_line[j] = 1;
								if(j/GameSize == k/GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+1;t <= k;t++) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 3;
									} else {
										for(int t = j-1;t >= k;t--) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 2;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						i--;
						f = 1;
					} else {
						if(p1<=index_right && p1%GameSize>=k_left%GameSize && p1%GameSize<=k_right%GameSize) {
							for(int t = p1;t >= index;t--) {
								arr.add(t);
								path_line[t] = 0;
							}
							path_line[p1] = 5;
							for(int j = p1+GameSize;j>0;j+=GameSize) {
								System.out.println("bbbr");
								arr.add(j);
								path_line[j] = 1;
								if(j/GameSize == k/GameSize) {
									for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+1;t <= k;t++) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 3;
									} else {
										for(int t = j-1;t >= k;t--) {
											path.add(t);
											path_line[t] = 0;
										}
										path_line[j] = 2;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						p1++;
						f = 0;
					}
				}
			}
			//��ֱ����
			if(index%GameSize < k%GameSize) {		   //��һ���ڵڶ�����
				int i=index, p1=index+GameSize, f=0;
				while(true) {
					if(i<index_top && p1>index_bottum)
						break;
					ArrayList arr = new ArrayList();
					if(f == 0) {
						if(i>=index_top && i/GameSize>=k_top/GameSize && i/GameSize<=k_bottum/GameSize) {
							for(int t = i;t <= index;t+=GameSize) {
									arr.add(t);
									path_line[t] = 1;
								}
							path_line[i] = 4;
							for(int j = i+1;j<(i/GameSize+1)*GameSize-1;j++) {
								System.out.println("ccct");
								arr.add(j);
								path_line[j] = 0;
								if(j%GameSize == k%GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+GameSize;t <= k;t+=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 5;
									} else {
										for(int t = j-GameSize;t >= k;t-=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 2;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						i-=GameSize;
						f = 1;
					} else {
						if(p1<=index_bottum && p1/GameSize>=k_top/GameSize && p1/GameSize<=k_bottum/GameSize) {
							for(int t = p1;t >= index;t-=GameSize) {
									arr.add(t);
									path_line[t] = 1;
								}
							path_line[p1] = 3;
							for(int j = p1+1;j<(p1/GameSize+1)*GameSize-1;j++) {
								System.out.println("cccb");
								arr.add(j);
								path_line[j] = 0;
								if(j%GameSize == k%GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+GameSize;t <= k;t+=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 5;
									} else {
										for(int t = j-GameSize;t >= k;t-=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 2;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						p1+=GameSize;
						f = 0;
					}
				}
			} else if(index%GameSize > k%GameSize) {	   //��һ���ڵڶ����ҷ�
				int i=index, p1=index+GameSize, f=0;
				while(true) {
					if(i<index_top && p1>index_bottum)
						break;
					ArrayList arr = new ArrayList();
					if(f == 0) {
						if(i>=index_top && i/GameSize>=k_top/GameSize && i/GameSize<=k_bottum/GameSize) {
							for(int t = i;t <= index;t+=GameSize) {
								arr.add(t);
								path_line[t] = 1;
							}
							path_line[i] = 5;
							for(int j = i-1;j>i/GameSize*GameSize;j--) {
								System.out.println("dddt");
								arr.add(j);
								path_line[j] = 0;
								if(j%GameSize == k%GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+GameSize;t <= k;t+=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 4;
									} else {
										for(int t = j-GameSize;t >= k;t-=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 3;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						i-=GameSize;
						f = 1;
					} else {
						if(p1<=index_bottum && p1/GameSize>=k_top/GameSize && p1/GameSize<=k_bottum/GameSize) {
							for(int t = p1;t >= index;t-=GameSize) {
								arr.add(t);
								path_line[t] = 1;
							}
							path_line[p1] = 2;
							for(int j = p1-1;j>p1/GameSize*GameSize;j--) {
								System.out.println("dddb");
								arr.add(j);
								path_line[j] = 0;
								if(j%GameSize == k%GameSize) {
									for(int t = 0;t < arr.size();t++) {
										path.add(arr.get(t));
									}
									if(j<k) {
										for(int t = j+GameSize;t <= k;t+=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 4;
									} else {
										for(int t = j-GameSize;t >= k;t-=GameSize) {
											path.add(t);
											path_line[t] =1;
										}
										path_line[j] = 3;
									}
									return true;
								}
								if(((JLabel)label_arr.get(j)).getIcon() != null) {
									arr.clear();
									break;
								}
							}
						}
						p1+=GameSize;
						f = 0;
					}
				}
			}
			
			return false;
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			JLabel j = (JLabel)e.getComponent();//��ȡ�����label
			Point p = j.getLocation(); //��ȡλ��
			if(j.getIcon()!=null)
				if(index != -1) {
					((JLabel)label_arr.get(index)).setBorder(null);//ȡ����һ���߿�
					if(!isOK(p)) {
						j.setBorder(BorderFactory.createLineBorder(Color.RED));  //������ֱ߿�
						//��¼λ��
						p_index = p;
						index = p.x/W+p.y/W*GameSize;
					} else {
						//·��
						for(int i = 0;i < path.size();i++) {
							System.out.print(path.get(i)+" a ");
							if((int)path.get(i) == index || (int)path.get(i) == k)
								continue;
							((JLabel)label_arr.get((int)path.get(i))).setIcon(icon_line[path_line[(int) path.get(i)]]);
						}
						can = 1;
					}
				} else {
					j.setBorder(BorderFactory.createLineBorder(Color.RED));  //������ֱ߿�
					//��¼λ��
					p_index = p;
					index = p.x/W+p.y/W*GameSize;
				}
		}

		@SuppressWarnings("static-access")
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(can == 1) {
				JLabel j = (JLabel)e.getComponent();//��ȡ�����label
				//��ǰ��ͣ1��
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//���·��
				for(int i = 0;i < path.size();i++) {
					((JLabel)label_arr.get((int)path.get(i))).setIcon(null);
				}
				path.clear();//·�����鸴λ
				//����
				((JLabel)label_arr.get(index)).setIcon(null);
				j.setIcon(null);
				
				//��������
				if(PlaySound.b[1]) {
					PlaySound ps = new PlaySound();
					ps.open("sounds/ClearSound.wav");
					ps.play();
					ps.start();
				}
				can = 0;
				
				sum -= 2;
				
				if(sum == 0) {
					if(LEVEL == -1) {
						timer.cancel();
						new Dialog(g,2,LEVEL,"���سɹ�");
						
					} else
						new Dialog(g,1,LEVEL,null);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}