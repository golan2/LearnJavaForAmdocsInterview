
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Frame1 extends JFrame
{
    JPanel contentPane;
    MenuBar myMenuBar = new MenuBar();
    Menu mnuFile = new Menu();
    MenuItem mnuFileSayHello = new MenuItem();
    MenuItem mnuFileExit = new MenuItem();
    Label label1 = new Label();
    Label label4 = new Label();
    GridLayout gridLayout1 = new GridLayout(3,3);
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();
    Panel panel4 = new Panel();
    Panel panel5 = new Panel();
    Panel panel6 = new Panel();
    Panel panel7 = new Panel();
    Button btnWhereAreYou = new Button();
    Panel panel8 = new Panel();
    Label lblAnybodyHome = new Label();
    Panel panel9 = new Panel();
    BorderLayout borderLayout1 = new BorderLayout();

    /**Construct the frame*/
    public Frame1()
	{
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try
		{
            jbInit();
        }
        catch(Exception e)
		{
            e.printStackTrace();
        }
    }



    /**Component initialization*/
    private void jbInit() throws Exception
	{
        //setIconImage(Toolkit.getDefaultToolkit().createImage(Frame1.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(gridLayout1);
        this.setSize(new Dimension(400, 300));
        this.setTitle("Frame Title");
        mnuFile.setLabel("File");
        mnuFile.setActionCommand("File");
        mnuFileSayHello.setLabel("Say Hello");
        mnuFileExit.setLabel("Exit");
        mnuFileExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mnuFileExit_actionPerformed(e);
            }
        });
        label1.setText("label1");
        label4.setText("label4");
        btnWhereAreYou.setLabel("Where are you?");
        btnWhereAreYou.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnWhereAreYou_actionPerformed(e);
            }
        });
        panel1.setBackground(Color.pink);
        panel1.setLayout(borderLayout1);
        panel5.setBackground(Color.pink);
        panel2.setBackground(Color.pink);
        panel3.setBackground(Color.pink);
        panel4.setBackground(Color.pink);
        panel6.setBackground(Color.pink);
        panel7.setBackground(Color.pink);
        panel8.setBackground(Color.pink);
        lblAnybodyHome.setText("Anybody\'s home?");
        panel9.setBackground(Color.pink);
        contentPane.add(panel1, null);
        contentPane.add(panel9, null);
        panel9.add(lblAnybodyHome, null);
        contentPane.add(panel5, null);
        contentPane.add(panel2, null);
        contentPane.add(panel3, null);
        panel3.add(btnWhereAreYou, null);
        contentPane.add(panel4, null);
        contentPane.add(panel6, null);
        contentPane.add(panel7, null);
        contentPane.add(panel8, null);
        myMenuBar.add(mnuFile);
        mnuFile.add(mnuFileSayHello);
        mnuFile.add(mnuFileExit);
    }


    /**Overridden so we can exit when window is closed*/
    protected void processWindowEvent(WindowEvent e)
	{
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
            System.exit(0);
        }
    }

    void mnuFileSayHello_actionPerformed(ActionEvent e)
	{
		lblAnybodyHome.setText("Hello I'm here.");
    }

    void mnuFileExit_actionPerformed(ActionEvent e)
    {
		System.exit(0);
    }

    void btnWhereAreYou_actionPerformed(ActionEvent e)
    {
		lblAnybodyHome.setText("Hello I'm here.");
    }
}