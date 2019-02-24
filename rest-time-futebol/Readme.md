# Comandos Curl (Windows)

#### Adiciona time
curl -X POST http://localhost:8080/times -H "Content-Type: application/json" -d "{\\"nome\\":\\"Santos\\"}"

#### Adiciona jogador
curl -X POST http://localhost:8080/jogadores -H "Content-Type: application/json" -d "{ \\"nome\\": \\"Allejo\\", \\"cidade\\": \\"Santos\\", \\"pais\\": \\"Brasil\\", \\"posicao\\": \\"ATAQUE\\", \\"gols\\": 1000 }"

#### Adiciona Jogador
curl -X POST http://localhost:8080/jogadores -H "Content-Type: application/json" -d "{ \\"nome\\": \\"Gomez\\", \\"cidade\\": \\"Santos\\", \\"pais\\": \\"Brasil\\", \\"posicao\\": \\"ATAQUE\\", \\"gols\\": 2 }"

#### Adiciona Jogador
curl -X POST http://localhost:8080/jogadores -H "Content-Type: application/json" -d "{ \\"nome\\": \\"Neymar\\", \\"cidade\\": \\"Santos\\", \\"pais\\": \\"Brasil\\", \\"posicao\\": \\"ATAQUE\\", \\"gols\\": 33 }"

#### Adiciona Jogador
curl -X POST http://localhost:8080/jogadores -H "Content-Type: application/json" -d "{ \\"nome\\": \\"DaSilva\\", \\"cidade\\": \\"Santos\\", \\"pais\\": \\"Brasil\\", \\"posicao\\": \\"GOLEIRO\\", \\"gols\\": 0 }"

#### Associacao Jogador 1 / Time 1
curl -X PUT http://localhost:8080/jogadores/1/time -H "Content-Type: text/uri-list" -d http://localhost:8080/times/1

#### Associacao Jogador 2 / Time 1
curl -X PUT http://localhost:8080/jogadores/2/time -H "Content-Type: text/uri-list" -d http://localhost:8080/times/1

#### Associacao Jogador 3 / Time 1
curl -X PUT http://localhost:8080/jogadores/3/time -H "Content-Type: text/uri-list" -d http://localhost:8080/times/1

#### Associacao Jogador 4 / Time 1
curl -X PUT http://localhost:8080/jogadores/4/time -H "Content-Type: text/uri-list" -d http://localhost:8080/times/1

#### Quantidade jogadores no time 1
curl -X GET http://localhost:8080/times/1/total

#### Jogadores na posicao ATAQUE
curl -X GET http://localhost:8080/times/1/posicao/ATAQUE

#### Jogadores na posicao GOLEIRO
curl -X GET http://localhost:8080/times/1/posicao/GOLEIRO

#### Jogadores por posicao
curl -X GET http://localhost:8080/times/1/posicao

#### Jogadores ordenados por gols do time 1
curl -X GET http://localhost:8080/times/1/bygols

#### Jogadores gol no Fantastico
curl -X GET http://localhost:8080/times/1/fantastico

#### Jogador Artilheiro do time 1
curl -X GET http://localhost:8080/times/1/artilheiro


# Referências

- https://javacodehouse.com/blog/mockito-tutorial/
- https://www.baeldung.com/hamcrest-collections-arrays
