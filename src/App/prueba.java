/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author esteb
 */
public class prueba {
    public static void main(String[] args) {
        Dependencia d1 = new Dependencia("xxxxxxx");
        Interesado i1 = new Interesado();
        Expediente e1 = new Expediente(d1);
        System.out.println(e1.getHoraInicio());
        System.out.println(e1.getFechaInicio());
        System.out.println("oaidwefh");
        System.out.println("sape");
    }
}
