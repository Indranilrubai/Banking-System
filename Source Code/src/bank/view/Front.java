package bank.view;
import javax.swing.*;

import bank.controller.SndPgController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Front extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel lb1,l;
	private JProgressBar pr;
	private Timer tt;
	int i=0;
	public Front(String arg0) throws HeadlessException {
		super(arg0);
		FrBckgrnd con=new FrBckgrnd();
		// TODO Auto-generated constructor stub
		ImageIcon icn1=new ImageIcon("\\image\\8.jpg");
		lb1=new JLabel(icn1,JLabel.RIGHT);
		lb1.setLocation(0, 100);
		lb1.setSize(400,40);
		Container con2=getContentPane();
		con2.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		con.add(lb1,BorderLayout.NORTH);		
	       EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run(){
	                String s = "Welcome To iBanking";
	                MarqueePanel mp = new MarqueePanel(s, 60);
	                con.add(mp,BorderLayout.CENTER);
	                mp.start();
	            }
	        });
		l=new JLabel("Welcome to our Bank",JLabel.CENTER);
		l.setSize(new Dimension(900, 100));
		l.setFont(new Font(null,Font.BOLD, 50));
		pr=new JProgressBar();
		//pr.setSize(900,200);
		pr.setStringPainted(true);
		pr.setPreferredSize(new Dimension(900, 27));
		pr.setValue(0);
		ActionListener ac=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				i++;
				pr.setValue(i);
				if(i==100)
				{
					SecndPage sndpg=new SecndPage("iBanking");
					new SndPgController(sndpg).control();
					dispose();
				}
			}
		};
		tt=new Timer(100, ac);
		tt.start();
		con.add(pr,BorderLayout.SOUTH);
		con2.add(con);
		setResizable(false);
		setSize(640, 411);
		setVisible(true);
	}

}


//Class For Marquee Text
class MarqueePanel extends JPanel implements ActionListener {

    private static final int RATE = 13;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;

    public MarqueePanel(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Comic Sans MS", Font.ITALIC, 46));
        label.setText(sb.toString());
        label.setForeground(Color.RED);
        this.add(label);
        setOpaque(false);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        label.setText(s.substring(index, index + n));
    }
}
class FrBckgrnd extends JPanel
{

	public FrBckgrnd() {
		setOpaque(false);
		setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g)
	{
		Image a=Toolkit.getDefaultToolkit().getImage("image\\bf.jpg");
		g.drawImage(a, 0, 0, getSize().width,getSize().height,this);
		super.paint(g);
	}
}