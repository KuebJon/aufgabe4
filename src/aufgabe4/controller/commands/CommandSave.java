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
public class CommandSave implements CommandInterface
{
    private Window view;
    private AdressverwaltungModel model;
    
    public CommandSave(Window view, AdressverwaltungModel model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void execute()
    {
        JFileChooser fc = view.getjFileChooser();
        int choice = fc.showSaveDialog(view);
        if (choice == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fc.getSelectedFile();
            try
            {
                model.datenSpeichern(selectedFile);
            } catch (IOException ex)
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
