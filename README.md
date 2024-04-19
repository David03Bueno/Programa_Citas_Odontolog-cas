# Programa agenda de citas Clinica Mi Sonrisa
Aqui estaremos documentando el codigo de nuestro proyecto.

Este programa fue realizado pensando en las necesidades presentadas por la Clinica Mi Sonrisa, dando solucion efectia a las mismas.

---

# Desarrolladores
* **Paula Henrsez** - SQA & Diseño | paulahenrsez@gmail.com
* **Luis David Bueno** - DBA | david03bueno@gmail.com
* **Vladimi Lenin Mota Reyes** - Lider de proyecto | vladimirleninmota@hotmail.com
---
# Tecnologias utilizadas
* Lenguaje JAVA utilizando el IDE de Netbeans.
* Mysql como gestor de base de datos.
---
# Requisitos del programa
* Sistema operativo Windows(10 en adelante), MacOS, Linux.
* 2GB de memoria ram (recomendado).
* Espacio en disco de 100MB en adelante.
---
# Como instalar el programa.
* Debe descargar el proyecto utilizando el siguiente repositorio "https://github.com/David03Bueno/Programa_Citas_Odontolog-cas.git"
* Descargar e instalar el IDE de Netbeans y el jdbc conector 8.0.3 para MySQL (Puede usar el siguiente enlace; https://netbeans.apache.org/front/main/download/index.html).
* Importar el projecto a Netbeans y ejecutar.

# Manuales
* Técnico: https://1drv.ms/b/c/823d5fa4089c83c1/ESrML9M9n7hLneu8yxxLM8ABiKBZkFQRCrsdLcylj_RMMg?e=37oynz
* Usuario: https://1drv.ms/b/c/823d5fa4089c83c1/EWqq_x7Tc5dFg5R9nw_FzcMBtoztxMgSfRRSiMqHMdHkTw?e=jBZVQf

---

# Pantalla LOGIN

## Aqui tenemos las funciones para:
---
* **Iniciar sesion**
---
Aqui se solicita al usuario el correo y contraseña, las mismas se validan con la base de datos y de ser correctos permite el acceso al programa.

```
public void IniciarSeccion() {
        String email = jTextField1.getText();
        String contra = jPasswordField1.getText();
        String guardaContr = null;
        String guarcorreo = null;

  
        String SQL = "SELECT * FROM Usuarios WHERE Correo=? AND Contrasena=?";
       
        try {
            ps= cn.prepareStatement(SQL);
            ps.setString(1, jTextField1.getText());
            ps.setString(2, jPasswordField1.getText());
            rs = ps.executeQuery();
            
            while(rs.next()){
               guarcorreo = rs.getString(3);
               guardaContr = rs.getString(4);
               
            }
            if(email.equals(guarcorreo) && contra.equals(guardaContr)){
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso"); 
                MenuFrame();
                 limpiarCampos();
            }
            else{
                JOptionPane.showMessageDialog(null, "Email o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);      
        }
       
    }
```
---
* **Crear nueva cuenta/usuario**
---
Se solicitar al usuario su nombre, correo y una contraseña, los cuales se guardaran en la tabla usuarios de la base de datos al presionar el boton registrar que llamara al metodo registrar() y nos dirige nuevamente al panel de inicio de sesion.

```
  private void registrar() {
        String insertarUsu = "INSERT INTO Usuarios(NombreCompl,Correo,Contrasena) VALUES (?,?,?)";

        try {
            PreparedStatement ps;
            ps = (PreparedStatement) cn.prepareStatement(insertarUsu);
            ps.setString(1, jTextField1.getText());
            ps.setString(2, jTextField2.getText());
            ps.setString(3, jPasswordField1.getText());
            ps.executeUpdate();
            int IdUsuario = obtenerIDUsuarioDesdeBaseDeDatos();
            String mensaje = """
                             Registro realizado con éxito. 
                             Estimado usuario recuerde guardar su ID para fines de consulta:  """ + IdUsuario;
            JOptionPane.showMessageDialog(rootPane, mensaje);
            limpiarCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al tratar de insertar los datos: " + ex);
        }
    }
```
---
* **Salir de la APP**
---
Puedes salir de la aplicacion accionando el boton salir.

`System.exit(0);`
# Panel principal
## Aqui tenemos las funciones para:
---
---
* **Informacion de la aplicacion**
---
Nos muestra la version de la aplicacion.
```
private void btnAplicacionActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //Se crea un bloque de codigo para el mensaje que es llmado mas tarde
        String mensaje = """
                         VERSI\u00d3N DEL PROGRAMA: 1.0.0
                         Desarrollador: [SIL]
                         Plataforma: Android / iOS
                         Fecha de Lanzamiento: 15 de Abril del 2024""";

    JOptionPane.showInternalMessageDialog(null, mensaje, "ACERCA DE LA APP", JOptionPane.PLAIN_MESSAGE, icono("/Icono2/6410174.png", 40, 40));
    } 
```
---
* **Agendar citas**
---
Accionando este boton nos dirige al panel para interactuar con las citas
```
private void TAB1MouseClicked(java.awt.event.MouseEvent evt) {                                  
        
        //Se crea una instancia para llamar la otra pestaña
        mantenimientocitas CitasFrame = new mantenimientocitas();
        CitasFrame.setVisible(true);
        CitasFrame.pack();
        CitasFrame.setLocationRelativeTo(null);
        this.dispose();
    }                     
```
---
* **Como usar la APP**
---
En esta parte nos mostrara un manual de usuario en pdf, con las indicaciones precisas e intuitivas para que cualquier persona incluyendo personas de edad avanzada puedan usar la APP.
```
 private void TAB2MouseClicked(java.awt.event.MouseEvent evt) {                                  
        
        //Locacion del pdf
        try {
        File file = new File("C:/Users/paula/OneDrive/Escritorio/Manual_usuario.pdf");
        //Se chequea si el pdf existe sino se ejecutan los else
        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this, "No compatible");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El archivo no existe");
        }
        //Va de la mano con los else en caso de que halla algun error, identificarlos y solucionarlos
    } catch (Exception e) {
        e.printStackTrace();
        }    
    }                                 
```
---
* **Manual Tecnico**
---
Aqui podemos ver un documento creado para que las personas del departamento de TI tengan conocimiento mas especifico de como funciona el programa, tipo de datos que requieren los campos y recomendaciones de importancia maxima para el mantenimiento del mismo.

```
  private void TAB3MouseClicked(java.awt.event.MouseEvent evt) {                                  
        
        //Locacion del pdf
        try {
        File file = new File("C:/Users/paula/OneDrive/Escritorio/Manual_técnico.pdf");
        //Se chequea si el pdf existe sino se ejecutan los else
        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this, "No compatible");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El archivo no existe");
        }
        //Va de la mano con los else en caso de que halla algun error, identificarlos y solucionarlos
    } catch (Exception e) {
        e.printStackTrace();
    }

    }                            
```
---
* **Solicitar ayuda**
--- 
Accionando este boton nos dirige al panel para interactuar con las solicitudes de ayuda.
```
 private void TAB4MouseClicked(java.awt.event.MouseEvent evt) {                                  
        
        //Se crea una instancia para llamar la otra pestaña
        mantenimientoayuda AyudaFrame = new mantenimientoayuda();
        // Hacer visible el marco (frame) de ayuda
        AyudaFrame.setVisible(true);
        // Ajustar el tamaño del marco de ayuda automáticamente según su contenido
        AyudaFrame.pack();
        // Establecer la posición del marco de ayuda en el centro de la pantalla
        AyudaFrame.setLocationRelativeTo(null);
        // Cerrar y liberar los recursos de la ventana actual (la que contiene este código)
        this.dispose();
    }     
```
---
* **Cerrar sesion**
--- 
Este boton nos va a cerrar la sesion del usuario activo y nos transportara al panel de Login.
```
 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //Se crea una instancia para llamar la otra pestaña
        JOptionPane.showMessageDialog(rootPane, "Cerrando sesión...");
        login LoginFrame = new login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }                                        
```




Se llenan los campos solicitados y esta informacion es introducida a nuestra base de datos en la tabla citas, en la tabla a mano izquierda podremos ver las citas, al seleccionar una cita podremos modificarla usando el boton 
* .
* Salir de la APP.
---
# Panel citas
En este panel tendremos las opciones para crear, ver, modificar o borrar una cita segun las necesidades del usuario.
___
## Aqui tenemos las funciones para:
---
* **Agendar**
--- 
Se llenan los campos solicitados y esta informacion es introducida a nuestra base de datos en la tabla citas al presionar el boton de agendar se invoca nuestro metodo insertar() que contiene la sintaxis SQL para introducir los datos a la tabla descrita.
```
  private void insertar() {
        String ID = txtIDusuario.getText();
        String consultaNombre = "SELECT IdUsuario FROM Usuarios WHERE IdUsuario =" + ID;

        String IDusuario = null;
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultaNombre);
            while (rs.next()) {
                IDusuario = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        int i = choice2.getSelectedIndex();
        String consultaHorario = "SELECT IdHoraios FROM Horarios WHERE IdHoraios=" + i;

        String IDHorarios = null;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultaHorario);
            while (rs.next()) {
                IDHorarios = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error en la consulta SQL: " + ex);
            Logger.getLogger(mantenimientocitas.class.getName()).log(Level.SEVERE, null, ex);
        }

        String insertarSQL = "INSERT INTO Citas(IdUsuario, IdHoraios, IdDoctor) VALUES (?,?,?)";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) cn.prepareStatement(insertarSQL);
            ps.setString(1, IDusuario);
            ps.setString(2, IDHorarios);
            ps.setString(3, data3);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Registro realizado con exito.");
            btnAgendar.setEnabled(true);
            btnCancelar.setEnabled(false);
            btnModificar.setEnabled(true);
            mostrarDatos(txtIDusuario.getText());
            limpiarCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al tratar de insertar los datos: " + ex);
        }
    }
```
---
* **Modificar**
--- 
Aqui podremos modificar los valores de nuestra cita seleccionada, para seleccionar la cita solo debemos de hacer click en la misma que se muetra en la tabla a mano izquierda, modificar los datos segun aplique y presionar el boton de modificar.

---
* **Eliminar**
--- 
Para eliminar una cita, tendremos que hacer click derecho en la misma y presionar el boton eliminar.
```
public void iniciacializarMenu() {
        JMenuItem delete = new JMenuItem("Eliminar");
        jPopupMenu1.add(delete);

        tblDatos.setComponentPopupMenu(jPopupMenu1);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(rootPane, "Se eliminara el registro, desea continuar?", "Eliminar Registro",
                        JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        String Borrar = "DELETE FROM Citas WHERE IdCitas='" + txtIDCita.getText() + "'";
                        PreparedStatement ps;
                        ps = (PreparedStatement) cn.prepareStatement(Borrar);
                        int respuesta = ps.executeUpdate();
                        if (respuesta > 0) {
                            JOptionPane.showMessageDialog(null, "Registro eliminado con exito!");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No ha seleccionado la fila a ser borrada.");
                            limpiarCampos();
                        }
                    } catch (SQLException exception) {
                        System.err.println("Error al eliminar...." + exception);
                        JOptionPane.showMessageDialog(null, "Error al eliminar!");
                    }

                } else {
                    limpiarCampos();
                    mostrarDatos(txtIDusuario.getText());
                    btnModificar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnAgendar.setEnabled(true);
                }
            }
        });
    }
```
# Panel Solicitudes de Ayudas
En este panel tendremos las opciones para crear, ver, modificar o borrar una solicitud de ayuda segun las necesidades del usuario.
___
## Aqui tenemos las funciones para:
---
* **Enviar**
--- 
Aqui enviamos la solicitud a la base de datos, esto crea una solicitud, se deben de llenar los campos solicitados, al presionar el boton de enviar este llama a nuestro metodo insertarDatos(); que inyecta la informacion a la base de datos.

```
private void insertarDatos() {
        //EN ESTA FUNCION INSERTAMOS LOS DATOS A LA TABLA AYUDA
        String insertarSQL = "INSERT INTO Ayuda(Nombre, Comentario, IdUsuario) VALUES (?,?,?)";
        try {
            PreparedStatement ps;
            ps = (PreparedStatement) cn.prepareStatement(insertarSQL);
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtIDComentario.getText());
            ps.setString(3, txtIDUsuario.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Registro realizado con exito.");
            btnModificar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnEnviar.setEnabled(true);
            mostrarDatos(txtIDUsuario.getText());
            limpiarCampos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al tratar de insertar los datos: " + ex);
        }
    }
```
---
* **Modificar**
--- 
Aqui podremos modificar los valores de nuestra solicitud de ayuda seleccionada, para seleccionar la solicitud solo debemos de hacer click en la misma la cual se muetra en la tabla a mano izquierda, modificar los datos segun aplique y presionar el boton de modificar.
```
 private void modficarDatos() {
        //AQUI HACEMOS UNA UPDATE A LA BASE DE DATOS
        //Y ACTUALIZAMOS LOS DATOS CON LOS CAMPOS SELECCIONADOS
        String actualizarSQL = "UPDATE Ayuda SET Nombre='" + txtNombre.getText()
                + "', Comentario='" + txtIDComentario.getText()
                + "' WHERE IdAyuda ="+ txtIDSolicutd.getText();
        try {
            PreparedStatement ps;
            ps = (PreparedStatement) cn.prepareStatement(actualizarSQL);
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente.");
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnEnviar.setEnabled(true);
                dtm.setRowCount(0);
                mostrarDatos(txtIDUsuario.getText());
                limpiarCampos();
                txtBuscar.setText("");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar datos: " + ex);
        }
    }
```
---
* **Eliminar**
--- 
Para eliminar una Solicitud de ayuda, tendremos que hacer click derecho en la misma y presionar el boton eliminar.
```

```
