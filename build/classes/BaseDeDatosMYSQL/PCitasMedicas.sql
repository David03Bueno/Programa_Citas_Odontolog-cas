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
Horas NVARCHAR(10) NOT NULL
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
IdDoctor INT, FOREIGN KEY(IdDoctor) REFERENCES Doctor(IdDoctor),
MotivoCita NVarchar(150) not null,
Fecha Nvarchar(30) not null
)

CREATE TABLE Ayuda
(
IdAyuda INT PRIMARY KEY AUTO_INCREMENT,
 Nombre Nvarchar(30) not null,
 Comentario Nvarchar (150) not null,
 IdUsuario INT, FOREIGN KEY(IdUsuario) REFERENCES Usuarios(IdUsuario)
)

INSERT INTO Especialidad (Nombre)
values
('Odontología General'),
('Ortodoncia'),
('Endodoncia'),
('Odontopediatría'),
('Implantología Dental'),
('Cirugía Oral y Maxilofacial')

INSERT INTO Doctor (Nombre, Apellido, Telefono, IdEspecialidad) 
VALUES 
    ('Juan', 'Pérez', '809-333-8003', 1),
    ('María', 'Gómez', '849-394-8320', 2),
    ('Carlos', 'López', '829-098-3742', 3),
    ('Ana', 'Martínez', '809-274-3526', 4),
    ('Pedro', 'Sánchez', '829-018-5367', 5),
    ('Laura', 'Rodríguez', '809-242-8464', 6);

INSERT INTO Horarios(Horas)
values
('09:30 am'),
('10:45 am'),
('12:00 pm'),
('02:00 pm'),
('03:15 pm'),
('04:30 pm');

select * from Usuarios;
select * from citas;
select * from Ayuda
SET SQL_SAFE_UPDATES =0;
truncate table citas
