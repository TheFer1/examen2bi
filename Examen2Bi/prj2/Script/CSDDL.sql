-- database: ../DataBase/CSDataBase.sqlite
-- version: 1.0

DROP TABLE IF EXISTS CSPais ; 
DROP TABLE IF EXISTS CSRegion ; 
DROP TABLE IF EXISTS CSProvincia ;
DROP TABLE IF EXISTS CSTipoAlimento ;
DROP TABLE IF EXISTS CSAlimento ;
DROP TABLE IF EXISTS CSSexo ;
DROP TABLE IF EXISTS CSHormiga ;


CREATE TABLE CSPais (
     idCSPais          INTEGER PRIMARY KEY AUTOINCREMENT 
    ,Nombre             VARCHAR(25) NOT NULL  UNIQUE 
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))

    
); 

CREATE TABLE CSRegion(
    idCSRegion          INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(25) NOT NULL  UNIQUE
    ,idCSPais           INTEGER NOT NULL REFERENCES CSPais (idCSPais)
    ,Estado VARCHAR(1)  DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
);

CREATE TABLE CSProvincia(
    idCSProvincia       INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(25) NOT NULL  UNIQUE
    ,idCSRegion          INTEGER NOT NULL REFERENCES CSRegion (idCSRegion)
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))

);

CREATE TABLE CSTipoAlimento(
    idCSTipoAlimento        INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(25) NOT NULL  UNIQUE CHECK (Nombre IN ('IngestaNativa', 'GenoAlimento'))
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
);

CREATE TABLE CSAlimento(
    idCSAlimento        INTEGER PRIMARY KEY AUTOINCREMENT
    ,idCSTipoAlimento   INTEGER NOT NULL REFERENCES CSTipoAlimento (idCSTipoAlimento)
    ,Nombre             VARCHAR(25) NOT NULL 
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))

);

CREATE TABLE CSSexo( 
    idCSSexo            INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(50) NOT NULL CHECK (Nombre IN ('Macho', 'Hembra', 'Asexual'))
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
);

CREATE TABLE CSHormiga(
    idCSHormiga        INTEGER PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga        VARCHAR(100) NOT NULL 
    ,idCSSexo           INTEGER NOT NULL REFERENCES CSSexo(idCSSexo)
    ,idCSProvincia      INTEGER NOT NULL REFERENCES CSProvincia(idCSProvincia)
    ,idGenoAlimento     INTEGER NOT NULL REFERENCES CSAlimento(idCSAlimento)
    ,idIngestaNativa    INTEGER NOT NULL REFERENCES CSAlimento(idCSAlimento)
    ,Estado VARCHAR(1) DEFAULT 'A' CHECK (Estado IN ('X', 'A'))
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))

)







