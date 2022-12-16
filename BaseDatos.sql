-- Tabla: cliente

CREATE TABLE IF NOT EXISTS cliente
(
    id integer NOT NULL,
    direccion character varying(255) ,
    edad integer,
    genero character varying(255) ,
    identificacion character varying(255) ,
    nombre character varying(255) ,
    telefono integer,
    clienteid integer,
    "contraseña" character varying(255) ,
    estado character varying(255) ,
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
)

-- Tabla: cuenta

CREATE TABLE IF NOT EXISTS cuenta
(
    id integer NOT NULL,
    estado character varying(255) ,
    numero_cuenta integer,
    saldo_inicial integer,
    tipo_cuenta character varying(255) ,
    cli_id integer NOT NULL,
    CONSTRAINT cuenta_pkey PRIMARY KEY (id),
    CONSTRAINT foraneaCliCuen FOREIGN KEY (cli_id)
        REFERENCES cliente (id) 
)

-- Tabla: movimiento

CREATE TABLE IF NOT EXISTS movimiento
(
    id integer NOT NULL,
    fecha timestamp without time zone,
    saldo integer,
    tipo_movimiento character varying(255) ,
    valor integer,
    cue_id integer NOT NULL,
    CONSTRAINT movimiento_pkey PRIMARY KEY (id),
    CONSTRAINT foraneaCuenMov FOREIGN KEY (cue_id)
        REFERENCES cuenta (id)
        
)

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 10000
    CACHE 1;