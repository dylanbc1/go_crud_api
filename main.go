package main

import (
	"github.com/dylanbc1/go_crud_api/controllers"
	"github.com/dylanbc1/go_crud_api/initializers"
	"github.com/gin-gonic/gin"
)

func init() {
	initializers.EnvVars()
	initializers.ConnectToDB()
}

func main() {
	r := gin.Default() // es el motor de Gin
	// que es el enrutador principal

	// Configurar CORS
	r.Use(func(c *gin.Context) {
		c.Writer.Header().Set("Access-Control-Allow-Origin", "*")
		c.Writer.Header().Set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
		c.Writer.Header().Set("Access-Control-Allow-Headers", "Content-Type")
		if c.Request.Method == "OPTIONS" {
			c.AbortWithStatus(204)
			return
		}
		c.Next()
	})

	r.POST("/espacios", controllers.PlacesCreate)
	r.GET("/espacios", controllers.PlacesGet)
	r.GET("/espacios/:id", controllers.PlacesGetById)
	r.PUT("/espacios/:id", controllers.PlacesUpdate)
	r.DELETE("/espacios/:id", controllers.PlacesDelete)

	r.Run()
}
