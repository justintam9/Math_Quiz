/*-----------------------------------------------------------------------------------------*/
/*  This software is designed to educate and teach simple Grade 8 Algebra. Mainly linear   */
/*  equations will be taught with one term maximum. The user will also be able to test    */
/*  and practice what they have learned with a short quiz with multiple randomly generated */
/*  questions.																			   */
/*-----------------------------------------------------------------------------------------*/
/*  Author:  Justin Tam                                                                    */
/*  Date:    1/23/2017                                                                     */
/*-----------------------------------------------------------------------------------------*/
/*  Input:  Choice between learning the lesson or practicing with the quiz. The quiz will  */
/*  accept answers and switching between questions. The lesson will allow the user to flip */
/*  through the different slides.                                                          */
/*  Output: The lesson will display slides based on the buttons clicked. The quiz will show*/
/*  if the answer is correct or wrong.                                                     */                      
/*-----------------------------------------------------------------------------------------*/

package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class mainmethod extends JFrame {
	private static final long serialVersionUID = 1L;
	//constructors
	private JPanel panelMain;
	private a1 panel1;
	private a2 panel2;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JFrame help;
	private static JTextField text;
	private static String[] txt;
	BufferedImage myPicture;
	JLabel picLabel;
	JButton bQ, bL;

	public mainmethod() {
		createWindow();
		addMenu();
	}

	public void createWindow() {
		//create panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMain = new JPanel();
		
		//get size of the screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		setSize(dim.width, dim.height);

		//set default name
		String txt[] = new String[1];
		txt[0] = "You";

		//set up panel
		panelMain.setLayout(new FlowLayout());
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		add(panelMain);

		//load the lesson and quiz panel
		panel1 = new a1();
		panel2 = new a2(txt[0]);

		//get background image
		Image i3 = new ImageIcon(getClass().getResource("/resources/Untitled-5.jpg")).getImage();
		Image newimg = i3.getScaledInstance(dim.width, dim.height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon img3 = new ImageIcon(newimg);
		
		//create label for the background
		picLabel = new JLabel();
		picLabel.setIcon(img3);
		picLabel.setHorizontalAlignment(JLabel.CENTER);
		picLabel.setVerticalAlignment(JLabel.TOP);
		picLabel.setPreferredSize(new Dimension(dim.width, dim.height));
		
		//get dimensions for the layout
		double w,h;
		int w1,h1;
		w = dim.width/9.6;
		h = dim.height/3.6;
		w1 = (int)w;
		h1 = (int)h;
		picLabel.setLayout(new FlowLayout(FlowLayout.CENTER, w1, h1));
		
		//create some spacing
		JPanel bpanel1 = new JPanel();
		bpanel1.setLayout(new BoxLayout(bpanel1, BoxLayout.X_AXIS));

		//add everything to the main panel
		picLabel.add(bpanel1);
		panelMain.add(picLabel);
		addButtons(picLabel, txt);
		validate();
		repaint();
	}
	//menu bar
	public void addMenu() {

		//instantiate menu
		menuBar = new JMenuBar();
		menu = new JMenu("Options");
		menuBar.add(menu);

		//create directions for the main menu button
		menuItem3 = new JMenuItem("Main Menu", KeyEvent.VK_T);
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		
		//when pressed
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//make main panel visible
				panelMain.setVisible(true);
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel1 = new a1();
				panel2 = new a2(txt[0]);
			}
			
		});
		menu.add(menuItem3);

		//create directions for the help button
		menuItem = new JMenuItem("Help");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		
		//when pressed
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instantiate help frame
				a5 h1 = new a5();
				help = new JFrame();
				help.setSize(700, 500);
				help.setTitle("Help");
				help.getContentPane().add(h1);
				help.setVisible(true);
				help.setResizable(false);

			}
		});
		menu.add(menuItem);

		//create directions for the exit button
		menuItem2 = new JMenuItem("Exit", KeyEvent.VK_T);
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		menuItem2.addActionListener(new ActionListener() {
			//when pressed
			public void actionPerformed(ActionEvent e) {
				//close the window
				dispose();
			}
		});
		menu.add(menuItem2);

		setJMenuBar(menuBar);
	}
	//construct and create the buttons
	public void addButtons(JLabel picLabel, String[] txt) {
		//constructors
		JButton bL = new JButton();
		JButton bQ = new JButton();
		JButton save = new JButton("Save");
		text = new JTextField("Enter name here", 10);
		text.setMaximumSize(text.getPreferredSize());
		double w,h;
		int w1,h1;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		//make buttons clear
		bL.setOpaque(false);
		bL.setContentAreaFilled(false);
		bL.setBorderPainted(false);
		bL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bQ.setOpaque(false);
		bQ.setContentAreaFilled(false);
		bQ.setBorderPainted(false);
		bQ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//get dimensions for buttons
		w = dim.width/3.84;
		h = dim.height/5.4;
		w1 = (int)w;
		h1 = (int)h;
		bQ.setPreferredSize(new Dimension(w1,h1));
		bL.setPreferredSize(new Dimension(w1,h1));
		//lesson button
		bL.addActionListener(new ActionListener() {
			//when pressed
			@Override
			public void actionPerformed(ActionEvent e) {
				//make lesson panel visible
				panelMain.setVisible(false);
				add(panel1);
				panel1.setVisible(true);
			}
		});
		//quiz button
		bQ.addActionListener(new ActionListener() {
			//when pressed
			@Override
			public void actionPerformed(ActionEvent e) {
				//make quiz panel visible
				panel2 = new a2(txt[0]);
				panelMain.setVisible(false);
				add(panel2);
				panel2.setVisible(true);
			}
		});
		//save name button
		save.addActionListener(new ActionListener() {
			//when pressed
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the name saved
				String text2 = text.getText();
				txt[0] = text2;
				//default to You when no name is saved
				if (txt[0].equals("Enter name here")) {
					txt[0] = "You";
				}
			}
		});
		
		//create panel for the name fields
		JPanel bpanel = new JPanel();
		bpanel.setBackground(Color.WHITE);
		bpanel.setLayout(new BoxLayout(bpanel, BoxLayout.X_AXIS));
		bpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		save.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		bpanel.add(Box.createRigidArea(new Dimension(200, 10)));
		bpanel.add(text);
		bpanel.add(Box.createRigidArea(new Dimension(50, 10)));
		bpanel.add(save);
		bpanel.add(Box.createRigidArea(new Dimension(600, 10)));
		
		//add buttons and name fields
		picLabel.add(bpanel);
		picLabel.add(bL);
		picLabel.add(bQ);
		validate();
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//instantiate and run
		mainmethod frame = new mainmethod();
		frame.pack();
		frame.setTitle("Fun = Algebra + x");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
