class Director:

    def __init__(self, name, genre, birth_date, death_date):
        self.name = name
        self.genre = genre
        self.birth_date = birth_date
        self.death_date = death_date

    # Getters
    def get_name(self):
        return self.name

    def get_genre(self):
        return self.genre

    def get_birth_date(self):
        return self.birth_date

    def get_death_date(self):
        return self.death_date

    # Setters
    def set_name(self, name):
        self.name = name

    def set_genre(self, genre):
        self.genre = genre

    def set_birth_date(self, birth_date):
        self.birth_date = birth_date

    def set_death_date(self, death_date):
        self.death_date = death_date
