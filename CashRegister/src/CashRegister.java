import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Shivani Shinde on 17-03-2017.
 */
public class CashRegister extends JPanel{

    private ICashRegisterDrawer drawer;
    private JButton openB;
    private JButton closeB;
    private JTextField statusD;
    private JPanel panelMain;

    public CashRegister() {
        drawer = (ICashRegisterDrawer) new CashRegisterDrawer();
        updateDrawerStatus();
        openB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawer.Open();
                updateDrawerStatus();
            }
        });
        closeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawer.Close();
                updateDrawerStatus();
            }
        });
    }

    private void updateDrawerStatus(){
        this.statusD.setText(drawer.getStatus().toString());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Application");
        frame.setContentPane(new CashRegister().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
