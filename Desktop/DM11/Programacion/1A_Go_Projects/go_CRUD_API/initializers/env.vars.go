package initializers

import (
	"log"

	"github.com/joho/godotenv"
)

// función inicia en mayúscula
func EnvVars() {
	// usamos la librería godotenv
	// para cargar las variables de entorno
	// .Load devuelve un error si no pudo cargarse
	err := godotenv.Load()

	// si el error es distinto de nulo, soltamos msj
	if err != nil {
		log.Fatal("Error loading .env file")
	}
}
