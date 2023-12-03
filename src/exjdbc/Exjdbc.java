/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exjdbc;

/**
 *
 * @author 21655
 */
public class Exjdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //Etudiant e = new Etudiant(8, "Dalanda", "Dridi", 43, "3BI");
      Test t = new Test();
      t.connexionDB();
      //t.AjouterEtudiant(e);
     // t.AfficherEtudiants();
     //   System.out.println(t.SupprimerEtudiant(5));
     t.ModifierEtudiant("Makrem", 6);
      t.AfficherEtudiants("3EBUS");
    }
    
}
