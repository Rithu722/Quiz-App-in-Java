/*MOCK TEST */
//java -Djava.awt.headless=true;
import java.awt.HeadlessException.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MockTest extends JFrame implements ActionListener
{                                                                                                     
    JLabel l;                                                                                        
	JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	MockTest(String s)
	{
	   super(s);
	   l=new JLabel();
   	   add(l);
       bg=new ButtonGroup();
       for(int i=0;i<5;i++)
       {
           jb[i]=new JRadioButton();
		   add(jb[i]);
		   bg.add(jb[i]);
	   }
			   
       b1=new JButton("Next");
       b2=new JButton("Flag");
  	   b1.addActionListener(this);
       b2.addActionListener(this);
 	   add(b1);
	   add(b2);
	   set();
	   l.setBounds(30,40,450,20);                                                                                                                                                           jb[0].setBounds(50,80,100,20);
	   jb[1].setBounds(50,110,100,20);
	   jb[2].setBounds(50,140,100,20);
	   jb[3].setBounds(50,170,100,20);
	   b1.setBounds(100,240,100,30);
	   b2.setBounds(270,240,100,30);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLayout(null);
	   setLocation(250,100);
	   setVisible(true);
	   setSize(600,350);
	   }
	   public void actionPerformed(ActionEvent e)
	   {
		   if(e.getSource()==b1)
			   {
				   if(check())
					   count=count+1;
				   current++;
				   set();
				   if(current==9)
					   {
						   b1.setEnabled(false);
						   b2.setText("Summary");
                       }                                                                                        }                                                                                                if(e.getActionCommand().equals("Flag"))
			   {
				JButton bk=new JButton("Flag"+x);
	
	bk.setBounds(480,20+30*x,100,30);
	add(bk);
	bk.addActionListener(this);
	m[x]=current;
	x++;
	current++;
	set();
	if(current==9)
		b2.setText("Summary");
	setVisible(false);
	setVisible(true);
	}
	for(int i=0,y=1;i<x;i++,y++)
		{
			if(e.getActionCommand().equals("Flag"+y))
				{
					if(check())
						count=count+1;
					now=current;						
					current=m[y];
				    set();												   
					((JButton)e.getSource()).setEnabled(false);
					current=now;
				}
		}
								
        if(e.getActionCommand().equals("Summary"))
	    {	  
			 if(check())
				count=count+1;
			 current++;
			 System.out.println("Score = "+count);	
             JOptionPane.showMessageDialog(this,"Score = "+count);
			 System.exit(0);
	    }
			  
        void set()
        {
			 jb[4].setSelected(true);
			 if(current==0)
			 {
			   l.setText("1. If January 1, 1996, was Monday, what day of the week was January 1, 1997?");
               jb[0].setText("Friday");jb[1].setText("Wednesday");jb[2].setText("Saturday");jb[3].setText("Sunday");//Wed
		     }
			 if(current==1)
			 {
			   l.setText("2. The speed of a boat in still water is 5km/hr. If the speed of the boat against the stream is 3 km/hr, what is the speed of the stream?");
			   jb[0].setText("1.22 km/hr");jb[1].setText("2.5 km/hr");jb[2].setText("2 km/hr");jb[3].setText("5 km/hr");
			 }
		
             if(current==2)
	     	 {
				l.setText("3. A pipe can fill a tank in 6 hours and another pipe can empty the tank in 12 hours. If both the pipes are opened at the same time,the tank can be filled in");									
				jb[0].setText("14 hours");jb[1].setText("15 hours");jb[2].setText("10 hours");jb[3].setText("12 hours");
			 }
			if(current==3)
			{
				l.setText("4. Ramesh bought a chair for Rs. 1540 and sold it to Suresh. If Ramesh earned a profit of 25%, find the selling price of chair.");
				jb[0].setText("Rs. 8765");jb[1].setText("Rs. 1925");jb[2].setText("Rs. 1767");jb[3].setText("Rs. 1960");
			}                                                                                                
			if(current==4)
			{
				l.setText("5. If in a certain language, NOIDA is coded as OPJEB, how is DELHI coded in that language?");
				jb[0].setText("EFMIH");jb[1].setText("UYDA");jb[2].setText("EFMIJ");jb[3].setText("EFII");
			}
			if(current==5)                                                                                  
			{
				l.setText("6. Peter is in the East of Tom and Tom is in the North of John. Mike is in the South of John then in which direction of Peter is Mike? ");
				jb[0].setText("South-West");jb[1].setText("North- East");jb[2].setText("South");jb[3].setText("South-East");
			}
			if(current==6)                                                                                   
			{                                                                                                        l.setText("7. RQP, ONM, _, IHG, FED, find the missing letters. ");
				jb[0].setText("JHG");jb[1].setText("YUR");jb[2].setText("LKP");                                 
				jb[3].setText("LKJ");
			}
														
			l.setBounds(30,40,450,20);
            for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);                                                 
		}
			boolean check()                                                                                  
			{
				if(current==0)
					return(jb[1].isSelected());
				if(current==1)
					return(jb[2].isSelected());                                                              
				if(current==2)
					return(jb[3].isSelected());                                                             
				if(current==3)
					return(jb[1].isSelected());
				if(current==4)
					return(jb[2].isSelected());
				if(current==5)                                                                                           
					return(jb[0].isSelected());
				if(current==6)                                                                                           return(jb[3].isSelected());
				    return false;           
			}
        public static void main(String s[]) throws HeadlessException
		{
         	new MockTest("Mock Test");
        }
}