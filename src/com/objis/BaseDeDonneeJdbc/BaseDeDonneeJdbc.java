package com.objis.BaseDeDonneeJdbc;

import java.sql.*;
public class BaseDeDonneeJdbc 
{
	public static void main (String[] args)
	{
		try{
			//Connexion à la base de donnée
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscriptionSportive", "root" , "");
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
		}
	}
}