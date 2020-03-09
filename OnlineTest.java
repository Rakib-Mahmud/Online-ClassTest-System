/*Online Java Paper Test*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	final JLabel timer = new JLabel("--:--");
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=1,x=1,y=1,now=0,no_ques=0,tmp=0;
	static int is_ckd=0;
	ResultSet rs;
	int m[]=new int[10];
	static String id1;
	//id1=tst.id;
	Connection conect=Database.dbConnector();
	String str;
	int c=0;
	boolean flag=true;
	//AddQuestion ad=new AddQuestion();
	static int ll;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					OnlineTest frame = new OnlineTest(id1);
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	OnlineTest(String s)
	{
		super(s);
		Game();
		JPanel panel = new JPanel();
		panel.setBounds(0, 300, 584, -299);
		getContentPane().add(panel);
		panel.setLayout(null);
		l=new JLabel();
		l.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l.setForeground(new Color(240, 255, 240));
		getContentPane().add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			getContentPane().add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b1.setBackground(new Color(238, 232, 170));
		b1.setForeground(new Color(0, 0, 205));
		b1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		b2=new JButton("Bookmark");
		b2.setBackground(new Color(175, 238, 238));
		b2.setForeground(new Color(128, 0, 0));
		b2.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		b1.addActionListener(this);
		b2.addActionListener(this);
		getContentPane().add(b1);getContentPane().add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,200,20);
		jb[1].setBounds(50,110,200,20);
		jb[2].setBounds(50,140,200,20);
		jb[3].setBounds(50,170,200,20);
		b1.setBounds(100,240,107,30);
		b2.setBounds(270,240,107,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		timer.setFont(new Font("Tahoma", Font.BOLD, 16));
		timer.setForeground(Color.WHITE);
		timer.setBounds(0, 0, 46, 14);
		getContentPane().add(timer);
	    timer.setForeground(Color.GREEN);
	    //Game();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("F:\\Download\\Webp.net-resizeimage (4).jpg"));
		lblNewLabel.setBounds(0, 0, 584, 311);
		getContentPane().add(lblNewLabel);
		setLocation(250,100);
		setVisible(true);
		setSize(597,348);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		//if(e.getSource()==b1)
		if(e.getActionCommand().equals("Next"))
		{
			if(check(current))
				count=count+1;
			current++;
			set();	
			if(flag==false)
			{
				b1.setEnabled(false);
				b2.setText("Submit");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			getContentPane().add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++; tmp++;
			current++;
			set();	
			if(flag==false)
				b2.setText("Submit");
			setVisible(false);
			setVisible(true);
		}
		//tmp=x;
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			now=current;
			//current=m[y];
			current=m[y];
			tmp--;
			set();
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		//b1.setVisible(true);
			((JButton)e.getSource()).setEnabled(false);
			b1.setText("Reviewed");
			//current=now;
		}
		}
	
		if(e.getActionCommand().equals("Submit"))
		{
//			if(check(current))
//				count=count+1;
//			current++;
			//System.out.println("correct ans="+count);
			//JOptionPane.showMessageDialog(this,"correct ans="+count);
			String sq = "update Result set Mark='"+Integer.toString(count)+"' where ID='"+id1+"'";
			 
			
			try {
				PreparedStatement statement;
				statement = conect.prepareStatement(sq);
				statement.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.exit(0);
		}
		if(e.getActionCommand().equals("Reviewed"))
		{
			if(check(current))
				count=count+1;
			current=now;
			b1.setText("Next");
			set();
		}
	}
	String ques,op1,op2,op3,op4,ans;
	//private JLabel timer;
	void set()
	{
		jb[4].setSelected(true);
		//no_ques--;
		String query="select * from Ques_paper where rowid=?";
		try{
		PreparedStatement pst=conect.prepareStatement(query);
		pst.setString(1,Integer.toString(current));
		
		ResultSet rs=pst.executeQuery();
		//boolean flag=false;
		//JOptionPane.showMessageDialog(this," "+is_ckd+" "+no_ques);
		if((no_ques-1)<=is_ckd){
			//no_ques--;
			flag=last_element();
			b1.setEnabled(false);
			b2.setText("Submit");
		}
		while(rs.next()){
			//flag=true;
				if(no_ques>current){
			l.setText(rs.getString("ques"));
			jb[0].setText(rs.getString("option1"));jb[1].setText(rs.getString("option2"));jb[2].setText(rs.getString("option3"));jb[3].setText(rs.getString("option4"));
				}			
			}
			
		}catch(Exception e){}
		
		
		/*if(current==0)
		{
			l.setText("Que1: Which one among these is not a datatype");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");	
		}
		if(current==1)
		{
			l.setText("Que2: Which class is available to all the class automatically");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our class without importing it");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Which institute is best for java coaching");
			jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: which function is not present in Applet class");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}*/
		l.setBounds(30,40,530,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check(int cur)
	{
		//no_ques--;
		is_ckd++;
		String query="select * from Ques_paper where rowid=?";
		try{
		PreparedStatement pst=conect.prepareStatement(query);
		pst.setString(1,Integer.toString(cur));
		
		ResultSet rs=pst.executeQuery();
		//boolean flag=false;
		if(jb[0].isSelected()){str=rs.getString("option1");}
		else if(jb[1].isSelected()){str=rs.getString("option2");}
		else if(jb[2].isSelected()){str=rs.getString("option3");}
		else if(jb[3].isSelected()){str=rs.getString("option4");}
		while(rs.next()){
			//flag=true;
			if((rs.getString("ans")).equals(str)){
				return true;
			}
			
			}
		}catch(Exception e){}
		/*if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());*/
		//JOptionPane.showMessageDialog(this," kk"+" "+is_ckd);
		return false;
	}
	boolean last_element(){
		return false;
	}
	private void Game()
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 550, 500);
		//timer.setForeground(Color.GREEN);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        String sq = "select * from Ques_paper";
			 
		try {
			PreparedStatement statement;
			statement = conect.prepareStatement(sq);
			rs=statement.executeQuery();
			while (rs.next()) {
				    no_ques++;
				 }
			//System.out.println(no_ques);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        	final Timer t = new Timer(1000, new ActionListener() {
            int time = 60;
           // @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(time<30){
                	timer.setForeground(Color.RED);
                }
                if(b2.getText()=="Submit" && b2.getModel().isPressed()) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(b2.getText()=="Submit" && b2.getModel().isPressed()) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up Click Ok To Submit","bye..",JOptionPane.ERROR_MESSAGE);
                    
                    String sq = "update Result set Mark='"+Integer.toString(count)+"' where ID='"+id1+"'";
       			 
        			try {
        				PreparedStatement statement;
        				statement = conect.prepareStatement(sq);
        				statement.executeUpdate();
        			} catch (SQLException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                    //System.out.println(score);
        			//new Results().setVisible(true);
        			dispose();
                	}
                }
            }
            }
            
        });
        t.start();
       
        
	pack();
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }	

}
