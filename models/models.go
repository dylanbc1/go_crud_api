package models

import (
	"gorm.io/gorm"
)

type Place struct {
	gorm.Model
	Name     string
	Capacity int
}
