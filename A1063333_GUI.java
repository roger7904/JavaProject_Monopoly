import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.swing.*;
import javax.swing.JComponent.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
public class A1063333_GUI extends JFrame implements ActionListener{
	private static ArrayList<ImageIcon> image=new ArrayList<ImageIcon>();
	private static ArrayList<JLabel> label=new ArrayList<JLabel>();
	private static ArrayList<JPanel> characterpanel=new ArrayList<JPanel>();
	private static ArrayList<JLabel> characterlabel=new ArrayList<JLabel>();
	private static ArrayList<JLabel> moneylabel=new ArrayList<JLabel>();
	private static ArrayList<Integer> positionx=new ArrayList<Integer>();
	private static ArrayList<Integer> positiony=new ArrayList<Integer>();
	private static ArrayList<Integer> switchnum=new ArrayList<Integer>();
	{
		positionx.add(580);
		positionx.add(470);
		positionx.add(380);
		positionx.add(290);
		positionx.add(200);
		for(int i=0;i<6;i++){	
			positionx.add(90);
		}
		positionx.add(200);
		positionx.add(290);
		positionx.add(380);
		positionx.add(470);
		for(int i=0;i<5;i++){
			positionx.add(580);
		}
		for(int i=0;i<6;i++){
			positiony.add(610);
		}
		positiony.add(490);
		positiony.add(410);
		positiony.add(320);
		positiony.add(230);
		for(int i=0;i<6;i++){
			positiony.add(120);
		}
		positiony.add(230);
		positiony.add(320);
		positiony.add(410);
		positiony.add(490);
	}
	private JLabel labelround,labeldicenum,playerturn;
	private JButton dice;
	private static ArrayList<Integer> characterx=new ArrayList<Integer>();
	private static ArrayList<Integer> charactery=new ArrayList<Integer>();
	public A1063333_GUI() {
			super("A1063333_Checkpoint6");
			setSize(200, 200);
			setResizable(false);  
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel p1=new JPanel();
			JPanel p2=new JPanel();
			JPanel p3=new JPanel();
			p1.setPreferredSize(new Dimension(150,66));
			p2.setPreferredSize(new Dimension(150,66));
			p3.setPreferredSize(new Dimension(150,66));
			JButton btnStart =new JButton("Start");
			JButton btnLoad =new JButton("Load");
			JButton btnExit =new JButton("Exit");
			p1.add(btnStart);
			p2.add(btnLoad);
			p3.add(btnExit);
			btnStart.addActionListener(this);
			btnLoad.addActionListener(this);
			btnExit.addActionListener(this);
			setLayout(new GridLayout(3,1));
			add(p1,BorderLayout.NORTH);
			add(p2,BorderLayout.CENTER);
			add(p3,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent ee){
		String buttonString = ee.getActionCommand() ;
		if(buttonString.equals("Start")) {
			try {
				PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("Character.txt")));
				pw.println("Round:1,Turn:1");
				pw.println("0,1,2000,1,Character_1.png");
				pw.println("0,2,2000,1,Character_2.png");
				pw.println("0,3,2000,1,Character_3.png");
				pw.print("0,4,2000,1,Character_4.png");
				pw.close();
				PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter("Land.txt")));
				pw2.println("LOCATION_NUMBER, owner");
				pw2.print("1,0\n"+"2,0\n"+"3,0\n"+"4,0\n"+"6,0\n"+"7,0\n"+"8,0\n"+"9,0\n"+"11,0\n"+"12,0\n"+"13,0\n"+"14,0\n"+"16,0\n"+"17,0\n"+"18,0\n"+"19,0");
				pw2.close();
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}
			this.dispose();
			try {
				A1063333_Checkpoint6.Load("Character.txt","Land.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			characterx.clear();
				charactery.clear();
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					characterx.add(positionx.get(A1063333_Checkpoint6.player.get(i).location));
					charactery.add(positiony.get(A1063333_Checkpoint6.player.get(i).location));
				}
			A1063333_GUI2 gui3=new A1063333_GUI2();
			gui3.setVisible(true);
			switchnum.clear();
			for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
				switchnum.add(A1063333_Checkpoint6.player.get(i).CHARACTER_NUMBER);
			}
			for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
				moneylabel.get(i).setText(""+A1063333_Checkpoint6.player.get(i).money);
			}
			for(int i=1;i<=4;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=6;i<=9;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=11;i<=14;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=16;i<=19;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
		}
		if(buttonString.equals("Load")) {
			File tempFile = new File("Character.txt");
			File tempFile2 = new File("Land.txt");
			boolean exists = tempFile.exists();
			boolean exists2 = tempFile2.exists();
			if(exists2 && exists){
				try {
					A1063333_Checkpoint6.Load("Character.txt","Land.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				this.dispose();
				characterx.clear();
				charactery.clear();
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					characterx.add(positionx.get(A1063333_Checkpoint6.player.get(i).location));
					charactery.add(positiony.get(A1063333_Checkpoint6.player.get(i).location));
				}
				A1063333_GUI2 gui2=new A1063333_GUI2();
				gui2.setVisible(true);
				switchnum.clear();
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					switchnum.add(A1063333_Checkpoint6.player.get(i).CHARACTER_NUMBER);
				}
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					moneylabel.get(i).setText(""+A1063333_Checkpoint6.player.get(i).money);
				}
				for(int i=1;i<=4;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=6;i<=9;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=11;i<=14;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=16;i<=19;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
			}else{
				JFrame tempJFrame=new JFrame();
				tempJFrame.setSize(150, 100);
				tempJFrame.setResizable(false);  
				tempJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel p11=new JPanel();
				JPanel p22=new JPanel();
				p11.setPreferredSize(new Dimension(100,30));
				p22.setPreferredSize(new Dimension(100,40));
				JLabel l=new JLabel("File not found");
				JButton b=new JButton("Confirm");
				b.setPreferredSize(new Dimension(90,25));
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tempJFrame.dispose();
					}
				  });
				p11.add(l);
				p22.add(b);
				tempJFrame.add(p11,BorderLayout.NORTH);
				tempJFrame.add(p22,BorderLayout.CENTER);
				tempJFrame.setVisible(true);
			}
		}
		if(buttonString.equals("Exit")) {
			System.exit(0);
		}
	}
	private class A1063333_GUI2 extends JFrame implements ActionListener,Runnable{
		public A1063333_GUI2() {
			super("Checkpoint6");
			setSize(700, 700);
			setResizable(false);  
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
				characterx.set(i,positionx.get(A1063333_Checkpoint6.player.get(i).location));
				charactery.set(i,positiony.get(A1063333_Checkpoint6.player.get(i).location));
			}
			for(int i=0;i<=19;i++) {
				image.add(new ImageIcon(i+".png"));
			}
			for(int i=0;i<=19;i++) {
				final int inner=i;
				label.add(new JLabel() {
					public void paintComponent(Graphics g) {
						g.drawImage(image.get(inner).getImage(), 0, 0,image.get(inner).getIconWidth(),image.get(inner).getIconHeight(), null);
						super.paintComponent(g);
					}
				});
				label.get(i).setBackground(Color.WHITE);
				label.get(i).setHorizontalAlignment(label.get(i).CENTER);
				label.get(i).setFont(new Font("Calibri ", Font.BOLD, 25));
				label.get(i).setPreferredSize(new Dimension(image.get(i).getIconWidth(),image.get(i).getIconHeight()));
			}
			JPanel nor=new JPanel();
			JPanel wes=new JPanel();
			JPanel est=new JPanel();
			JPanel cen=new JPanel();
			JPanel sou=new JPanel();
			wes.setBackground(Color.WHITE);
			est.setBackground(Color.WHITE);
			sou.setBackground(Color.WHITE);
			nor.setPreferredSize(new Dimension(700,55));
			wes.setPreferredSize(new Dimension(49,610));
			est.setPreferredSize(new Dimension(49,610));
			sou.setPreferredSize(new Dimension(700,25));
			cen.setPreferredSize(new Dimension(602,610));
			add(nor,BorderLayout.NORTH);
			add(wes,BorderLayout.WEST);
			add(est,BorderLayout.EAST);
			add(cen,BorderLayout.CENTER);
			add(sou,BorderLayout.SOUTH);
			JButton btnexit =new JButton("Exit");
			btnexit.addActionListener(this);
			sou.setLayout(new FlowLayout(FlowLayout.RIGHT));
			sou.add(btnexit);
			btnexit.setPreferredSize(new Dimension(60,18));
			JButton btnsave =new JButton("save");
			JButton btnload =new JButton("load");
			btnload.addActionListener(this);
			btnsave.addActionListener(this);
			btnsave.setPreferredSize(new Dimension(90,25));
			btnload.setPreferredSize(new Dimension(90,25));
			nor.setLayout(new BorderLayout());
			JPanel norwes=new JPanel();
			JPanel norcen=new JPanel();
			norwes.setPreferredSize(new Dimension(200,55));
			norcen.setPreferredSize(new Dimension(500,55));
			nor.add(norwes,BorderLayout.WEST);
			nor.add(norcen,BorderLayout.CENTER);
			norwes.setLayout(new BorderLayout());
			JPanel norwesnor=new JPanel();
			JPanel norwescen=new JPanel();
			norwesnor.setBackground(Color.WHITE);
			norwescen.setBackground(Color.WHITE);
			norwesnor.setPreferredSize(new Dimension(200,10));
			norwes.add(norwesnor,BorderLayout.NORTH);
			norwes.add(norwescen,BorderLayout.CENTER);
			norwescen.setLayout(new FlowLayout(FlowLayout.CENTER));
			norwescen.add(btnsave);
			norwescen.add(btnload);
			for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
				characterpanel.add(new JPanel()) ;
				characterpanel.get(i).setBackground(Color.WHITE);
				characterlabel.add(new JLabel("Character "+A1063333_Checkpoint6.player.get(i).CHARACTER_NUMBER,SwingConstants.CENTER));
				moneylabel.add(new JLabel(""+A1063333_Checkpoint6.player.get(i).money,SwingConstants.CENTER));
				characterpanel.get(i).setLayout(new GridLayout(2,1));
				characterpanel.get(i).add(characterlabel.get(i)).setFont(new Font("Calibri ", Font.BOLD, 18));
				characterpanel.get(i).add(moneylabel.get(i)).setFont(new Font("Calibri ", Font.BOLD, 18));
				norcen.setLayout(new GridLayout(1,A1063333_Checkpoint6.playeramount));
				norcen.add(characterpanel.get(i));
			}
			JPanel cennor=new JPanel();
			JPanel cenwes=new JPanel();
			JPanel cenest=new JPanel();
			JPanel cencen=new JPanel();
			JPanel censou=new JPanel();
			cen.setLayout(new BorderLayout());
			cen.add(cennor,BorderLayout.NORTH);
			cen.add(cenwes,BorderLayout.WEST);
			cen.add(cenest,BorderLayout.EAST);
			cen.add(cencen,BorderLayout.CENTER);
			cen.add(censou,BorderLayout.SOUTH);
			JPanel wrapcennor=new JPanel();
			cennor.setLayout(new BorderLayout());
			cennor.add(label.get(10),BorderLayout.WEST);
			cennor.add(wrapcennor,BorderLayout.CENTER);
			cennor.add(label.get(15),BorderLayout.EAST);
			wrapcennor.setLayout(new GridLayout(1,4));
			for(int i=11;i<=14;i++) {
				wrapcennor.add(label.get(i));
			}
			cenwes.setLayout(new GridLayout(4,1));
			for(int i=9;i>=6;i--) {
				cenwes.add(label.get(i));;
			}
			JPanel wrapcensou=new JPanel();
			censou.setLayout(new BorderLayout());
			censou.add(label.get(5),BorderLayout.WEST);
			censou.add(wrapcensou,BorderLayout.CENTER);
			censou.add(label.get(0),BorderLayout.EAST);
			wrapcensou.setLayout(new GridLayout(1,4));
			for(int i=4;i>=1;i--) {
				wrapcensou.add(label.get(i));
			}
			cenest.setLayout(new GridLayout(4,1));
			for(int i=16;i<=19;i++) {
				cenest.add(label.get(i));
			}
			ImageIcon image_dicenum = new ImageIcon("display_dicenum.png");
			ImageIcon image_dice = new ImageIcon("Dice.png");   
			ImageIcon image_title= new ImageIcon("title.png");
			labeldicenum=new JLabel() {
				protected void paintComponent(Graphics g) {
					 g.drawImage(image_dicenum.getImage(), 35, 10, null);
					 super.paintComponent(g);
				 }
			};	
			labeldicenum.setText("0");
			labeldicenum.setHorizontalAlignment(labeldicenum.CENTER);
			labeldicenum.setFont(new Font("Calibri ", Font.BOLD, 35));
			dice=new JButton(image_dice);
			dice.addActionListener(this);
			dice.setActionCommand("dice");
			JLabel title=new JLabel(image_title);
			dice.setBorder(null);
			dice.setBackground(Color.WHITE);
			JPanel cencennor=new JPanel();
			JPanel cencencen=new JPanel();
			JPanel cencensou=new JPanel();
			cencennor.setBackground(Color.WHITE);
			cencen.setLayout(new BorderLayout());
			cencen.add(cencennor,BorderLayout.NORTH);
			cencen.add(cencencen,BorderLayout.CENTER);
			cencen.add(cencensou,BorderLayout.SOUTH);
			cencennor.setLayout(new FlowLayout(FlowLayout.LEFT));
			cencennor.add(title);
			JPanel cencencenwes=new JPanel();
			JPanel cencencenest=new JPanel();
			cencencenwes.setBackground(Color.WHITE);
			cencencen.setLayout(new BorderLayout());
			cencencen.add(cencencenwes,BorderLayout.WEST);
			cencencen.add(cencencenest,BorderLayout.EAST);
			cencencenwes.add(dice);
			cencencenest.setLayout(new BorderLayout());
			JPanel cencencenestnor=new JPanel();
			JPanel cencencenestcen=new JPanel();
			JPanel cencencenestsou=new JPanel();
			cencencenestnor.setBackground(Color.WHITE);
			cencencenestcen.setBackground(Color.WHITE);
			cencencenestsou.setBackground(Color.WHITE);
			cencencenest.add(cencencenestnor,BorderLayout.NORTH);
			cencencenest.add(cencencenestcen,BorderLayout.CENTER);
			cencencenest.add(cencencenestsou,BorderLayout.SOUTH);
			cencencenestnor.setPreferredSize(new Dimension(190,20));
			cencencenestcen.setPreferredSize(new Dimension(190,120));
			cencencenestsou.setPreferredSize(new Dimension(190,50));
			cencencenestcen.setLayout(new BorderLayout());
			JPanel justlayout=new JPanel();
			justlayout.setPreferredSize(new Dimension(190,1));
			justlayout.setBackground(Color.WHITE);
			cencencenestcen.add(justlayout,BorderLayout.NORTH);
			cencencenestcen.add(labeldicenum,BorderLayout.CENTER);
			labelround=new JLabel("Round"+A1063333_Checkpoint6.round,SwingConstants.LEFT);
			labelround.setFont(new Font("Calibri ", Font.BOLD, 26));
			cencencenestsou.add(labelround);
			JPanel cencensounor=new JPanel();
			JPanel cencensoucen=new JPanel();
			cencensounor.setBackground(Color.WHITE);
			cencensoucen.setBackground(Color.WHITE);
			cencensou.setLayout(new BorderLayout());
			cencensou.add(cencensounor,BorderLayout.NORTH);
			cencensou.add(cencensoucen,BorderLayout.CENTER);
			cencensounor.setPreferredSize(new Dimension(190,30));
			cencensoucen.setLayout(new FlowLayout(FlowLayout.RIGHT));
			playerturn=new JLabel("Turn Character"+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.turn-1).CHARACTER_NUMBER,SwingConstants.RIGHT);
			playerturn.setFont(new Font("Calibri ", Font.BOLD, 30));
			cencensoucen.add(playerturn);
			switchnum.clear();
			for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
				switchnum.add(A1063333_Checkpoint6.player.get(i).CHARACTER_NUMBER);
			}
			for(int i=1;i<=4;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=6;i<=9;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=11;i<=14;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			for(int i=16;i<=19;i++){
				if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
					label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
				}
			}
			repaint();
		}
		public void actionPerformed(ActionEvent e){
			String buttonString = e.getActionCommand() ;
			if(buttonString.equals("load")) {
				setVisible(false);
				try {
					A1063333_Checkpoint6.Load("Character.txt","Land.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
				characterx.clear();
				charactery.clear();
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					characterx.add(positionx.get(A1063333_Checkpoint6.player.get(i).location));
					charactery.add(positiony.get(A1063333_Checkpoint6.player.get(i).location));
				}
				A1063333_GUI2 gui2=new A1063333_GUI2();
				gui2.setVisible(true);
				switchnum.clear();
				
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					switchnum.add(A1063333_Checkpoint6.player.get(i).CHARACTER_NUMBER);
				}
				for(int i=0;i<A1063333_Checkpoint6.playeramount;i++) {
					moneylabel.get(i).setText(""+A1063333_Checkpoint6.player.get(i).money);
				}
				for(int i=1;i<=4;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=6;i<=9;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=11;i<=14;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				for(int i=16;i<=19;i++){
					if(A1063333_Checkpoint6.landmap.get(i).owner!=0){
						label.get(A1063333_Checkpoint6.landmap.get(i).PLACE_NUMBER).setText(""+A1063333_Checkpoint6.player.get(switchnum.indexOf(A1063333_Checkpoint6.landmap.get(i).owner)).CHARACTER_NUMBER);
					}
				}
				repaint();
			}
			if(buttonString.equals("save")) {
				try {
					A1063333_Checkpoint6.Save("Character.txt","Land.txt");
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
			if(buttonString.equals("Exit")) {
				System.exit(0);
			}
			if(buttonString.equals("dice")) {
				A1063333_Checkpoint6.Random();
				labeldicenum.setText(""+A1063333_Checkpoint6.dicenum);	
				Thread t1 = new Thread(this);
				t1.start();
			}
		}
		public void run() {
			dice.setEnabled(false);
			int flagturn = 0;
			flagturn=A1063333_Checkpoint6.previousturn-1;
			int num = 0;
			int golocation = A1063333_Checkpoint6.previouslocation;
			int tolocation = A1063333_Checkpoint6.player.get(flagturn).location;
			int tox = positionx.get(tolocation);
			int toy = positiony.get(tolocation);
			int gogox = positionx.get(golocation);
			int gogoy = positiony.get(golocation);
			int totalgo=Math.abs(tox-gogox)+Math.abs(toy-gogoy);
			if(A1063333_Checkpoint6.dicenum<=3){
				num=(int)(2000/totalgo);
			}else{
				num=(int)(3000/totalgo);
			}
			int flaglocation = 0;
			for (int i = 0; i < A1063333_Checkpoint6.dicenum; i++) {
				if (golocation==19) {
					A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money+=2000;
					flaglocation=0;
				} else {
					flaglocation = golocation + 1;
				}
				int gox = positionx.get(golocation);
				int goy = positiony.get(golocation);
				int flagx = positionx.get(flaglocation);
				int flagy = positiony.get(flaglocation);
				while (characterx.get(flagturn) != flagx || charactery.get(flagturn) != flagy) {
					if ((flagx - gox) == 0) {
						characterx.set(flagturn, characterx.get(flagturn) + 0);
					} else {
						characterx.set(flagturn, characterx.get(flagturn) + (flagx - gox) / Math.abs((flagx - gox)));
					}
					if ((flagy - goy) == 0) {
						charactery.set(flagturn, charactery.get(flagturn) + 0);
					} else {
						charactery.set(flagturn, charactery.get(flagturn) + (flagy - goy) / Math.abs((flagy - goy)));
					}
					repaint();
					try {
						Thread.sleep(num);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if(golocation==19){
					golocation=0;
				}else{
					golocation++;
				}
				moneylabel.get(A1063333_Checkpoint6.previousturn-1).setText(""+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money);
			}
			int eventlocation=A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).location;
			if(eventlocation!=0 && eventlocation!=5 && eventlocation!=10 && eventlocation!=15){
				int PLACE_NUMBER=A1063333_Checkpoint6.landmap.get(eventlocation).PLACE_NUMBER;
				int ownerflag=A1063333_Checkpoint6.landmap.get(eventlocation).owner;
				int owner=switchnum.indexOf(ownerflag)+1;
				int LAND_PRICE=A1063333_Checkpoint6.landmap.get(eventlocation).LAND_PRICE;
				int TOLLS=A1063333_Checkpoint6.landmap.get(eventlocation).TOLLS;
				if (ownerflag==0) {
					if(A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money<LAND_PRICE){
						JDialog.setDefaultLookAndFeelDecorated(true);
						String[] options={"OK"};
						int response = JOptionPane.showOptionDialog(null, "LAND_PRICE is "+LAND_PRICE+",you don't have enough money to buy.", "Not enough money!!",JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					}else{
						JDialog.setDefaultLookAndFeelDecorated(true);
						int response = JOptionPane.showConfirmDialog(null, "Do you want to buy?\n"+LAND_PRICE+"$", "Whether to buy!!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
							A1063333_Checkpoint6.landmap.put(eventlocation,new Land(PLACE_NUMBER, A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).CHARACTER_NUMBER, LAND_PRICE, TOLLS));
							A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money-=LAND_PRICE;
							moneylabel.get(A1063333_Checkpoint6.previousturn-1).setText(""+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money);
							label.get(eventlocation).setText(""+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).CHARACTER_NUMBER);
							repaint();
						}
					}
				}else if(owner==A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).CHARACTER_NUMBER){
				}else{
					JDialog.setDefaultLookAndFeelDecorated(true);
					String[] options={"OK"};
					int response = JOptionPane.showOptionDialog(null, "The owner is Character"+A1063333_Checkpoint6.player.get(owner-1).CHARACTER_NUMBER+",Character"+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).CHARACTER_NUMBER+" need to pay $"+TOLLS+" for tolls.", "Pay for tolls!!",JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money-=TOLLS;
					A1063333_Checkpoint6.player.get(owner-1).money+=TOLLS;
					moneylabel.get(A1063333_Checkpoint6.previousturn-1).setText(""+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.previousturn-1).money);
					moneylabel.get(owner-1).setText(""+A1063333_Checkpoint6.player.get(owner-1).money);
				}
			}
			labelround.setText("Round"+A1063333_Checkpoint6.round);
			playerturn.setText("Turn Character"+A1063333_Checkpoint6.player.get(A1063333_Checkpoint6.turn-1).CHARACTER_NUMBER);
			dice.setEnabled(true);
		}
		public void paint(Graphics g) {
			super.paint(g);
			ImageIcon image_Character_1 = new ImageIcon("Character_1.png");
			ImageIcon image_Character_2 = new ImageIcon("Character_2.png");
			ImageIcon image_Character_3 = new ImageIcon("Character_3.png");
			ImageIcon image_Character_4 = new ImageIcon("Character_4.png");
			if(A1063333_Checkpoint6.playeramount==1){
				g.drawImage(image_Character_1.getImage(),characterx.get(0)-20,charactery.get(0)-20, null);
			}
			if(A1063333_Checkpoint6.playeramount==2){
				g.drawImage(image_Character_1.getImage(),characterx.get(0)-20,charactery.get(0)-20, null);
				g.drawImage(image_Character_2.getImage(),characterx.get(1)+20,charactery.get(1)-20, null);
			}
			if(A1063333_Checkpoint6.playeramount==3){
				g.drawImage(image_Character_1.getImage(),characterx.get(0)-20,charactery.get(0)-20, null);
				g.drawImage(image_Character_2.getImage(),characterx.get(1)+20,charactery.get(1)-20, null);
				g.drawImage(image_Character_3.getImage(),characterx.get(2)-20,charactery.get(2)+20, null);
			}
			if(A1063333_Checkpoint6.playeramount==4){
				g.drawImage(image_Character_1.getImage(),characterx.get(0)-20,charactery.get(0)-20, null);
				g.drawImage(image_Character_2.getImage(),characterx.get(1)+20,charactery.get(1)-20, null);
				g.drawImage(image_Character_3.getImage(),characterx.get(2)-20,charactery.get(2)+20, null);
				g.drawImage(image_Character_4.getImage(),characterx.get(3)+20,charactery.get(3)+20, null);
			}
		}
	}
}
