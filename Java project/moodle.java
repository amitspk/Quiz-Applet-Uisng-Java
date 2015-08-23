import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
/*<applet code = "moodle" width = 600 height = 400  align="MIDDLE"> </applet> */
 
public class moodle extends Applet implements ActionListener,WindowListener,ItemListener,Runnable
{
sampleframe f1;
//nn IS NO. OF QUESTIONS
int n=0,nn=0;
int i=0,k=0,k1=0,k2=0;int i1,i2,mark=0,m=0,q=0,x1,x2,x3,len,rem,x4,q1=0;
boolean[][] bool=new boolean[100][4];
Button b1,prev,next,sa,sb,sc;
sampleframe1 f2; 
String a,b;
Label lt;
String[] msg1=new String[100];
TextField time=new TextField();
int[][] y= new int[100][4];
 int[] x= new int[100];
 char cc;
String[] option = {"A. ","B. ","C. ","D. "};
char[] c1 = {'A','B','C','D'};
String[] que=new String[100];
String[][] op=new String[100][4];
String[] ans=new String[100];
int[] k3=new int[100];
int j;
String s="";
Label l;
//GIVE TIME(minutes and seconds) HERE
int min=10,sec=15;

Thread tt=null;

Label t;
CheckboxGroup[] cg=new CheckboxGroup[100];
Checkbox[][] op1=new Checkbox[100][4];

public void run()
{
while(min>=0&&sec>=0)
{
try{
if(sec==0)
{min=min-1;
sec=59;
}

else
{sec=sec-1;
}
Font myFont = new Font("Segoe UI", Font.BOLD,24);
if(sec>=0&&sec<=9)
{time.setFont(myFont);
time.setText(min+":0"+sec);
}
else
{time.setText(min+":"+sec);
time.setFont(myFont);
}
if(min==0&&sec==0)
{
f2.setLayout(null);
f2.setSize(800,500);
f1.setVisible(false);
f2.setVisible(true);

for(i=0;i<q+1;i++)
{
for(j=0;j<4;j++)
{if(op1[x[i]][j].getState())

{if(((op1[x[i]][j].getLabel()).substring(3)).equals(ans[x[i]]))
mark++;

}

}
}
f2.msg=(String.valueOf(mark));
f2.repaint();
tt.stop();
//mark=0;
}

Thread.sleep(1000);
}
catch(InterruptedException e)
{
}
}
}

public void init()
{
tt=new Thread(this);
for(i=0;i<nn;i++)
k3[i]=20;

f1=new sampleframe("Solve the Question Paper");
f2=new sampleframe1("Quiz Final Marks");



sa=new Button("SET A");
add(sa);

sb=new Button("SET B");
add(sb);

sc=new Button("SET C");
add(sc);
setLayout(null);
Font myFont = new Font("Segoe UI", Font.BOLD,12);
sa.setFont(myFont);
sb.setFont(myFont);
sc.setFont(myFont);
sa.setBounds(240,80,125,30);
sb.setBounds(240,140,125,30);
sc.setBounds(240,200,125,30);
sa.addActionListener(this);
sb.addActionListener(this);
sc.addActionListener(this);
f2.addWindowListener(this);
f1.addWindowListener(this);
}

public void start()
{
f1.setVisible(false);
f2.setVisible(false);
}
public void stop()
{
f1.setVisible(false);
f2.setVisible(false);
}
 public void windowClosed(WindowEvent we)
  {
    f2.setVisible(false); 
	f1.setVisible(false);
   }
   public void windowClosing(WindowEvent we)
  {
     f2.setVisible(false);
	f1.setVisible(false); 
   }
 public void windowActivated(WindowEvent we)
  {
   }
 public void windowDeactivated(WindowEvent we)
  {
   }
 public void windowIconified(WindowEvent we)
  {
   }
 public void windowDeiconified(WindowEvent we)
  {
   }
 public void windowOpened(WindowEvent we)
  {
   }
public void itemStateChanged(ItemEvent e)
{for(j=0;j<4;j++)
{if(op1[x[q]][j].getState())
{
bool[x[q]][j]=true;
for(i=0;i<4;i++)
{if(i!=j)
bool[x[q]][i]=false;
}
}
}
}
//ACTION PERFORMED FOR SETS
public void actionPerformed(ActionEvent ae)
{
//BUTTON FOR SUBMITTING
//ACTION PERFORMED FOR SUBMIT BUTTON
if(ae.getSource()==b1)
{tt.stop();
f2.setLayout(null);
f2.setSize(800,500);
f1.setVisible(false);
f2.setVisible(true);



for(i=0;i<q1+1;i++)
{
for(j=0;j<4;j++)
{if(op1[x[i]][j].getState())

{if(((op1[x[i]][j].getLabel()).substring(3)).equals(ans[x[i]]))
mark++;

}

}
}
f2.msg=(String.valueOf(mark));
f2.repaint();
//mark=0;
}




else if(ae.getSource()==sa||ae.getSource()==sb||ae.getSource()==sc)
{//Font myFont = ;
lt=new Label("TIME LEFT:");
lt.setFont(new Font("Segoe UI", Font.BOLD,20));
lt.setBounds(1070,55,120,40);
f1.add(lt);
time.setBounds(1090,100,65,40);
f1.add(time);
//setEditable(false);
time.setEditable(false);
tt.start();



b1=new Button("SUBMIT");
prev=new Button("Previous");
next=new Button("Next");
f1.setLayout(null);

f1.setSize(1400,730);
f1.setVisible(true);
b1.setBounds(650,600,80,30);
f1.add(b1);
//FOR SUBMIT BUTTON
b1.addActionListener(this);
//FOR PREVIOUS BUTTON
prev.setBounds(325,600,80,30);
f1.add(prev);
prev.addActionListener(this);
//FOR NEXT BUTTON
next.setBounds(975,600,80,30);
f1.add(next);
next.addActionListener(this);

//READING OF FILE
try{
FileReader fr=new FileReader("read11.txt");

BufferedReader br=new BufferedReader(fr);
while(true)
{
try{
que[i]=br.readLine();
if(que[i]==null)
break;
nn++;}
catch(IOException e)
{}
for(j=0;j<4;j++)
{try{
op[i][j]=br.readLine();
}
catch(IOException e)
{}

}
cc=(br.readLine()).charAt(8);
for(j=0;j<4;j++)
{if((op[i][j].charAt(0))==cc)
ans[i]=op[i][j].substring(3);
}i++;}
}
catch(IOException e)
{
}
/*for(i=0;i<nn;i++)
for(j=0;j<4;j++)
bool[i][j]=true;
*/
//10 RANDOM NUMBERS
int k=0;


int flag=0;
for(i=0;i<nn;i++)
x[i]=-1;
while(true)
{

int r = (int)(0+Math.random()*(nn-1-0+1));

for(i=0;i<nn;i++)
{
if(x[i]==r)
{
flag=1;
break;
}}
if(flag==0)
{
x[k]=r;

k++;
}

flag=0;
if(k==nn)
break;
}

//generating random nos. for options
k=0;
flag=0;

for(i1=0;i1<nn;i1++)
for(i2=0;i2<4;i2++)
y[i1][i2]=12;
for(i1=0;i1<nn;i1++)
{k2=0;
while(true)
{

int r1 = (int)(0+Math.random()*(3-0+1));

for(i2=0;i2<4;i2++)
{
if(y[i1][i2]==r1)
{
flag=1;
break;
}}
if(flag==0)
{
y[i1][k2]=r1;

k2++;
}

flag=0;
if(k2==4)
break;
}
}


//PRINTING OF FIRST QUESTION
f1.repaint();
//PRINTING OPTIONS FOR FIRST QUESTION
k=0;
cg[q]=new CheckboxGroup();

for(j=0;j<4;j++)
{
op1[x[q]][j]=new Checkbox((option[j]+(op[x[q]][y[x[q]][j]].substring(3))),cg[q],false);
op1[x[q]][j].setBounds(200,275+k,500,20);


Font myFont = new Font("Segoe UI", Font.PLAIN,13);
op1[x[q]][j].setFont(myFont);
f1.add(op1[x[q]][j]);
k=k+30;
op1[x[q]][j].addItemListener(this);}







}
//NEXT BUTTON
else if(ae.getSource()==next)
{if(q<nn-1)
{q=q+1;
q1=q;
if(q<nn)
{for(j=0;j<4;j++)
f1.remove(op1[x[q-1]][j]);
f1.repaint();
k=0;
cg[q]=new CheckboxGroup();

for(j=0;j<4;j++)
{
op1[x[q]][j]=new Checkbox((option[j]+(op[x[q]][y[x[q]][j]].substring(3))),cg[q],bool[x[q]][j]);
op1[x[q]][j].setBounds(200,275+k,500,20);


Font myFont = new Font("Segoe UI", Font.PLAIN,13);
op1[x[q]][j].setFont(myFont);
f1.add(op1[x[q]][j]);
k=k+30;

op1[x[q]][j].addItemListener(this);
}
}


}
else
q=nn-1;

}

else if(ae.getSource()==prev)
{if(q!=0)
{q=q-1;
if(q>=0)
{for(j=0;j<4;j++)
f1.remove(op1[x[q+1]][j]);
f1.repaint();
k=0;
cg[q]=new CheckboxGroup();

for(j=0;j<4;j++)
{
op1[x[q]][j]=new Checkbox((option[j]+(op[x[q]][y[x[q]][j]].substring(3))),cg[q],bool[x[q]][j]);
op1[x[q]][j].setBounds(200,275+k,500,20);


Font myFont = new Font("Segoe UI", Font.PLAIN,13);
op1[x[q]][j].setFont(myFont);
f1.add(op1[x[q]][j]);
k=k+30;
op1[x[q]][j].addItemListener(this);
}
}

//if(k3[x[q]]!=20)
//op1[x[q]][k3[x[q]]].setState(true);


}
else
q=0;
} 



}
//PAINT METHOD OF APPLET WINDOW
public void paint(Graphics g){
showStatus("Please choose the SET to continue");


}
//SAMPLE FRAME CLASS
class sampleframe extends Frame
{
sampleframe(String title)
{
super(title);
}

public void paint(Graphics g)
 {g.setFont(new Font("Segoe UI", Font.BOLD, 20)); 
 g.drawRoundRect(180,150,1030,100,40,40);
 g.drawRoundRect(180,260,1030,150,40,40);
 len=que[x[q]].length();
 x1=len/94;
 rem=len%94;
 x2=0;
 x3=0;
 x4=0;
 if(len<=94)
 g.drawString((q+1)+". "+que[x[q]].substring(2),200,180);
 
 else 
 {if(rem==0)
 { for(i=0;i<x1;i++)
 { if(i==0)
 g.drawString((q+1)+". "+que[x[q]].substring(2+x4,95+x2),200,180+x3);
 else
 g.drawString(que[x[q]].substring(2+x4,95+x2),200,180+x3);
 x2=x2+95;
  x4=x4+93;
 x3=x3+30;
 }
 }
 else
 { for(i=0;i<x1;i++)
 {if(i==0)
 g.drawString((q+1)+". "+que[x[q]].substring(2+x4,95+x2),200,180+x3);
 else
 g.drawString(que[x[q]].substring(2+x4,95+x2),200,180+x3);
 x2=x2+95;
  x4=x4+93;
  x3=x3+30;
 }
 g.drawString(que[x[q]].substring(x2),200,180+x3);

 }
}}

 

 
 }


//SAMPLEFRAME2 CLASS
 class sampleframe1 extends Frame implements Runnable
{
Thread t=null;
String con="CONGRATULATIONS !! ";

String msg="";
sampleframe1(String title)
{
super(title);
}
public void run()
{
while(true)
{
try{
f2.repaint();
Thread.sleep(250);
}
catch(InterruptedException e)
{
}
}
}

public void paint(Graphics gg)
{k=0;
 
if(n==0)
{
t=new Thread(this);
t.start();

n=1;}
else
 {gg.setColor(Color.orange);
 gg.setFont(new Font("Segoe UI", Font.BOLD, 30)); 
char c=con.charAt(0);
con=con.substring(1,con.length())+c;
gg.drawString(con,230,140);
gg.setFont(new Font("Segoe UI", Font.BOLD, 20));
gg.setColor(Color.black);
gg.drawString("You have Successfully Completed the Test!!",190,220);
gg.setColor(Color.green);
gg.drawString("Your final marks = "+msg,280,245);
}
/*for(i=0;i<q+1;i++)
{gg.drawString(msg1[i],30,50+k);
k=k+20;
}*/
}
}}



 