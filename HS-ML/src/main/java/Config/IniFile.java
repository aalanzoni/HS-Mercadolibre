/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Andres Lanzoni
 */
import java.util.*;
import java.io.*;

public class IniFile {
	private String nameFile = "";
	private Properties p = null;


	public IniFile() {
		p = new Properties();
	}

	public IniFile(String nameFile) {
		this.p = new Properties();
		this.nameFile = nameFile;
		this.setNameFile(this.nameFile);
	}

	/** Leer el parametro del archivo seteado */
	public String getParameters(String nombreParametro){
		return p.getProperty(nombreParametro).trim();
	}

	public void setNameFile(String nameFile) {
		try {
			this.nameFile = nameFile;
			p.load(new FileInputStream(this.nameFile));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Set keySet(){
		return p.keySet();
	}

	public void listar(){
		p.list(System.out);
	}
}

