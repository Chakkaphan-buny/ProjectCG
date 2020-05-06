

import static javax.swing.SwingConstants.CENTER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Display extends JPanel implements MouseListener,MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LineBorder lineBorder =new LineBorder(Color.white, 5, true);
	public static Image img;
	
	public double w = 640,oldw = 640;
	public double h = 480,oldh = 480;
	public double newWidth,newHeight,oldWidth,oldHeight;
	public int Mx = 0;
	public int My = 0;
	public int ScaX;
	public int ScaY;
	public int rotates;
	public double Sx = 1;
	public double Sy = 1;
	public int mouseX,mouseY;
	Point startPoint, endPoint;
	boolean mouseDragged;
	public JTextField wide;
	public JTextField high;
	public JTextField ScaleX;
	public JTextField ScaleY;
	public JTextField MoveX;
	public JTextField MoveY;
	public JTextField rotate;
	public JButton importBTN;
	public JLabel labelBG;
	
	public Display(){
			repaint();
			addMouseListener(this);
			addMouseMotionListener(this);
		JButton drawBTN = new JButton();
		drawBTN.setBounds(1420, 480, 146, 55);
		ImageIcon icon1 = new ImageIcon("/Users/izenithz/Desktop/CG/Group 1.png");
		drawBTN.setIcon(icon1);
		drawBTN.setOpaque(false);
		drawBTN.setBorderPainted(false);
		drawBTN.addActionListener(new ActionListener(){

	
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				double w = Double.parseDouble(wide.getText());
				double h = Double.parseDouble(high.getText());
				double Sx = Double.parseDouble(ScaleX.getText());
				double Sy = Double.parseDouble(ScaleY.getText());
				rotates = Integer.parseInt(rotate.getText());
				Mx = Integer.parseInt(MoveX.getText());
			    My = Integer.parseInt(MoveY.getText());
				System.out.println(w);
				System.out.println(h);
				double dX = w*Sx;
				ScaX = (int) Math.round(dX);
				double dY = h*Sy;
				ScaY = (int) Math.round(dY);
//				wide.setText(String.valueOf(oldw*Double.parseDouble(ScaleX.getText())));
//				high.setText(String.valueOf(oldh*Double.parseDouble(ScaleY.getText())));
				
			}
		});
		setLayout(null);
		add(drawBTN);		
		high = new JTextField();
		high.setBounds(1525, 175, 120, 26);
		high.setText( "480" );
		high.setHorizontalAlignment(CENTER);
		high.setForeground(Color.white);
		high.setOpaque(false);
		high.setBorder(new RoundBorder());
		add(high);
		high.setColumns(10);
		
		wide = new JTextField();
		wide.setBounds(1370, 175, 120, 26);
		wide.setText( "640" );
		wide.setHorizontalAlignment(CENTER);
		wide.setForeground(Color.white);
		wide.setOpaque(false);
		wide.setBorder(new RoundBorder());
		add(wide);
		wide.setColumns(10);
		
		
		ScaleX = new JTextField();
		ScaleX.setBounds(1370, 258, 120, 26);
		ScaleX.setText( "1.00" );
		ScaleX.setHorizontalAlignment(CENTER);
		ScaleX.setForeground(Color.white);
		ScaleX.setOpaque(false);
		ScaleX.setBorder(new RoundBorder());
		add(ScaleX);
		ScaleX.setColumns(10);
		
		ScaleY = new JTextField();
		ScaleY.setBounds(1525, 258, 120, 26);
		ScaleY.setText( "1.00" );
		ScaleY.setHorizontalAlignment(CENTER);
		ScaleY.setForeground(Color.white);
		ScaleY.setOpaque(false);
		ScaleY.setBorder(new RoundBorder());
		add(ScaleY);
		ScaleY.setColumns(10);
		
		MoveX = new JTextField();
		MoveX.setBounds(1370, 345, 120, 26);
		MoveX.setText( "0" );
		MoveX.setHorizontalAlignment(CENTER);
		MoveX.setForeground(Color.white);
		MoveX.setOpaque(false);
		MoveX.setBorder(new RoundBorder());
		add(MoveX);
		MoveX.setColumns(10);
		
		MoveY = new JTextField();
		MoveY.setBounds(1525, 345, 120, 26);
		MoveY.setText( "0" );
		MoveY.setHorizontalAlignment(CENTER);
		MoveY.setForeground(Color.white);
		MoveY.setOpaque(false);
		MoveY.setBorder(new RoundBorder());
		add(MoveY);
		MoveY.setColumns(10);
		
		rotate = new JTextField("0");
		rotate.setBounds(1370, 423, 275, 35);
		rotate.setText( "0" );
		rotate.setHorizontalAlignment(CENTER);
		rotate.setForeground(Color.white);
		rotate.setOpaque(false);
		rotate.setBorder(new RoundBorder());
		add(rotate);
		rotate.setColumns(10);
		
		
		ImageIcon icon = new ImageIcon("/Users/izenithz/Desktop/CG/Group 2.png");

		importBTN = new JButton(icon);
		importBTN.setBounds(1420, 560, 146, 55);
		importBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		         String curFile = chooser.getSelectedFile().getPath();
		         String image = curFile;
		         img = Toolkit.getDefaultToolkit().getImage(image);
					double dX = oldw*Sx;
					ScaX = (int) Math.round(dX);
					double dY = oldh*Sy;
					ScaY = (int) Math.round(dY);
		         repaint();
		        }
		        
			}
		});

		importBTN.setIcon(icon);
		importBTN.setBorderPainted(false);
		add(importBTN);
		
		labelBG = new JLabel("");
		labelBG.setBounds(2, 2, 1684, 720);
		labelBG.setIcon(new ImageIcon("/Users/izenithz/Desktop/CG/Group 3.png"));
		labelBG.isBackgroundSet();
		
		add(labelBG);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		setBackground(Color.darkGray);
		if(mouseDragged == false) {
			if(rotates == 0) { 
				g2.drawImage(img, Mx, My, ScaX, ScaY, this);  
//				System.out.println(String.valueOf(oldw*newSx));
//				System.out.println(String.valueOf(oldh *newSy));
			}
			else { 
				g2.rotate((Math.toRadians(rotates)),startPoint.x,startPoint.y); 
				g2.drawImage(img, Mx, My, ScaX, ScaY, this); 
				g2.rotate((Math.toRadians(-rotates)),startPoint.x,startPoint.y); 

			}
		}else {
			if(rotates == 0) { 
				g2.drawImage(img, startPoint.x, startPoint.y,(endPoint.x-startPoint.x),(endPoint.y-startPoint.y), this); 
				SetnewScale();
				UpdateVariable();
			}
			
			else { 
				g2.rotate((Math.toRadians(rotates)),startPoint.x,startPoint.y); 
				g2.drawImage(img, startPoint.x, startPoint.y,(endPoint.x-startPoint.x),(endPoint.y-startPoint.y), this);
				g2.rotate((Math.toRadians(-rotates)),startPoint.x,startPoint.y); 
				SetnewScale();
				UpdateVariable();
			}

		}
	}
	public double newSx;
	public double newSy;
	public void UpdateVariable() {
		Sx = newSx;
		Sy = newSy;
}
	
	DecimalFormat decimal = new DecimalFormat("#.##");
	public void SetnewScale() {
			newSx = newWidth/oldw;
			newSy = newHeight/oldh;
			ScaleX.setText(String.valueOf(decimal.format(newSx)));
			ScaleY.setText(String.valueOf(decimal.format(newSy)));
	}	
	@Override
	public void mouseDragged(MouseEvent e) {
		repaint();
		endPoint = new Point(e.getX(), e.getY());
        newWidth = Math.abs(startPoint.x - endPoint.x);
        newHeight = Math.abs(startPoint.y - endPoint.y);   
        MoveX.setText(String.valueOf(startPoint.x));
    	MoveY.setText(String.valueOf(startPoint.y));
		wide.setText(String.valueOf(newWidth));
		high.setText(String.valueOf(newHeight));
		mouseDragged = true;

		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
    	startPoint = new Point(e.getX(), e.getY());
    	oldWidth = newWidth;
    	oldHeight = newHeight;
 
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getX(),e.getY());
		mouseDragged = false;
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
