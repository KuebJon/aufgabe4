/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aufgabe4.controller.commands;

import java.awt.Component;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author jnas1
 */
public class CommandInvoker
{
    private HashMap<Component, CommandInterface> commands;
    private Stack<CommandInterface> undoStack;
    
    public CommandInvoker()
    {
        commands = new HashMap<>();
        undoStack = new Stack<>();
    }
    
    public void addCommand(Component key, CommandInterface value)
    {
        commands.put(key, value);
    }
    
    public void executeCommand(Component key)
    {
        CommandInterface command = commands.get(key);
        commands.get(key).execute();
        if(!(command instanceof CommandUndo) && !(command instanceof CommandSave) && !(command instanceof CommandOpen))
        {
            undoStack.push(command);
        }
        else if(command instanceof CommandOpen)
        {
            undoStack.clear();
        }
    }
    
    public void undoCommand()
    {
        if (!undoStack.isEmpty())
        {
            undoStack.pop().undo();
        }
    }
}
