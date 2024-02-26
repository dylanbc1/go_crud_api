package controllers

import (
	"github.com/dylanbc1/go_crud_api/initializers"
	"github.com/dylanbc1/go_crud_api/models"
	"github.com/gin-gonic/gin"
)

// c gin.Context que me da el contexto e información de la
// solicitud HTTP y permite obtener datos y responder

func PlacesDelete(c *gin.Context) {
	// obtener el id
	id := c.Param("id")

	// eliminar ese place
	initializers.DB.Delete(&models.Place{}, id)

	// return
	c.Status(200)
}

func PlacesUpdate(c * gin.Context){
	// obtener ID de parámetros de la URL
	id := c.Param("id")

	// obtener datos del body
	var body struct {
		Name string
		Capacity int 
	}

	c.Bind(&body)

	// encontrar el place que vamos a updatear
	var place models.Place

	initializers.DB.First(&place, id)

	if place.ID == 0 {
		c.JSON(400, gin.H {
			"message": "Not found",
		})
	} else {
		// updatearlo
		initializers.DB.Model(&place).Updates(models.Place{
			Name: body.Name,
			Capacity: body.Capacity,
		})

		// retornar
		c.JSON(200, gin.H{
			"place": place,
		})
	}
}

func PlacesGetById(c *gin.Context) {
	// obtener ID de parámetros de la url
	id := c.Param("id")

	// obtener ese place
	var place models.Place

	// al manipular con la DB usando la variable
	// esta se modifica con el resultado de la operación
	initializers.DB.First(&place, id)

	// retornar
	if place.ID == 0 {
		c.JSON(400, gin.H {
			"message": "Not found",
		})
	} else {
		c.JSON(200, gin.H{
			"place": place,
		})
	}
}

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