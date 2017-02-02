package com.objis.BaseDeDonneeJdbc;

import java.sql.*;
public class BaseDeDonneeJdbc 
{
	public static void main (String[] args)
	{
		try{
			//CONNECTION TO DATABASE
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inscriptionSportive", "root" , "");
			//CREATON DU STATEMENT
			Statement myStmt = myConn.createStatement();
			//EXECUTER SQL QUERY
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM personne, candidat");
				while (myRs.next())
				{
						System.out.println(myRs.getString("prenom_personne") + ", " + myRs.getString("mail") + ", " + myRs.getString("nom_candidat"));
				}
			}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}
}