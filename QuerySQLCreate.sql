CREATE TABLE clientes (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          nome TEXT NOT NULL,
                          cpf TEXT UNIQUE NOT NULL,
                          telefone TEXT,
                          email TEXT
);

CREATE TABLE imoveis (
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         endereco TEXT NOT NULL,
                         tipo TEXT NOT NULL,
                         quartos INTEGER,
                         banheiros INTEGER,
                         area REAL,
                         valor_aluguel REAL NOT NULL,
                         disponivel BOOLEAN DEFAULT 1
);

CREATE TABLE contratos(
                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                           id_cliente INTEGER NOT NULL,
                           id_imovel INTEGER NOT NULL,
                           valor REAL NOT NULL,
                           data_inicio DATE NOT NULL,
                           data_fim DATE NOT NULL,
                           ativo BOOLEAN DEFAULT 1,
                           FOREIGN KEY (id_cliente) REFERENCES clientes(id),
                           FOREIGN KEY (id_imovel) REFERENCES imoveis(id)
);