CREATE database PCitasMedicas
Use PCitasMedicas

CREATE TABLE Usuarios
(
IdUsuario INT AUTO_INCREMENT,
NombreCompl VARCHAR(50) NOT NULL,
Correo NVARCHAR(40) NOT NULL,
Contrasena NVARCHAR(40) NOT NULL,
PRIMARY KEY(IdUsuario)
)

CREATE TABLE Especialidad
(
IdEspecialidad INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(60) NOT NULL
)

CREATE TABLE Horarios
(
IdHoraios INT PRIMARY KEY AUTO_INCREMENT,
Horas time NOT NULL
)

CREATE TABLE Doctor 
(
IdDoctor INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(50) NOT NULL,
Apellido VARCHAR(50) NOT NULL,
Telefono NVARCHAR(15) NOT NULL,
IdEspecialidad INT, FOREIGN KEY(IdEspecialidad) REFERENCES Especialidad(IdEspecialidad)
)

CREATE TABLE Citas 
(
IdCitas INT PRIMARY KEY AUTO_INCREMENT,
IdUsuario INT, FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario),
IdHoraios INT, FOREIGN KEY(IdHoraios) REFERENCES Horarios(IdHoraios),
IdDoctor INT, FOREIGN KEY(IdDoctor) REFERENCES Doctor(IdDoctor)
)
select * from Usuarios
SET SQL_SAFE_UPDATES =0;
DELETE FROM Usuarios
