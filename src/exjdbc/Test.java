/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 21655
 */
public class Test {

    public final static String url = "jdbc:mysql://localhost:3306/etudiants";
    public final static String user = "root";
    public final static String mdp = "manager";
    public Connection c = null;

    public void connexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, mdp);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not loading");
        } catch (SQLException x) {
            System.out.println(x.getMessage() + " SQL EXCEPTION");
        }
    }

    public void DeconnexionDB() {
        try {
            c.close();
        } catch (Exception x) {
            System.out.println("Probleme dans la connexion");
        }
    }

    public void AjouterEtudiant(Etudiant e) {

        try {
            //  String sql = "INSERT INTO `etudiant` (`id',`nom`,`prenom`,`age`,`filiere`)"+"VALUES (?,?,?,?,?)";
            String sql = "INSERT INTO etudiant values (?,?,?,?,?)";

            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, e.getNumEtud());
            pstm.setString(2, e.getNomEtud());
            pstm.setString(3, e.getPrenomEtud());
            pstm.setInt(4, e.getAge());
            pstm.setString(5, e.getFiliere());

            pstm.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println("Probleme d'insertion ou d'ajout etudiant");
        }
    }

    public void ModifierEtudiant(String nom, int id) {
        String sql = "UPDATE etudiant SET nomEtud = ? WHERE numEtud= ?";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, nom);
            pstm.setInt(2, id);
            int lu = pstm.executeUpdate();
            if (lu >= 1) {
                System.out.println("Bien Modifier");
            } else {
                System.out.println("n existe pas");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public boolean SupprimerEtudiant(int id) {
        String sql = "DELETE FROM etudiant WHERE numEtud= ?";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            int lu = pstm.executeUpdate();
            if (lu >= 1) {
                return true;
            } else {
                System.out.println("n existe pas");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public void AfficherEtudiants() {
        String sql = "SELECT * FROM  etudiant ";
        Statement stm;
        try {
            stm = c.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getInt(4) + " " + res.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AfficherEtudiants(String fil) {
        String sql = "SELECT * FROM  etudiant where filiere= ?";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, fil);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getInt(4) + " " + res.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
