/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcjava;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void handleButtonClick() {
        String newData = "Confirmado"; // Aquí puedes agregar lógica para obtener los datos del modelo, realizar operaciones, etc.

        model.setData(newData);
        view.updateData(newData);
    }
}
