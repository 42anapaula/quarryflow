-- V1__criar_tabelas_fase1.sql
-- Script de Migração Inicial para o ecossistema QuarryFlow

-- 1. Tabela: Cliente (RF01)
CREATE TABLE client (
    id UUID PRIMARY KEY,
    document VARCHAR(14) NOT NULL,
    social_name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_client_document UNIQUE (document)
);

-- 2. Tabela: Contrato (RF01)
CREATE TABLE contract (
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    credit_limit NUMERIC(12, 2) NOT NULL,
    available_balance NUMERIC(12, 2) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    CONSTRAINT fk_contract_client FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE RESTRICT
);

-- 3. Tabela: Material / Catálogo de Agregados (RF02)
-- Criada aqui porque a tabela intermediária item_contrato depende dela
CREATE TABLE material (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock NUMERIC(12, 3) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT uk_material_name UNIQUE (name)
);

-- 4. Tabela: ItemContrato / Tabela de Preços Dinâmica (RF01)
CREATE TABLE item_contract (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL,
    material_id UUID NOT NULL,
    agreed_price NUMERIC(10, 2) NOT NULL,
    CONSTRAINT fk_item_contract_contract FOREIGN KEY (contract_id) REFERENCES contract(id) ON DELETE CASCADE,
    CONSTRAINT fk_item_contract_material FOREIGN KEY (material_id) REFERENCES material(id) ON DELETE RESTRICT,
    CONSTRAINT uk_item_contract_material UNIQUE (contract_id, material_id)
);

-- 5. Tabela: Veiculo (RF03)
CREATE TABLE vehicle (
    plate VARCHAR(7) PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    tara NUMERIC(10, 2) NOT NULL,
    capacity NUMERIC(5, 2) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Criando índices estratégicos para otimizar as consultas futuras do BFF GraphQL (Fase 4)
CREATE INDEX idx_contract_client ON contract(client_id);
CREATE INDEX idx_item_contract_contract ON item_contract(contract_id);