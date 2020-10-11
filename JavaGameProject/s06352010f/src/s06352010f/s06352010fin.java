package s06352010f;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;

public class s06352010fin {
	
	static ImageIcon atk=new ImageIcon("Images/Saber02.png");
	static ImageIcon man=new ImageIcon("Images/Saber01.png");
	static JLabel lblNewLabel_1 = new JLabel();
	static JButton btnNewButton = new JButton();
	static JButton btnNewButton_1 = new JButton("Attack");
	static Random sped=new Random();
	static int spedInt=50;
	static int score=0;
	static int life=0;
	private JFrame frmIcomin;
	private JLabel lblNewLabel = new JLabel();
	private JLabel lblNewLabel_2 = new JLabel();
	JLabel lblNewLabel_3 = new JLabel("Score:0");
	private final JLabel lblNewLabel_4 = new JLabel("Life:3");
	private final JLabel label = new JLabel("我來了");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					s06352010fin window = new s06352010fin();
					window.frmIcomin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public s06352010fin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmIcomin = new JFrame();
		frmIcomin.setTitle("I'm com'in");
		frmIcomin.setResizable(false);
		frmIcomin.getContentPane().setBackground(new Color(255, 255, 255));
		frmIcomin.setBounds(100, 100, 572, 399);
		frmIcomin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIcomin.getContentPane().setLayout(null);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 280, 558, 0);
		frmIcomin.getContentPane().add(horizontalStrut);
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 99));
		lblNewLabel_1.setText("我走了");
		
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(0, 10, 335, 216);
		frmIcomin.getContentPane().add(lblNewLabel_1);
		
		man.setImage(man.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		ImageIcon mon=new ImageIcon("Images/mon.png");
		mon.setImage(mon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		atk.setImage(atk.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
		
		
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(mon);
		lblNewLabel_2.setBounds(490, 66, 160, 246);
		frmIcomin.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(man);
		lblNewLabel.setBounds(35, 66, 160, 246);
		frmIcomin.getContentPane().add(lblNewLabel);
		
		lblNewLabel_3.setBounds(454, 268, 104, 15);
		frmIcomin.getContentPane().add(lblNewLabel_3);
		
		btnNewButton.setText("Start");
		btnNewButton_1.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				score=0;
				life=3;
				lblNewLabel_4.setText("Life:"+life);
				lblNewLabel_3.setText("Score:"+score);
				btnNewButton.setText("Restart");
				label.setVisible(true);
				lblNewLabel_1.setVisible(false);
				btnNewButton.setVisible(false);
				btnNewButton_1.setVisible(true);
				MoveMoster mm=new MoveMoster();
				mm.ResetX();
				new Thread(mm).start();
				
			}
		});
		
		btnNewButton.setBounds(0, 289, 558, 72);
		frmIcomin.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoveMan cha=new MoveMan();
				new Thread(cha).start();
				if(lblNewLabel_2.getX()>90&&lblNewLabel_2.getX()<142)
				{
					if(spedInt<20&&spedInt>=10) {
						score+=1000;
					}if(spedInt<30&&spedInt>=20) {
						score+=500;
					}if(spedInt<40&&spedInt>=30) {
						score+=200;
					}if(spedInt<=50&&spedInt>=40) {
						score+=100;
					}
					lblNewLabel_3.setText("Score:"+score);
					lblNewLabel_2.setBounds(490, 66, 160, 246);
					spedInt=sped.nextInt(40)+10;
				}
		}
		});
		btnNewButton_1.setBounds(0, 289, 558, 73);
		frmIcomin.getContentPane().add(btnNewButton_1);
		lblNewLabel_4.setBounds(0, 268, 47, 15);
		
		frmIcomin.getContentPane().add(lblNewLabel_4);
		label.setFont(new Font("標楷體", Font.PLAIN, 50));
		label.setBounds(35, 10, 484, 83);
		
		frmIcomin.getContentPane().add(label);
			
	}
	
	class MoveMoster implements Runnable{
		public void run() {
			while(lblNewLabel_2.getX()>=100)
			{
				try {
					Thread.sleep(spedInt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					int labelX=lblNewLabel_2.getX()-10;
					lblNewLabel_2.setLocation(labelX, lblNewLabel_2.getY());
					//frame.getContentPane().add(lblNewLabel_2);
			}
			if(lblNewLabel_2.getX()<=90)
			{
				life--;
				lblNewLabel_4.setText("Life:"+life);
				if(life==0)
				{
				lblNewLabel_1.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton_1.setVisible(false);
				label.setVisible(false);
				int x=0;
				spedInt=50;
				}else {
					lblNewLabel_2.setBounds(490, 66, 160, 246);
					spedInt=sped.nextInt(40)+10;
					run();
				}
			}

		}
		public void Rename() {
			btnNewButton.setVisible(true);
		}
		public void ResetX() {
			lblNewLabel_2.setLocation(490, lblNewLabel_2.getY());
		}
	}
	class MoveMan implements Runnable{
		public void run() {
			
			lblNewLabel.setIcon(atk);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblNewLabel.setIcon(man);
		}
	}
	}


