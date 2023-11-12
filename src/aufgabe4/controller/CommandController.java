/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aufgabe4.controller;

import aufgabe4.controller.commands.CommandAdd;
import aufgabe4.controller.commands.CommandInvoker;
import aufgabe4.controller.commands.CommandOpen;
import aufgabe4.controller.commands.CommandRemove;
import aufgabe4.controller.commands.CommandSave;
import aufgabe4.controller.commands.CommandUndo;
import aufgabe4.model.AdressverwaltungModel;
import aufgabe4.view.Window;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jnas1
 */
public class CommandController implements ActionListener
{
    private Window view;
    private AdressverwaltungModel model;
    private CommandInvoker invoker;
    
    
    public CommandController(Window view, AdressverwaltungModel model)
    {
        this.view = view;
        this.model = model;
        invoker = new CommandInvoker();
    }
    
    public void registerEvents()
    {
        view.getjBtnOpen().addActionListener(this);
        view.getjMenuFileOpen().addActionListener(this);
        view.getjMenuPopupOpen().addActionListener(this);
        view.getjPopupOpen().addActionListener(this);
        
        view.getjBtnSave().addActionListener(this);
        view.getjMenuFileSave().addActionListener(this);
        view.getjPopupSave().addActionListener(this);
        
        view.getjBtnAdd().addActionListener(this);
        view.getjMenuEditAdd().addActionListener(this);
        view.getjPopupAdd().addActionListener(this);
        
        view.getjBtnRemove().addActionListener(this);
        view.getjMenuEditRemove().addActionListener(this);
        view.getjPopupRemove().addActionListener(this);
        
        view.getjBtnUndo().addActionListener(this);
        view.getjMenuEditUndo().addActionListener(this);
        view.getjPopupUndo().addActionListener(this);
    }
    
    public void registerCommands()
    {
        CommandOpen cmdOpen = new CommandOpen(view, model);
        
        invoker.addCommand(view.getjBtnOpen(), cmdOpen);
        invoker.addCommand(view.getjMenuFileOpen(), cmdOpen);
        invoker.addCommand(view.getjMenuPopupOpen(), cmdOpen);
        invoker.addCommand(view.getjPopupOpen(), cmdOpen);
        
        CommandSave cmdSave = new CommandSave(view, model);
        
        invoker.addCommand(view.getjBtnSave(), cmdSave);
        invoker.addCommand(view.getjMenuFileSave(), cmdSave);
        invoker.addCommand(view.getjPopupOpen(), cmdSave);
        invoker.addCommand(view.getjPopupOpen(), cmdSave);
        
        CommandAdd cmdAdd = new CommandAdd(view, model);
        
        invoker.addCommand(view.getjBtnAdd(), cmdAdd);
        invoker.addCommand(view.getjMenuEditAdd(), cmdAdd);
        invoker.addCommand(view.getjPopupAdd(), cmdAdd);
        
        CommandRemove cmdRemove = new CommandRemove(view, model);
        
        invoker.addCommand(view.getjBtnRemove(), cmdRemove);
        invoker.addCommand(view.getjMenuEditRemove(), cmdRemove);
        invoker.addCommand(view.getjPopupRemove(), cmdRemove);
        
        CommandUndo cmdUndo = new CommandUndo(view, model, invoker);
        
        invoker.addCommand(view.getjBtnUndo(), cmdUndo);
        invoker.addCommand(view.getjMenuEditUndo(), cmdUndo);
        invoker.addCommand(view.getjPopupUndo(), cmdUndo);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Component key = (Component)e.getSource();
        invoker.executeCommand(key);
    }
}
