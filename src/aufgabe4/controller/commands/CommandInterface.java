/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aufgabe4.controller.commands;

/**
 *
 * @author jnas1
 */
public interface CommandInterface
{
    public void execute();
    public void undo();
    public void redo();
}
