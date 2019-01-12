package test;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class a2 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	//constructors
	private static JTextField text;
	protected JTextArea textArea;
	private static int d = 0, right = 0, finish = 0, last = 19, first = 0, fsize = 20;
	int[] x, y, z, w, a;
	private static int txt1;
	JButton n, b;
	Image img1;
	JLabel picLabel;

	public a2(String txt3) {
		//create panel and get screen size
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		panel.setPreferredSize(new Dimension(dim.width, dim.height));
		fsize = dim.height/40;

		//load background image
		Image i3 = new ImageIcon(getClass().getResource("/resources/Untitled-6.jpg")).getImage();
		Image newimg = i3.getScaledInstance(dim.width, dim.height, java.awt.Image.SCALE_SMOOTH);

		//create label and set background image
		picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(newimg));
		picLabel.setHorizontalAlignment(JLabel.CENTER);
		picLabel.setVerticalAlignment(JLabel.TOP);
		picLabel.setPreferredSize(new Dimension(dim.width, dim.height));
		picLabel.setLayout(new BoxLayout(picLabel, BoxLayout.Y_AXIS));
		panel.add(picLabel);

		//add questions and buttons
		calc(picLabel, txt3);
		add(panel);
		validate();
	}

	public void calc(JLabel picLabel, String txt3) {
		//get button images
		Image i1 = new ImageIcon(getClass().getResource("/resources/bback.jpg")).getImage();
		ImageIcon img1 = new ImageIcon(i1);
		Image i2 = new ImageIcon(getClass().getResource("/resources/bnext.jpg")).getImage();
		ImageIcon img = new ImageIcon(i2);
		//construct buttons
		JButton ch = new JButton("Check");
		JButton n = new JButton();
		JButton b = new JButton();
		final int amount = 20; // number of questions
		//set buttons to be transparent
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b.setIcon(img1);
		n.setOpaque(false);
		n.setContentAreaFilled(false);
		n.setBorderPainted(false);
		n.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n.setIcon(img);
		ch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//construct term numbers as arrays
		int[] x = new int[amount];
		int[] y = new int[amount];
		int[] z = new int[amount];
		int[] a = new int[amount];
		int[] w = new int[amount];
		String [] msg2 = new String [amount];
		boolean[] check = new boolean[amount];
		JLabel label[] = new JLabel[amount];
		String msg = "";
		//set values to term numbers
		for (int i = 0; i < amount; i++) {
			label[i] = new JLabel("x");
			x[i] = (int) (Math.random() * (10 - 1) + 1);
			y[i] = (int) (Math.random() * (10 - 1) + 1);
			z[i] = (int) (Math.random() * (10 - 1) + 1);
			w[i] = (int) (Math.random() * (5 - 1) + 1);
			//multiplication (add)
			if (w[i] == 1) {
				a[i] = ((x[i] * y[i]) + z[i]);
				msg = ((i + 1) + ".  " + a[i] + " = " + y[i] + "x + " + z[i]);
				msg2[i] = (a[i] + " = " + y[i] + "(" + x[i] + ") + " + z[i]);
				label[i].setText(msg);
				label[i].setFont(new Font("Verdana", 1, fsize));
			}
			//multiplication (subtract)
			else if (w[i] == 2) {
				a[i] = ((x[i] * y[i]) - z[i]);
				msg = ((i + 1) + ".  " + a[i] + " = " + y[i] + "x -" + z[i]);
				msg2[i] = (a[i] + " = " + y[i] + " (" + x[i] + ") - " + z[i]);
				label[i].setText(msg);
				label[i].setFont(new Font("Verdana", 1, fsize));
			}
			//addition
			else if (w[i] == 3) {
				a[i] = ((x[i] + y[i]));
				msg = ((i + 1) + ".  " + a[i] + " = x +" + y[i]);
				msg2[i] = (a[i] + " = (" + x[i] + ") + " + y[i]);
				label[i].setText(msg);
				label[i].setFont(new Font("Verdana", 1, fsize));
			}
			//subtraction
			else if (w[i] == 4) {
				a[i] = ((x[i] - y[i]));
				msg = ((i + 1) + ".  " + a[i] + " = x -" + y[i]);
				msg2[i] = (a[i] + " = (" + x[i] + ") - " + y[i]);
				label[i].setText(msg);
				label[i].setFont(new Font("Verdana", 1, fsize));
			}
			picLabel.add(label[i]);
			label[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			label[i].setEnabled(false);
			label[0].setEnabled(true);
		}
		//create text field
		text = new JTextField(10);
		text.setMaximumSize(text.getPreferredSize());
		//check button
		ch.addActionListener(new ActionListener() {
			//when pressed
			@Override
			public void actionPerformed(ActionEvent e) {
				if (d >= 0 && d < amount) {
					try {
						//get answer
						String txt = text.getText();
						txt1 = Integer.parseInt(txt);
						// if correct
						if (txt1 == x[d]) {
							//add counter for how many right
							right++;
							//display and replace a message
							label[d].setVisible(false);
							label[d].setForeground(Color.GREEN);
							label[d].setText("Correct! "+msg2[d]);
							label[d].setVisible(true);
							check[d] = true;
						}
						//if wrong
						else {
							//display and replace a message
							label[d].setVisible(false);
							label[d].setForeground(Color.RED);
							label[d].setText("Wrong! "+msg2[d]);
							label[d].setVisible(true);
							check[d] = true;
						}
						//counter for how many questions
						finish++;
						text.setText("");
						//if its on the last question
						if (d == last) {
							//move back a question and set another last
							last--;
							d--;
							label[d].setEnabled(true);
						} 
						//if its on the first question
						else if (d==first)
						{
							//move forward a question a set another first
							first++;
							d++;
							label[d].setEnabled(true);
						}
						// if not on the last question
						else {
							//move over to the next question
							d++;
							label[d].setEnabled(true);
						}
					} catch (Throwable t) {
						JOptionPane.showMessageDialog(null, "Please enter a valid answer.", "Error", 0);
					}
				}
				//if all questions are done
				if (finish == amount) {
					JOptionPane.showMessageDialog(null, " " + txt3 + " scored " + right + "/20", "Congratulations", 1);
				}
			}

		});
		if (d >= 0 && d <= amount) {
			//next button
			n.addActionListener(new ActionListener() {
				//when pressed
				@Override
				public void actionPerformed(ActionEvent e) {
					//disable current label
					label[d].setEnabled(false);
					//if the next one hasn't been done
					if (!check[d + 1]) {
						//skip to the next question
						d++;
					}
					//if the next one has been done
					else if (check[d + 1]) {
						//skip all questions that are done
						d = d + 2;
						while (check[d]) {
							d++;
						}
					}
					//enable current label
					label[d].setEnabled(true);
					//if its on the last question disable next button
					if (d == last)
						n.setVisible(false);
					else
						b.setVisible(true);
				}
			});
			//back button
			b.addActionListener(new ActionListener() {
				//when pressed
				@Override
				public void actionPerformed(ActionEvent e) {
					//disable current label
					label[d].setEnabled(false);
					//if the one before hasn't been done
					if (!check[d - 1]) {
						//skip to the question before
						d--;
					}
					//if the one before has been done
					else if (check[d - 1]) {
						//skip all questions that are done
						d = d - 2;
						while (check[d]) {
							d--;
						}
					}
					//enable current label
					label[d].setEnabled(true);
					//if its on the first question disable back button
					if (d == first)
						b.setVisible(false);
					else
						n.setVisible(true);
				}
			});
			//default for when no questions have been done to disable next and back button
			if (d >= 0 || d <= amount) {
				if (d == (amount - 1)) {
					n.setVisible(false);
				} else if (d == 0) {
					b.setVisible(false);
				} else {
					b.setVisible(true);
					n.setVisible(true);
				}
			}
		}
		//create panel for buttons
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new BoxLayout(bpanel, BoxLayout.X_AXIS));
		bpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ch.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		bpanel.setBackground(Color.WHITE);
		
		//add buttons and allow good spacing
		bpanel.add(b);
		bpanel.add(Box.createRigidArea(new Dimension(0, 20)));
		bpanel.add(n);
		picLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		picLabel.add(text);
		picLabel.add(Box.createRigidArea(new Dimension(0, 10)));
		picLabel.add(ch);
		picLabel.add(Box.createRigidArea(new Dimension(0, 20)));
		picLabel.add(bpanel);
		validate();

	}

	protected void paintComponent(Graphics2D g) {
		super.paintComponent(g);

	}

	public void actionPerformed(ActionEvent evt) {
		repaint();
	}

	public static void main(String[] args) throws IOException {
		new a1();
	}
}
