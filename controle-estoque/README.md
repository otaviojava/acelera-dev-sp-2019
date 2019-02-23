## Controle de Estoque

### Host

`http://localhost:8090/v1/produto`

### Verbos

`@POST - /`

Exemplo Body:

```json
{
 	"nome": "nome",
 	"quantidade": 1
}
```

`@GET - /all`

Exemplo Response:

```json
[
	{
	 	"id": 1,
	 	"nome": "nome",
	 	"quantidade": 1
	}
]
```

`@GET - /{id}`

Exemplo Response:

```json
{
 	"id": 1,
 	"nome": "nome",
 	"quantidade": 1
}
```

`@DELETE - /{id}`

Exemplo Response:

```json
{
	"code": 200,
	"message": "OK"
}
```


