drop database if exists DB_Ventas_in5cm;
create database DB_Ventas_in5cm;
use DB_Ventas_in5cm;

create table Usuarios(
	codigo_usuario int auto_increment not null primary key,
    username varchar(45) not null,
    pasword varchar(45) not null,
    email varchar(60),
    rol varchar(45) not null,
    estado int not null
);

create table Productos(
	codigo_producto int auto_increment not null primary key,
    nombre_producto varchar(60) not null,
    precio decimal(10, 2) not null,
    stock int not null, 
    estado int not null
);

create table Clientes(
	dpi_cliente int auto_increment not null primary key,
    nombre_cliente varchar(50) not null,
    apellido_cliente varchar(50) not null,
    direccion varchar(100) not null,
    estado int not null
);

create table Ventas(
	codigo_venta int auto_increment not null primary key,
    fecha_venta date not null,
    total decimal(10, 2) not null,
    estado int not null,
    clientes_dpi_cliente int not null,
    Usuario_codigo_usuario int not null,
    foreign key (clientes_dpi_cliente) references Clientes(dpi_cliente),
    foreign key ( Usuario_codigo_usuario) references Usuarios(codigo_usuario)
);

create table detalle_venta(
	codigo_detalle_venta int auto_increment not null primary key,
    cantidad int not null, 
    precio_unitario decimal(10, 2) not null,
    subtotal decimal(10, 2) not null,
    productos_codigo_producto int not null,
    ventas_codigo_venta int not null,
    foreign key (productos_codigo_producto) references Productos(codigo_producto),
    foreign key (ventas_codigo_venta) references Ventas(codigo_venta) on delete cascade
);


-- PROCEDIMIENTOS ALMACENADOS --

		-- USUARIOS --
-- create --
Delimiter $$
create procedure sp_Usuarios_create(in p_username varchar(45), in p_pasword varchar(45),
in p_email varchar(60), in p_rol varchar(45), in p_estado int)
	begin
		insert into Usuarios(username, pasword, email, rol, estado)
		values (p_username, p_pasword, p_email, p_rol, p_estado);
		select last_insert_id() as codigo_usuario;
    end $$
Delimiter ;

-- Read --
Delimiter $$ 
create procedure sp_Usuarios_read_all()
	begin 
		select * from Usuarios order by codigo_usuario;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
create procedure sp_Usuarios_update(in p_codigo_usuario int, in p_username varchar(45), in p_pasword varchar(45),
in p_email varchar(60), in p_rol varchar(45), in p_estado int)
    begin 
		update Usuarios
		set username = p_username,
            pasword = p_pasword,
            email = p_email,
            rol = p_rol,
            estado = p_estado
            where codigo_usuario = p_codigo_usuario;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Usuarios_delete(in p_codigo_usuario int )
    begin
		delete from Usuarios where codigo_usuario = p_codigo_usuario;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;


		-- PRODUCTOS --
-- create --
Delimiter $$
create procedure sp_Productos_create(in p_nombre_producto varchar(60), in p_precio decimal(10, 2),
in p_stock int, in p_estado int)
	begin
		insert into Productos(nombre_producto, precio, stock, estado)
		values (p_nombre_producto, p_precio, p_stock, p_estado);
		select last_insert_id() as codigo_producto;
    end $$
Delimiter ;

-- Read --
Delimiter $$ 
create procedure sp_Productos_read_all()
	begin 
		select * from Productos order by codigo_producto;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
create procedure sp_Productos_update(in p_codigo_producto int, in p_nombre_producto varchar(60), in p_precio decimal(10, 2),
in p_stock int, in p_estado int)
    begin 
		update Productos
		set nombre_producto = p_nombre_producto,
            precio = p_precio,
            stock = p_stock,
            estado = p_estado
            where codigo_producto = p_codigo_producto;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Productos_delete(in p_codigo_producto int )
    begin
		delete from Productos where codigo_producto = p_codigo_producto;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

		-- CLIENTES --
-- create --
Delimiter $$
create procedure sp_Clientes_create(in p_nombre_cliente varchar(50), in p_apellido_cliente varchar(50),
in p_direccion varchar(100), in p_estado int)
	begin
		insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
		values (p_nombre_cliente, p_apellido_cliente, p_direccion, p_estado);
		select last_insert_id() as dpi_cliente;
    end $$
Delimiter ;

-- Read --
Delimiter $$ 
create procedure sp_Clientes_read_all()
	begin 
		select * from Clientes order by dpi_cliente;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
create procedure sp_Clientes_update(in p_dpi_cliente int, in p_nombre_cliente varchar(50), in p_apellido_cliente varchar(50),
in p_direccion varchar(100), in p_estado int)
    begin 
		update Clientes
		set nombre_cliente = p_nombre_cliente,
            apellido_cliente = p_apellido_cliente,
            direccion = p_direccion,
            estado = p_estado
            where dpi_cliente = p_dpi_cliente;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Clientes_delete(in p_dpi_cliente int )
    begin
		delete from Clientes where dpi_cliente = p_dpi_cliente;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;
        
        
		-- VENTAS --
-- create --
Delimiter $$
create procedure sp_Ventas_create(in p_fecha_venta date, in p_total decimal(10, 2),
 in p_estado int, in p_clientes_dpi_cliente int, in p_Usuario_codigo_usuario int)
	begin
		insert into Ventas(fecha_venta, total, estado, clientes_dpi_cliente, Usuario_codigo_usuario)
		values (p_fecha_venta, p_total, p_estado, p_clientes_dpi_cliente, p_Usuario_codigo_usuario);
		select last_insert_id() as codigo_venta;
    end $$
Delimiter ;

-- Read --
Delimiter $$ 
create procedure sp_Ventas_read_all()
	begin 
		select * from Ventas order by codigo_venta;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
create procedure sp_Ventas_update(in p_codigo_venta int, in p_fecha_venta date, in p_total decimal(10, 2),
 in p_estado int, in p_clientes_dpi_cliente int, in p_Usuario_codigo_usuario int)
    begin 
		update Ventas
		set fecha_venta = p_fecha_venta,
            total = p_total,
            estado = p_estado,
            clientes_dpi_cliente = p_clientes_dpi_cliente,
            Usuario_codigo_usuario = p_Usuario_codigo_usuario
            where codigo_venta = p_codigo_venta;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_Ventas_delete(in p_codigo_venta int )
    begin
		delete from Ventas where codigo_venta = p_codigo_venta;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;


		-- DETALLE DE VENTAS --
-- create --
Delimiter $$
create procedure sp_detalle_venta_create(in p_cantidad int, in p_precio_unitario decimal(10, 2),
 in p_subtotal decimal(10, 2), in p_productos_codigo_producto int, in p_ventas_codigo_venta int)
	begin
		insert into detalle_venta(cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
		values (p_cantidad, p_precio_unitario, p_subtotal, p_productos_codigo_producto, p_ventas_codigo_venta);
		select last_insert_id() as codigo_detalle_venta;
    end $$
Delimiter ;

-- Read --
Delimiter $$ 
create procedure sp_detalle_venta_read_all()
	begin 
		select * from detalle_venta order by codigo_detalle_venta;
    end $$
Delimiter ;

-- Update -- 
Delimiter $$
create procedure sp_detalle_venta_update(in p_codigo_detalle_venta int, in p_cantidad int, in p_precio_unitario decimal(10, 2),
 in p_subtotal decimal(10, 2), in p_productos_codigo_producto int, in p_ventas_codigo_venta int)
    begin 
		update detalle_venta
		set cantidad = p_cantidad,
            precio_unitario = p_precio_unitario,
            subtotal = p_subtotal,
            productos_codigo_producto = p_productos_codigo_producto,
            ventas_codigo_venta = p_ventas_codigo_venta
            where codigo_detalle_venta = p_codigo_detalle_venta;
		select row_count() as filas_afectadas;
    end $$
Delimiter ;

-- Delete --
Delimiter $$
	create procedure sp_detalle_venta_delete(in p_codigo_detalle_venta int )
    begin
		delete from detalle_venta where codigo_detalle_venta = p_codigo_detalle_venta;
        select row_count() as filas_afectadas;
    end $$
Delimiter ;

	-- REGISTROS USUARIOS --
call sp_Usuarios_create('Juan','123','juan@mail.com','Admin',1);
call sp_Usuarios_create('Pedro','123','pedro@mail.com','Vendedor',1);
call sp_Usuarios_create('Luis','123','luis@mail.com','Vendedor',0);
call sp_Usuarios_create('Domingo','123','domingo@mail.com','Vendedor',1);
call sp_Usuarios_create('Anderson','123','anderson@mail.com','Vendedor',0);
call sp_Usuarios_create('Victor','123','victor@mail.com','Supervisor',1);
call sp_Usuarios_create('Marian','123','marian@mail.com','Supervisor',1);       
        
	-- REGISTROS PRODUCTOS --
call sp_Productos_create('Laptop', 7500.00, 10, 1);
call sp_Productos_create('Mouse', 150.00, 50, 1);
call sp_Productos_create('Teclado', 300.00, 30, 1);
call sp_Productos_create('Monitor', 1800.00, 15, 1);
call sp_Productos_create('USB', 80.00, 100, 0);
call sp_Productos_create('Impresora', 1200.00, 8, 1);
call sp_Productos_create('Tablet', 2500.00, 12, 0);

	-- REGISTROS CLIENTES --
call sp_Clientes_create('Juan','Perez','Ciudad de Guatemala',1);
call sp_Clientes_create('Maria','Lopez','Mixco',1);
call sp_Clientes_create('Carlos','Ramirez','Villa Nueva',0);
call sp_Clientes_create('Ana','Gomez','Antigua Guatemala',1);
call sp_Clientes_create('Luis','Martinez','Escuintla',1);
call sp_Clientes_create('Sofia','Hernandez','Quetzaltenango',0);
call sp_Clientes_create('Pedro','Castillo','Chimaltenango',1);

	-- REGISTROS VENTAS --
call sp_Ventas_create('2026-03-01', 7800.00, 1, 1, 1);
call sp_Ventas_create('2026-03-02', 300.00, 1, 2, 2);
call sp_Ventas_create('2026-03-03', 1800.00, 1, 3, 3);
call sp_Ventas_create('2026-03-04', 150.00, 0, 4, 4);
call sp_Ventas_create('2026-03-05', 1200.00, 1, 5, 5);
call sp_Ventas_create('2026-03-06', 2500.00, 1, 6, 6);
call sp_Ventas_create('2026-03-07', 7500.00, 0, 7, 7);

	-- REGISTROS DETALLE DE VENTAS --
call sp_detalle_venta_create(1, 7500.00, 7500.00, 1, 1);
call sp_detalle_venta_create(2, 150.00, 300.00, 2, 2);
call sp_detalle_venta_create(1, 1800.00, 1800.00, 4, 3);
call sp_detalle_venta_create(1, 150.00, 150.00, 2, 4);
call sp_detalle_venta_create(1, 1200.00, 1200.00, 6, 5);
call sp_detalle_venta_create(1, 2500.00, 2500.00, 7, 6);
call sp_detalle_venta_create(1, 7500.00, 7500.00, 1, 7);
        
