package com.objis.BaseDeDonneeJdbc;

import java.sql.*;
public class BaseDeDonneeJdbc 
{
	public static void main (String[] args)
	{
		try{
			//Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			//Info de connexion � la base de donn�e
			String url = "jdbc:mysql://localhost:3306/inscriptionsportive";
			String login = "root";
			String mdp = "";
			//Connexion � la base de donn�e
			Connection myConn = DriverManager.getConnection(url, login , mdp);
			//CREATON DU STATEMENT
			Statement stmt = myConn.createStatement();
			//srcipt sql recuperation resultat
			ResultSet resultat = stmt.executeQuery("SELECT * FROM personne, candidat");
				while (resultat.next())
				{
					System.out.println(resultat.getString("prenom_personne") + ", " + resultat.getString("mail") + ", " + resultat.getString("nom_candidat"));
				}
			}
		catch (Exception exc){
			exc.printStackTrace();
			System.out.println("Erreur de connexion � la base de donn�e");
		}
	}
}