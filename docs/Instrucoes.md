# API de Armazenamento - Documentação

## Visão Geral

Esta API é responsável por gerenciar o upload, download, exclusão e consulta de arquivos no Azure Storage. 
Ela permite a organização dos arquivos por "source" (origem) e "product" (produto) para uma melhor 
separação e categorização dos dados armazenados.

---

## Endpoints

### 1. **Upload de Arquivo**

**Endpoint:** `POST /api/storage/v1/upload`

**Descrição:** Este endpoint permite o upload de arquivos para o Azure Storage.

#### Parâmetros:
- **file** (MultipartFile) - O arquivo a ser enviado.
- **nameFile** (String) - Nome do arquivo.
- **typeFile** (String) - Tipo do arquivo.
- **description** (String, opcional) - Descrição do arquivo.
- **source** (SourceEnum) - Origem do arquivo.
- **product** (String) - Produto relacionado ao arquivo.

#### Resposta:
- **Código de Status:** `201 Created`
- **Corpo:** Um objeto `StorageResponse` contendo informações do arquivo enviado.

#### Exemplo de Corpo da Requisição:

```bash
curl -X POST "http://localhost:8080/api/storage/v1/upload" \
  -H "Content-Type: multipart/form-data" \
  -F "file=@path/to/file" \
  -F "nameFile=testfile" \
  -F "typeFile=image/jpeg" \
  -F "description=Sample file" \
  -F "source=COST_CENTER_BH" \
  -F "product=finance"
```

### 2. **Obter Arquivo pelo ID**

**Endpoint:** `GET /api/storage/v1/{id}`

**Descrição:** Este endpoint recupera informações de um arquivo armazenado no Azure Storage com base no ID.

#### Parâmetros:
- **id** (String) - ID do arquivo.

#### Resposta:
- **Código de Status:** `200 OK`
- **Corpo:** Um objeto `StorageResponse` contendo informações do arquivo enviado.

#### Exemplo de Corpo da Requisição:

```bash
curl -X GET "http://localhost:8080/api/storage/v1/12345"
```

### 3. **Download de Arquivo pelo ID**

**Endpoint:** `GET /api/storage/v1/download/{id}`

**Descrição:** Este endpoint permite o download de um arquivo armazenado no Azure Storage pelo seu ID.

#### Parâmetros:
- **id** (String) - ID do arquivo.

#### Resposta:
- **Código de Status:** `200 OK`
- **Corpo:** Arquivo binário, dependendo do tipo de arquivo.

#### Exemplo de Corpo da Requisição:

```bash
curl -X GET "http://localhost:8080/api/storage/v1/download/12345" --output arquivo-baixado
```


### **Composição do Nome do Arquivo**

O nome do arquivo é gerado de acordo com a seguinte estrutura:

``{source}/{product}/{nameFile}``

**Onde:**
**source:** Origem do arquivo (definida pelo parâmetro `source`).
**product:** Produto relacionado ao arquivo (definido pelo parâmetro `product`).
**nameFile:** Nome do arquivo (definido pelo parâmetro `nameFile`).