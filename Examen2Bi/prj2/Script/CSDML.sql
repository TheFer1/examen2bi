-- database: ../DataBase/CSDataBase.sqlite

-- version: 1.0
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
|     fernando casa                      |
|----------------------------------------|
Autor : Fernando Casa 
Fecha : 14/08/2024
Script: Creacion de la estructura de datos para EcuaFauna
*/
INSERT INTO CSPais 
(Nombre)VALUES 
('Ecuador');

INSERT INTO CSRegion
(idCSPais               ,Nombre         )VALUES
(1                      ,'Costa'        ),
(1                      ,'Sierra'       ),
(1                      ,'Oriente'      ),
(1                      ,'Galápagos'    );

INSERT INTO CSProvincia 
(idCSRegion, Nombre)VALUES
(1      , 'Esmeraldas'      ),
(1      , 'Manabí'          ),
(1      , 'Los Ríos'        ),
(1      , 'Guayas'          ),
(1      , 'Santa Elena'     ),
(1      , 'El Oro'          ),
(1      , 'Santo Domingo de los Tsáchilas'),
(2      , 'Carchi'          ),
(2      , 'Imbabura'        ),
(2      , 'Pichincha'       ),
(2      , 'Cotopaxi'        ),
(2      , 'Tungurahua'      ),
(2      , 'Bolívar'         ),
(2      , 'Chimborazo'      ),
(2      , 'Cañar'           ),
(2      , 'Azuay'           ),
(2      , 'Loja'            ),
(3      , 'Sucumbíos'       ),
(3      , 'Napo'            ),
(3      , 'Orellana'        ),
(3      , 'Pastaza'         ),
(3      , 'Morona Santiago' ),
(3      , 'Zamora Chinchipe'),
(4      , 'Galápagos'       );
 


INSERT INTO CSTipoAlimento
(Nombre)VALUES
 ('IngestaNativa'   )
,('GenoAlimento'    );

INSERT INTO CSAlimento
(idCSTipoAlimento,    Nombre             )VALUES
(1                  ,'Carnivoro'            ),
(1                  ,'Herbívoro'            ),
(1                  ,'Omnivoro'             ),
(1                  ,'Insectivoro'          ),
(2                  ,'X'                    ),
(2                  ,'XX'                   ),
(2                  ,'XY'                   );

INSERT INTO CSSexo
(Nombre)VALUES
('Macho'    ),
('Hembra'   ),
('Asexual'  );

INSERT INTO CSHormiga
(TipoHormiga        ,idCSSexo           ,idCSProvincia      ,idGenoAlimento     ,idIngestaNativa)VALUES
('HormigaRoja'      ,1                  ,2                  ,6                  ,2                 );




SELECT 
    H.TipoHormiga, S.Nombre AS NombreSexo, P.Nombre AS NombreProvincia, 
    G.Nombre AS NombreGenoAlimento, 
    I.Nombre AS NombreIngestaNativa, 
    H.FechaCreacion
FROM CSHormiga H 
JOIN 
    CSSexo S ON H.idCSSexo = S.idCSSexo 
JOIN 
    CSProvincia P ON H.idCSProvincia = P.idCSProvincia 
JOIN 
    CSAlimento G ON H.idGenoAlimento = G.idCSAlimento  
JOIN 
    CSAlimento I ON H.idIngestaNativa = I.idCSAlimento  
WHERE 
    H.Estado LIKE 'A' 
    AND S.Estado LIKE 'A' 
    AND P.Estado LIKE 'A' 
    AND G.Estado LIKE 'A' 
    AND I.Estado LIKE 'A';

UPDATE CSProvincia  
SET Nombre = ?  
 WHERE idCSProvincia = ?;



 SELECT 
    H.TipoHormiga, 
    S.Nombre AS NombreSexo, 
    P.Nombre AS NombreProvincia, 
    G.Nombre AS NombreGenoAlimento, 
    I.Nombre AS NombreIngestaNativa, 
    H.FechaCreacion
FROM 
    CSHormiga H
JOIN 
    CSSexo S ON H.idCSSexo = S.idCSSexo
JOIN 
    CSProvincia P ON H.idCSProvincia = P.idCSProvincia
JOIN 
    CSAlimento G ON H.idGenoAlimento = G.idCSAlimento 
JOIN 
    CSAlimento I ON H.idIngestaNativa = I.idCSAlimento 
WHERE 
    H.Estado = 'A' 
    AND S.Estado = 'A' 
    AND P.Estado = 'A' 
    AND G.Estado = 'A' 
    AND I.Estado = 'A' 
    AND H.idCSHormiga = 1;
