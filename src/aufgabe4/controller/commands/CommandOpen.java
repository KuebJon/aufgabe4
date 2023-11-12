/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aufgabe4.controller.commands;

import aufgabe4.model.AdressverwaltungModel;
import aufgabe4.view.Window;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jnas1
 */
public class CommandOpen implements CommandInterface
{
    private Window view;
    private AdressverwaltungModel model;
    private static File lastDirectory = null;
    
    public CommandOpen(Window view, AdressverwaltungModel model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void execute()
    {
        JFileChooser fc = view.getjFileChooser();
        
        if(lastDirectory != null)
        {
            fc.setCurrentDirectory(lastDirectory);
        }
        
        int choice = fc.showOpenDialog(view);
        if (choice == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fc.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();
            view.getjLblFile().setText(filename);
            try
            {
                model.datenLesen(selectedFile);
                lastDirectory = selectedFile.getParentFile();
            } catch (IOException ex)
            {
                JOptionPane.showMessageDialog(view, ex.toString());
            } catch (ClassNotFoundException ex)
            {
                JOptionPane.showMessageDialog(view, ex.toString());
            }
        }
    }

    @Override
    public void undo()
    {
    }

    @Override
    public void redo()
    {
    }
    
}
