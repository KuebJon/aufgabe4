/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aufgabe4.controller.commands;

import aufgabe4.model.AdressverwaltungModel;
import aufgabe4.view.Window;

/**
 *
 * @author jnas1
 */
public class CommandUndo implements CommandInterface
{
    private Window view;
    private AdressverwaltungModel model;
    private CommandInvoker invoker;
    
    public CommandUndo(Window view, AdressverwaltungModel model, CommandInvoker invoker)
    {
        this.view = view;
        this.model = model;
        this.invoker = invoker;
    }

    @Override
    public void execute()
    {
        invoker.undoCommand();
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
