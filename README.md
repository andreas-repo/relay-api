# relay-api project

A rest API which allows the control of 4 relays via http.

## API endpoints

GET http://{{hostname}}:8080/relay/start/{{id}} <= closes the circuit and lets power flow to the submerged pump number {{id}}
GET http://{{hostname}}:8080/relay/stop/{{id}} <= opens the circuit and cuts off the power flow to the submerged pump numberh {{id}}
