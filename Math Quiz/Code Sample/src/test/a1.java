package test;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class a1 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	//constructors
	JPanel panel = new JPanel();
	JButton switchPic = new JButton();

	JButton bPic = new JButton();
	JLabel picLabel;
	int c = 0;
	int i = 0;
	int currentPic = 0;
	ImageIcon img1, img2, img3, img4, img5, img6;

	public a1() {
		//create panel and get size of the screen
		JPanel panel = new JPanel();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		//load arrow images
		Image i1 = new ImageIcon(getClass().getResource("/resources/right arrow.jpg")).getImage();
		Image n1 = i1.getScaledInstance(100,50,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon img1 = new ImageIcon(n1);
		Image i2 = new ImageIcon(getClass().getResource("/resources/left arrow.jpg")).getImage();
		Image n2 = i2.getScaledInstance(100,50,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(n2);

		//make buttons transparent
		switchPic.setOpaque(false);
		switchPic.setContentAreaFilled(false);
		switchPic.setBorderPainted(false);
		switchPic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		switchPic.setIcon(img1);
		bPic.setOpaque(false);
		bPic.setContentAreaFilled(false);
		bPic.setBorderPainted(false);
		bPic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bPic.setIcon(img2);

		//set the layout for the buttons
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Box.createHorizontalGlue());
		panel.add(Box.createVerticalGlue());
		setPreferredSize(new Dimension(dim.width, dim.height));

		//add buttons and panels
		switchPic.addActionListener(this);
		bPic.addActionListener(this);
		add(panel);
		SetImageSize();
		validate();
	}

	public void SetImageSize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		//create label for the lesson images
		picLabel = new JLabel();
		picLabel.setHorizontalAlignment(JLabel.CENTER);
		picLabel.setVerticalAlignment(JLabel.CENTER);
		picLabel.setPreferredSize(new Dimension(dim.width, dim.height));
		picLabel.add(Box.createHorizontalGlue());
		picLabel.add(Box.createVerticalGlue());
		picLabel.setLayout(new FlowLayout());
		add(picLabel);

		//add buttons to the label for the buttons to be in front
		picLabel.add(bPic);
		picLabel.add(switchPic);
		switchPic.doClick();
		bPic.doClick();

		validate();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void actionPerformed(ActionEvent evt) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		if (currentPic >= 0 && currentPic <= 4) {
			//load lesson images
			Image i3 = new ImageIcon(getClass().getResource("/resources/Untitled-1.jpg")).getImage();
			Image n3 = i3.getScaledInstance(dim.width, dim.height,  java.awt.Image.SCALE_FAST);
			ImageIcon img3 = new ImageIcon(n3);
			Image i4 = new ImageIcon(getClass().getResource("/resources/Untitled-2.jpg")).getImage();
			Image n4 = i4.getScaledInstance(dim.width, dim.height,  java.awt.Image.SCALE_FAST);
			ImageIcon img4 = new ImageIcon(n4);
			Image i5 = new ImageIcon(getClass().getResource("/resources/Untitled-3.jpg")).getImage();
			Image n5 = i5.getScaledInstance(dim.width, dim.height,  java.awt.Image.SCALE_FAST);
			ImageIcon img5 = new ImageIcon(n5);
			Image i6 = new ImageIcon(getClass().getResource("/resources/Untitled-4.jpg")).getImage();
			Image n6 = i6.getScaledInstance(dim.width, dim.height,  java.awt.Image.SCALE_FAST);
			ImageIcon img6 = new ImageIcon(n6);
			
			//get image number
			if (evt.getSource() == switchPic) {
				currentPic++;
			} else if (evt.getSource() == bPic) {
				currentPic--;
			}
			//set image depending on image number
			if (currentPic == 3) {
				switchPic.setVisible(false);
				picLabel.setIcon(img6);
			} else if (currentPic == 2){
				picLabel.setIcon(img5);
			switchPic.setVisible(true);
			bPic.setVisible(true);
			}
			else if (currentPic == 1){
				picLabel.setIcon(img4);
			switchPic.setVisible(true);
			bPic.setVisible(true);
			}
			else if (currentPic == 0) {
				bPic.setVisible(false);
				picLabel.setIcon(img3);
			} 

		} else {
			JOptionPane.showMessageDialog(null, "Error", "Error", 0);
		}
		revalidate();
		repaint();
	}

}
