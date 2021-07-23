import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame implements ActionListener{
	
	//PROPIEDADES
	private JLabel titulo; 																//<-- ETIQUETA TITULO REGISTRO DE ALUMNOS
	private JLabel labelCorreo, labelFecha, labelNombre, labelRegistro;								//<-- ETIQUETAS CORREO, FECHA, NOMBRE
	private JLabel labelVerificacionCorreo; 											//<-- ETIQUETA VERIFICACION DE CORREO
	private JLabel labelVerificacionNombre; 											//<-- ETIQUETA VERIFICACION DEL NOMBRE
	private JLabel labelVerificacionFecha;
	private JTextField entradaTextoCorreo, entradaTextoNombre, entradaTextoNacimiento;	//<-- DEFINE UNA ENTRADA DE TEXTO
	private JButton botonRegistrar;														//<-- DEFINE UN BOTON REGISTRAR
	
	//COMPORTAMIENTOS
	InterfazGrafica(){//<-- CONSTRUCTOR
		setLayout(null);
		
		//CONSTRUCCIÓN DE UNA ETIQUETA TITULO REGISTRO DE ALUMNOS
		titulo = new JLabel("Registro de Alumnos");
		titulo.setBounds(300,40,300,25);
		add(titulo);
				
		//CONSTRUCCIÓN DE LA ETIQUETA DATO CORREO ELECTRONICO
		labelCorreo = new JLabel("Correo Electronico:");
		labelCorreo.setBounds(90,90,200,25);
		add(labelCorreo);
		
		//VERIFICACION DEL CORREO ELECTRONICO
		labelVerificacionCorreo = new JLabel("");
		labelVerificacionCorreo.setBounds(450,90,200,25);
		add(labelVerificacionCorreo);
				
		//CONSTRUCCION DE LA ETIQUETA (DATO NOMBRE COMPLETO)
		labelNombre = new JLabel("Nombre Completo:");
		labelNombre.setBounds(90,140,200,25);
		add(labelNombre);

		labelVerificacionNombre = new JLabel("");
		labelVerificacionNombre.setBounds(450,140,200,25);
		add(labelVerificacionNombre);
		
		//CONSTRUCCION DE LA ETIQUETA (DATO FECHA DE NACIMIENTO)
		labelFecha = new JLabel("Fecha de Nacimiento:");
		labelFecha.setBounds(90,190,200,25);
		add(labelFecha);
	
		labelVerificacionFecha = new JLabel("");
		labelVerificacionFecha.setBounds(450,190,200,25);
		add(labelVerificacionFecha);
		
		//REGISTRO
		labelRegistro = new JLabel("");
		labelRegistro.setBounds(300,270,300,25);
		add(labelRegistro);
		
		/******************************************************
		 * CONSTRUCCION DE LAS ENTRADAS DE TEXTO (JTextField)
		 * ****************************************************/
					
		//CONSTRUCCIÓN DE UNA ENTRADA DE TEXTO (CORREO ELECTRONICO)
		entradaTextoCorreo = new JTextField();
		entradaTextoCorreo.setBounds(230,90,195,25);
		entradaTextoCorreo.setBackground(Color.LIGHT_GRAY);
		TextPrompt placeholder = new TextPrompt("example@gmail.com",entradaTextoCorreo);
        placeholder.changeAlpha(0.75f);
		add(entradaTextoCorreo);
				
		//CONSTRUCCIÓN DE UNA ENTRADA DE TEXTO (NOMBRE COMPLETO)
		entradaTextoNombre = new JTextField();
		entradaTextoNombre.setBounds(230,140,195,25);
		entradaTextoNombre.setBackground(Color.LIGHT_GRAY);
		TextPrompt placeholder2 = new TextPrompt("Nombre Nombre Apellido Apellido",entradaTextoNombre);
        placeholder2.changeAlpha(0.75f);
		add(entradaTextoNombre);
				
		//CONSTRUCCIÓN DE UNA ENTRADA DE TEXTO (FECHA DE NACIMIENTO)
		//entradaTextoNacimiento = new JTextField();
		//entradaTextoNacimiento.setBounds(230,190,195,25);
		//entradaTextoNacimiento.setBackground(Color.LIGHT_GRAY);
		//entradaTextoNacimiento.setToolTipText("Ej. dd/mm/yyyy");
		//add(entradaTextoNacimiento);
		
		//CONSTRUCCIÓN DE UNA ENTRADA DE TEXTO (FECHA DE NACIMIENTO)
		entradaTextoNacimiento = new JTextField();
		entradaTextoNacimiento.setBounds(230,190,195,25);
		entradaTextoNacimiento.setBackground(Color.LIGHT_GRAY);
        TextPrompt placeholder3 = new TextPrompt("dd/mm/yyyy",entradaTextoNacimiento);
        placeholder3.changeAlpha(0.75f);
        add(entradaTextoNacimiento);
		
	
		//CONSTRUCCIÓN DE UN BOTON DE REGISTRO
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBounds(90,270,130,25);
		botonRegistrar.setBackground(Color.gray);
		add(botonRegistrar);	
		botonRegistrar.addActionListener(this);	
	}
	
	public void ventanaDeRegistro(){
		InterfazGrafica interfazGrafica = new InterfazGrafica();
		interfazGrafica.setBounds(0,0,700,450);  
		interfazGrafica.setVisible(true);        
		interfazGrafica.setResizable(false);     
		interfazGrafica.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botonRegistrar) {
			
			//INSTANCIA DE CLASE
			logicaDelPrograma registrarDatos = new logicaDelPrograma();
			
			String correo = entradaTextoCorreo.getText();//ggasubuyuj@scl.edu.gt
			String nombre = entradaTextoNombre.getText();
			String fecha = entradaTextoNacimiento.getText();
			
			int correoValido;
			int nombreValido;
			int fechaValida;
			
			//ACCION DE CORREO
			if(registrarDatos.comprobacionCorreo(correo)) {
				labelVerificacionCorreo.setText("true");
				labelVerificacionCorreo.setOpaque(true);
				labelVerificacionCorreo.setForeground(Color.green);
				correoValido=1;//1 = VALIDO
				
			}else {
				labelVerificacionCorreo.setText("null");
				labelVerificacionCorreo.setOpaque(true);
				labelVerificacionCorreo.setForeground(Color.RED);
				correoValido=2;//2 = INVALIDO
			}
			
			//ACCION DE NOMBRE
			if(registrarDatos.comprobacionNombre(nombre)) {
				labelVerificacionNombre.setText("true");
				labelVerificacionNombre.setForeground(Color.green);
				nombreValido=1;

			}else {
				labelVerificacionNombre.setText("null");
				labelVerificacionNombre.setOpaque(true);
				labelVerificacionNombre.setForeground(Color.RED);
				nombreValido=2;
			}
			
			//ACCION DE FECHA DE NACIMIENTO
			if(registrarDatos.comprobacionEdad(fecha)) {
				labelVerificacionFecha.setText("true");
				labelVerificacionFecha.setOpaque(true);
				labelVerificacionFecha.setForeground(Color.green);
				fechaValida=1;
				
			}else {
				labelVerificacionFecha.setText("null");
				labelVerificacionFecha.setOpaque(true);
				labelVerificacionFecha.setForeground(Color.RED);
				fechaValida=2;
			}
			
			//VALIDACION REGISTRO ALUMNO
			if(correoValido==1 && nombreValido==1 && fechaValida==1) {
				labelRegistro.setText("EL ALUMNO HA SIDO REGISTRADO");
				labelRegistro.setForeground(Color.green);
			}else {
				labelRegistro.setText("EL ALUMNO NO HA SIDO REGISTRADO");
				labelRegistro.setForeground(Color.red);
			}
		}
		

	}
	
}
