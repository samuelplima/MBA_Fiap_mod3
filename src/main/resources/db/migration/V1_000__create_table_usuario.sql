CREATE
DATABASE vivodb;

CREATE SCHEMA vivo;

CREATE TABLE vivo.usuario
(
    id            bigserial NOT NULL PRIMARY KEY,
    nome          character varying(150),
    email         character varying(100),
    cpf           character varying(14),
    telefone      character varying(11),
    senha         character varying(255),
    data_cadastro date default now()
);

INSERT INTO vivo.usuario (id, nome, email, cpf, telefone, senha, data_cadastro)
VALUES (1, "Brock Reed", "nonummy@protonmail.ca", "044.943.930-53", "19999999999", "JQA88GTF6LB", "01/01/2022"),
       (2, "Raphael Mcgee", "id.risus@google.org", "706.017.050-25", "19999999999", "QIQ88JCO6NC", "01/01/2022"),
       (3, "Chava Mcclure", "nunc.risus.varius@yahoo.com", "413.370.480-03", "19999999999", "HWO98GUR9WJ",
        "01/01/2022"),
       (4, "Regina Bright", "felis.eget@google.org", "096.372.380-42", "19999999999", "TBR84NRN4LJ", "01/01/2022"),
       (5, "Darrel Dawson", "cras.dolor.dolor@yahoo.org", "948.586.390-02", "19999999999", "ISL66WIZ2PY", "01/01/2022"),
       (6, "Dylan Kane", "lacus.nulla.tincidunt@aol.edu", "332.594.723-98", "19999999999", "UFU63HYS5OB", "01/01/2022"),
       (7, "Wylie Mullins", "suspendisse.sed.dolor@icloud.com", "243.474.303-02", "19999999999", "CKS80RHW4UC",
        "01/01/2022"),
       (8, "Lawrence Kelley", "sed.sapien@outlook.org", "068.560.871-95", "19999999999", "ILN13EOO2JM", "01/01/2022"),
       (9, "Jessica Hobbs", "gravida.praesent@outlook.couk", "615.332.336-75", "19999999999", "SEK48ZDW3TV",
        "01/01/2022"),
       (10, "Aimee Swanson", "magna@google.org", "534.460.541-20", "19999999999", "LMO68IXP3SD", "01/01/2022");
