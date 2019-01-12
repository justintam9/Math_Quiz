package test;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class a5 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	//constructors
	JPanel panel = new JPanel();
	JButton b = new JButton("Lesson help");
	JButton n = new JButton("Quiz help");
	JLabel picLabel;
	JFrame frame;

	public a5() {
		//create new frame and panel
		frame = new JFrame ();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Box.createHorizontalGlue());
		panel.add(Box.createVerticalGlue());
		//set buttons to be transparent
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n.setOpaque(false);
		n.setContentAreaFilled(false);
		n.setBorderPainted(false);
		n.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b.addActionListener(this);
		n.addActionListener(this);
		//add images and buttons
		add(panel);
		SetImageSize();
	}
	public void SetImageSize() {
		//create label for the images
		picLabel = new JLabel();
		picLabel.setHorizontalAlignment(JLabel.CENTER);
		picLabel.setVerticalAlignment(JLabel.CENTER);
		picLabel.setPreferredSize(new Dimension(700, 500));
		picLabel.add(Box.createHorizontalGlue());
		picLabel.add(Box.createVerticalGlue());
		picLabel.setLayout(new FlowLayout());

		add(picLabel);
		
		//get default image
		Image i3 = new ImageIcon(getClass().getResource("/resources/Untitled-9.jpg")).getImage();
		Image n3 = i3.getScaledInstance(700, 500,  java.awt.Image.SCALE_FAST);
		ImageIcon l1 = new ImageIcon(n3);
		//add buttons and create spacing
		panel.add(Box.createRigidArea(new Dimension(1000, 0)));
		panel.add(Box.createHorizontalGlue());
		picLabel.add(b);
		picLabel.add(n);
		b.doClick();
		n.doClick();
		picLabel.setIcon(l1);
		validate();
		repaint();
	}
	public void actionPerformed(ActionEvent evt) {
		//get help images
		Image i3 = new ImageIcon(getClass().getResource("/resources/Untitled-9.jpg")).getImage();
		Image n3 = i3.getScaledInstance(700, 500,  java.awt.Image.SCALE_FAST);
		ImageIcon l1 = new ImageIcon(n3);
		Image i4 = new ImageIcon(getClass().getResource("/resources/Untitled-10.jpg")).getImage();
		Image n4 = i4.getScaledInstance(700, 400,  java.awt.Image.SCALE_FAST);
		ImageIcon q1 = new ImageIcon(n4);
		
		//set image depending on which button
		if (evt.getSource() == b) {
			picLabel.setIcon(l1);
		} else if (evt.getSource() == n) {
			picLabel.setIcon(q1);
		}
	}
}
