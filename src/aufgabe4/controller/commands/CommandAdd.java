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
public class CommandAdd implements CommandInterface
{
    private Window view;
    private AdressverwaltungModel model;
    
    public CommandAdd(Window view, AdressverwaltungModel model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void execute()
    {
        model.leerenAdressEintragAnhaengen();
    }

    @Override
    public void undo()
    {
        model.deleteRowData(model.getRowCount() - 1);
    }

    @Override
    public void redo()
    {
    }
    
}
