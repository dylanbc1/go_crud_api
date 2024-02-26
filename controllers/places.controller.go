package controllers

import (
	"github.com/dylanbc1/go_crud_api/initializers"
	"github.com/dylanbc1/go_crud_api/models"
	"github.com/gin-gonic/gin"
)

func PlacesGet(c *gin.Context) {
	// buscamos los places
	var places []models.Place

	initializers.DB.Find(&places)

	// retornamos los places
	c.JSON(200, gin.H{
		"places": places,
	})
}

func PlacesCreate(c *gin.Context) {
	// obtener los datos del req body
	var body struct {
		Name string
		Capacity int 
	}

	c.Bind(&body)

	// crear un espacio
	place := models.Place{Name: body.Name, Capacity: body.Capacity}
	result := initializers.DB.Create(&place)

	if result.Error != nil {
		c.Status(400)
		return
	}

	// retornar
	c.JSON(200, gin.H{
		"place": place,
	})
}