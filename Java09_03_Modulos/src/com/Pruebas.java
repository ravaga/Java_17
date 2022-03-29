package com;

import java.net.Socket;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.swing.JOptionPane;

import com.curso.Util;

public class Pruebas {

	public static void main(String[] args) {

		//java.activation
		//java.base
		//java.compiler
		//java.corba
		//java.datatransfer
		//java.desktop
		//java.instrument
		//java.jnlp
		//java.logging
		//java.management
		//java.management.rmi
		//java.naming
		//java.prefs
		//java.rmi
		//java.scripting
		//java.se
		//java.se.ee
		//java.security.jgss
		//java.security.sasl
		//java.smartcardio
		//java.sql
		//java.sql.rowset
		//java.transaction
		//java.xml
		//java.xml.bind
		//java.xml.crypto
		//java.xml.ws
		//java.xml.ws.annotation
		//javafx.base
		//javafx.controls
		//javafx.fxml
		//javafx.graphics
		//javafx.media
		//javafx.swing
		//javafx.web

		// Contenidas en el módulo java.base
		String txt;
		Socket sk;
		ArrayList<Object> lista;
		Integer i;

		// requires java.sql
		DriverManager d;

		// requires java.desktop
		JOptionPane jop;

		// requires java.naming;
		InitialContext iCtx;
		
		Saludador s = new Saludador();
		System.out.println(s.saludar("Luis Ramón"));
		
		Util u = new Util();
		u.metodo();

	}

}
