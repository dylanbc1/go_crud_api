#!/bin/bash

# Número de clientes a simular
NUM_CLIENTS=30
# Número de solicitudes por cliente
NUM_REQUESTS=1000

# Dirección y puerto del servidor
SERVER_HOST="localhost"
SERVER_PORT=8000

# Función para simular un cliente
simulate_client() {
    for ((i = 1; i <= NUM_REQUESTS; i++)); do
        echo -e "10000000000000"| java -jar client/build/libs/client.jar
    done
}


# Esperar a que el servidor se inicie

sleep 3

# Simular múltiples clientes en segundo plano y almacenar los PID en un arreglo
declare -a CLIENT_PIDS
for ((i = 1; i <= NUM_CLIENTS; i++)); do
    simulate_client "$i" &
    CLIENT_PIDS+=($!)  # Almacena el PID del cliente en el arreglo
done

# Esperar a que los clientes completen
for pid in "${CLIENT_PIDS[@]}"; do
    wait $pid
done

pkill -f "java -jar server/build/libs/server.jar"