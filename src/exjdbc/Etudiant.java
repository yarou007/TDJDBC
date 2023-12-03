/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exjdbc;

/**
 *
 * @author 21655
 */
public class Etudiant {
    private int numEtud;
    private String nomEtud;
    private String prenomEtud;
    private int Age;
    private String Filiere;

    public Etudiant(int numEtud, String nomEtud, String prenomEtud, int Age, String Filiere) {
        this.numEtud = numEtud;
        this.nomEtud = nomEtud;
        this.prenomEtud = prenomEtud;
        this.Age = Age;
        this.Filiere = Filiere;
    }

    public Etudiant() {
    }

    
    public int getNumEtud() {
        return numEtud;
    }

    public void setNumEtud(int numEtud) {
        this.numEtud = numEtud;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    public String getPrenomEtud() {
        return prenomEtud;
    }

    public void setPrenomEtud(String prenomEtud) {
        this.prenomEtud = prenomEtud;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getFiliere() {
        return Filiere;
    }

    public void setFiliere(String Filiere) {
        this.Filiere = Filiere;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "numEtud=" + numEtud + ", nomEtud=" + nomEtud + ", prenomEtud=" + prenomEtud + ", Age=" + Age + ", Filiere=" + Filiere + '}';
    }
    
}
