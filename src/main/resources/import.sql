-- Inserindo dados na tabela Usuario:
INSERT INTO USUARIO (id, nome, email, senha) VALUES (1, 'Usuario A', 'usuarioa@example.com', 'senha123');
INSERT INTO USUARIO (id, nome, email, senha) VALUES (2, 'Usuario B', 'usuariob@example.com', 'senha456');
INSERT INTO USUARIO (id, nome, email, senha) VALUES (3, 'Usuario C', 'usuarioc@example.com', 'senha789');
INSERT INTO USUARIO (id, nome, email, senha) VALUES (4, 'Usuario D', 'usuariod@example.com', 'senha101');
INSERT INTO USUARIO (id, nome, email, senha) VALUES (5, 'Usuario E', 'usuarioe@example.com', 'senha202');

-- Inserindo dados na tabela Fornecedor:
INSERT INTO FORNECEDOR (id, nome, telefone, endereco) VALUES ('0ce1c77e-8961-4c77-8f12-382346223b8f', 'Fornecedor A', '(011) 9 1111-1111', 'Endereço A');
INSERT INTO FORNECEDOR (id, nome, telefone, endereco) VALUES ('92a26808-0c96-494e-88b4-e6d8191b0d34', 'Fornecedor B', '(011) 9 2222-2222', 'Endereço B');
INSERT INTO FORNECEDOR (id, nome, telefone, endereco) VALUES ('8cfc0652-57f5-4e49-ab19-8af8510ce863', 'Fornecedor C', '(021) 9 3333-3333', 'Endereço C');
INSERT INTO FORNECEDOR (id, nome, telefone, endereco) VALUES ('de046233-374c-457a-b53b-0b5f842baf2f', 'Fornecedor D', '(031) 9 4444-4444', 'Endereço D');
INSERT INTO FORNECEDOR (id, nome, telefone, endereco) VALUES ('85dcdddc-9e14-4d78-89ce-f809cb608504', 'Fornecedor E', '(031) 9 5555-5555', 'Endereço E');

-- Inserindo dados na tabela Filial:
INSERT INTO FILIAL (cnpj, nome, telefone, endereco) VALUES ('11.111.111/0001-01', 'Filial 1', '(011) 9 4441-4441', 'Avenida 1, 100');
INSERT INTO FILIAL (cnpj, nome, telefone, endereco) VALUES ('22.222.222/0001-02', 'Filial 2', '(011) 9 3332-3332', 'Avenida 2, 200');
INSERT INTO FILIAL (cnpj, nome, telefone, endereco) VALUES ('33.333.333/0001-03', 'Filial 3', '(021) 9 2223-2223', 'Avenida 3, 300');
INSERT INTO FILIAL (cnpj, nome, telefone, endereco) VALUES ('44.444.444/0001-04', 'Filial 4', '(031) 9 1114-1114', 'Avenida 4, 400');
INSERT INTO FILIAL (cnpj, nome, telefone, endereco) VALUES ('55.555.555/0001-05', 'Filial 5', '(031) 9 0005-0005', 'Avenida 5, 500');

-- Inserindo dados na tabela Produto:
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('f8bba9fb-b949-4229-b7b2-2d345bf42ea7', '0ce1c77e-8961-4c77-8f12-382346223b8f', 'Produto A1');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('889affe4-c2df-4139-b947-6bf80f5e1304', '92a26808-0c96-494e-88b4-e6d8191b0d34', 'Produto B1');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('740086f1-bb5f-4f52-9e63-d02ad1e79ac5', '8cfc0652-57f5-4e49-ab19-8af8510ce863', 'Produto C1');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('109aeedc-efbc-4589-bc14-4bd6bb0ff0b0', 'de046233-374c-457a-b53b-0b5f842baf2f', 'Produto D1');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('4fb2bc44-63e7-4daa-99ff-fd04da39a0e5', '85dcdddc-9e14-4d78-89ce-f809cb608504', 'Produto E1');

INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('4d1a5f0e-9f08-4816-93b2-552abb90c415', '0ce1c77e-8961-4c77-8f12-382346223b8f', 'Produto A2');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('f47ed78d-5303-4539-bf21-0c0e04f505a3', '92a26808-0c96-494e-88b4-e6d8191b0d34', 'Produto B2');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('caa98c62-2e52-41a0-8442-e2c35c4fdffd', '8cfc0652-57f5-4e49-ab19-8af8510ce863', 'Produto C2');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('aa99825f-2f0b-48fc-a987-7682f69ffcc7', 'de046233-374c-457a-b53b-0b5f842baf2f', 'Produto D2');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('ac178376-193c-41d8-91c1-80c3fe7a1fcf', '85dcdddc-9e14-4d78-89ce-f809cb608504', 'Produto E2');

INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('dd1aeaa1-c3ac-4ed4-b23c-983b3b445a33', '0ce1c77e-8961-4c77-8f12-382346223b8f', 'Produto A3');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('399e02a5-376d-4e3e-98f6-b01a158217d5', '92a26808-0c96-494e-88b4-e6d8191b0d34', 'Produto B3');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('9aa9dbfb-4576-42fd-a5e3-74b16c61e58a', '8cfc0652-57f5-4e49-ab19-8af8510ce863', 'Produto C3');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('81e8d27c-d2c5-40c4-b074-4deeb0e84ed8', 'de046233-374c-457a-b53b-0b5f842baf2f', 'Produto D3');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('2aa4c0dc-509c-422e-8512-c992ff28c48c', '85dcdddc-9e14-4d78-89ce-f809cb608504', 'Produto E3');

INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('1520133b-26f4-4be5-93cb-bf0ee4085c56', '0ce1c77e-8961-4c77-8f12-382346223b8f', 'Produto A4');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('f4783e03-7b7b-4203-b36e-eef4c07f3ae9', '92a26808-0c96-494e-88b4-e6d8191b0d34', 'Produto B4');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('63e7f4d6-caae-4c39-b997-b7773d02c2b0', '8cfc0652-57f5-4e49-ab19-8af8510ce863', 'Produto C4');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('eec2d158-c4ff-46c2-9b7f-02d7b26e77c6', 'de046233-374c-457a-b53b-0b5f842baf2f', 'Produto D4');
INSERT INTO PRODUTO (id, id_fornecedor, nome) VALUES ('967a4c99-0a25-4269-8852-d2d367c25356', '85dcdddc-9e14-4d78-89ce-f809cb608504', 'Produto E4');

-- Inserindo dados na tabela Identificacao:
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('f8bba9fb-b949-4229-b7b2-2d345bf42ea7', 'Descrição do produto 1', 'Observacao do produto 1');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('889affe4-c2df-4139-b947-6bf80f5e1304', 'Descrição do produto 2', 'Observacao do produto 2');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('740086f1-bb5f-4f52-9e63-d02ad1e79ac5', 'Descrição do produto 3', 'Observacao do produto 3');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('109aeedc-efbc-4589-bc14-4bd6bb0ff0b0', 'Descrição do produto 4', 'Observacao do produto 4');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('4fb2bc44-63e7-4daa-99ff-fd04da39a0e5', 'Descrição do produto 5', 'Observacao do produto 5');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('4d1a5f0e-9f08-4816-93b2-552abb90c415', 'Descrição do produto 6', 'Observacao do produto 6');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('f47ed78d-5303-4539-bf21-0c0e04f505a3', 'Descrição do produto 7', 'Observacao do produto 7');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('caa98c62-2e52-41a0-8442-e2c35c4fdffd', 'Descrição do produto 8', 'Observacao do produto 8');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('aa99825f-2f0b-48fc-a987-7682f69ffcc7', 'Descrição do produto 9', 'Observacao do produto 9');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('ac178376-193c-41d8-91c1-80c3fe7a1fcf', 'Descrição do produto 10', 'Observacao do produto 10');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('dd1aeaa1-c3ac-4ed4-b23c-983b3b445a33', 'Descrição do produto 11', 'Observacao do produto 11');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('399e02a5-376d-4e3e-98f6-b01a158217d5', 'Descrição do produto 12', 'Observacao do produto 12');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('9aa9dbfb-4576-42fd-a5e3-74b16c61e58a', 'Descrição do produto 13', 'Observacao do produto 13');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('81e8d27c-d2c5-40c4-b074-4deeb0e84ed8', 'Descrição do produto 14', 'Observacao do produto 14');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('2aa4c0dc-509c-422e-8512-c992ff28c48c', 'Descrição do produto 15', 'Observacao do produto 15');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('1520133b-26f4-4be5-93cb-bf0ee4085c56', 'Descrição do produto 16', 'Observacao do produto 16');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('f4783e03-7b7b-4203-b36e-eef4c07f3ae9', 'Descrição do produto 17', 'Observacao do produto 17');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('63e7f4d6-caae-4c39-b997-b7773d02c2b0', 'Descrição do produto 18', 'Observacao do produto 18');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('eec2d158-c4ff-46c2-9b7f-02d7b26e77c6', 'Descrição do produto 19', 'Observacao do produto 19');
INSERT INTO IDENTIFICACAO (id_produto, descricao, observacao) VALUES ('967a4c99-0a25-4269-8852-d2d367c25356', 'Descrição do produto 20', 'Observacao do produto 20');

-- Inserindo dados na tabela ESTOQUE:
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('f8bba9fb-b949-4229-b7b2-2d345bf42ea7', '11.111.111/0001-01', 12.50, 100, '2025-12-31');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('889affe4-c2df-4139-b947-6bf80f5e1304', '22.222.222/0001-02', 19.90, 50, '2026-01-15');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('740086f1-bb5f-4f52-9e63-d02ad1e79ac5', '33.333.333/0001-03', 8.75, 200, '2025-10-10');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('109aeedc-efbc-4589-bc14-4bd6bb0ff0b0', '44.444.444/0001-04', 25.00, 80, '2026-03-30');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('4fb2bc44-63e7-4daa-99ff-fd04da39a0e5', '55.555.555/0001-05', 15.20, 120, '2025-11-20');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('4d1a5f0e-9f08-4816-93b2-552abb90c415', '11.111.111/0001-01', 13.60, 90, '2026-02-15');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('f47ed78d-5303-4539-bf21-0c0e04f505a3', '22.222.222/0001-02', 17.40, 70, '2026-06-01');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('caa98c62-2e52-41a0-8442-e2c35c4fdffd', '33.333.333/0001-03', 11.90, 110, '2025-09-01');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('aa99825f-2f0b-48fc-a987-7682f69ffcc7', '44.444.444/0001-04', 22.80, 60, '2026-05-25');
INSERT INTO ESTOQUE (id_produto, cnpj_filial, preco, quantidade, validade) VALUES ('ac178376-193c-41d8-91c1-80c3fe7a1fcf', '55.555.555/0001-05', 18.30, 140, '2025-08-18');
