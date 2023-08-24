class Pelicula:

    def __init__(self, director, genre, year):
        self.director = director
        self.genre = genre
        self.year = year

    # Getters

    def get_director(self):
        return self.director

    def get_genre(self):
        return self.genre

    def get_year(self):
        return self.year

    # Setters

    def set_director(self, dire):
        self.director = dire

    def set_genre(self, genre):
        self.genre = genre

    def set_year(self, year):
        self.year = year
