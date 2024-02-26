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

	r.POST("/espacios", controllers.PlacesCreate)
	r.GET("/espacios", controllers.PlacesGet)
	r.GET("/espacios/:id", controllers.PlacesGetById)
	r.PUT("/espacios/:id", controllers.PlacesUpdate)
	r.DELETE("/espacios/:id", controllers.PlacesDelete)
	
	r.Run()
}
