package main

import (
	"github.com/dylanbc1/go_crud_api/initializers"
	"github.com/gin-gonic/gin"
	"github.com/dylanbc1/go_crud_api/controllers"
)

func init() {
	initializers.EnvVars()
	initializers.ConnectToDB()
}

func main() {
	r := gin.Default() // es el motor de Gin
	// que es el enrutador principal

	r.GET("/espacios", controllers.PlacesGet)
	r.POST("/espacios", controllers.PlacesCreate)
	// hasta aqui llega la función anónima con parámetro
	// c gin.Context que me da el contexto e información de la
	// solicitud HTTP y permite obtener datos y responder

	r.Run()
}
