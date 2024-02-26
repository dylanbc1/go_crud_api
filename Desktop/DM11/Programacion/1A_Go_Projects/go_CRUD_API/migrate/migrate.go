package main

import (
	"github.com/dylanbc1/go_crud_api/initializers"
	"github.com/dylanbc1/go_crud_api/models"
)

func init() {
	initializers.EnvVars()
	initializers.ConnectToDB()
}

func main() {
	initializers.DB.AutoMigrate(&models.Place{})
}
