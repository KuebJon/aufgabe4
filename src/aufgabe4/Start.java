/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aufgabe4;
import aufgabe4.controller.CommandController;
import aufgabe4.view.Window;
import aufgabe4.model.AdressverwaltungModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author jnas1
 */
public class Start
{
    public Start()
    {
        Window view = new Window();
        AdressverwaltungModel model = new AdressverwaltungModel();
        CommandController controller = new CommandController(view, model);
        controller.registerCommands();
        controller.registerEvents();
        view.getjTable().setModel(model);
        view.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex)
        {
          JOptionPane.showMessageDialog(null, ex.toString());
        }
        new Start();
    }
    
}
